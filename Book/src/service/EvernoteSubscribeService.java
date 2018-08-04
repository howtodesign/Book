package service;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.evernote.auth.EvernoteAuth;
import com.evernote.auth.EvernoteService;
import com.evernote.clients.ClientFactory;
import com.evernote.clients.NoteStoreClient;
import com.evernote.edam.type.Data;
import com.evernote.edam.type.Note;
import com.evernote.edam.type.Resource;
import com.evernote.edam.type.ResourceAttributes;

import repository.FileDAO;
import repository.BookBoardDAO;
import vo.FileVO;
import vo.BookBoardVO;;


@Component
public class EvernoteSubscribeService {
	
	@Autowired
	private BookBoardDAO dao;
	
	@Autowired
	private FileDAO fileDAO;
	
	private void writeIn(String title, String content, List<FileVO> fileList) throws Exception{
		String developerToken = "S=s1:U=94ca7:E=16c57dccece:C=165002ba140:P=1cd:A=en-devtoken:V=2:H=bbc0932a3e785095decd9d064e408cc8";
		EvernoteAuth evernoteAuth = new EvernoteAuth(EvernoteService.SANDBOX, developerToken);
		ClientFactory factory = new ClientFactory(evernoteAuth);
		NoteStoreClient noteStore = factory.createNoteStoreClient();
		
		Note note = new Note();
		note.setTitle(title);
		
		String mimeType = "image/png";
		
		Resource resource = new Resource();
		
		if(!fileList.isEmpty()) {
			for(int i=0; i<fileList.size(); i++) {
				System.out.println(fileList.get(i).getSaved_path());
				resource.setData(readFileAsData(fileList.get(i).getSaved_path()));
				resource.setMime(mimeType);
				ResourceAttributes attributes = new ResourceAttributes();
				attributes.setFileName(fileList.get(i).getOriginal_name());
				resource.setAttributes(attributes);
				note.addToResources(resource);
			}
			
		}
		
		
		String hashHex = bytesToHex(resource.getData().getBodyHash());
		
		 String xmlContent = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
		            + "<!DOCTYPE en-note SYSTEM \"http://xml.evernote.com/pub/enml2.dtd\">"
		            + "<en-note>"
		            + "<span style=\"color:green;\"> 스크랩 한 글"+content+"</span><br/>"
		            + "<en-media type=\"image/png\" hash=\"" + hashHex + "\"/>"
		            + "</en-note>";


				
		note.setContent(xmlContent);
		
		Note createdNote = noteStore.createNote(note);
		String newNoteGuid = createdNote.getGuid();
		
		System.out.println("Successfully created a new note with GUID: "+newNoteGuid);
		System.out.println();
	}
	
	 public Map<String, Object> service(HttpServletRequest request){
	  
	        int bookb_num = Integer.parseInt(request.getParameter("bookb_num"));
	        BookBoardVO vo =  dao.selectBoard(bookb_num);
	       
	        List<FileVO> fileList= fileDAO.selectAll(bookb_num);
	        
			for (FileVO fileVO : fileList) {
				String originalName = fileVO.getOriginal_name();
				String savedPath = fileVO.getSaved_path();
			}
			
			
			try {
				
	        	writeIn(vo.getTitle(), vo.getContent(), fileList);
	        }catch(Exception e1) {
	        	e1.printStackTrace();
	        }
	      Map<String, Object> map = new HashMap<>();
	      map.put("page", "main");
	      
	      return map;
	 }
	 
	 private static Data readFileAsData(String filePath) throws Exception {
		 FileInputStream in = new FileInputStream(filePath);
		 ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		 byte[] block = new byte[10240]; 
		 int len; 
		 while((len=in.read(block))>=0) {
			 byteOut.write(block, 0, len);
		 }
		 in.close();
		 byte[] body = byteOut.toByteArray();
		 Data data = new Data();
		 data.setSize(body.length);
		 data.setBodyHash(MessageDigest.getInstance("MD5").digest(body));
		 data.setBody(body);
	 return data;
	 }
	 
	 public static String bytesToHex(byte[] bytes) {
		 StringBuilder sb = new StringBuilder();
		 for(byte hashByte:bytes) {
			 int intVal = 0xff & hashByte;
			 if(intVal<0x10) {
				 sb.append('0');
			 }
			 sb.append(Integer.toHexString(intVal));
		 }
	 return sb.toString();
	 }
}


	