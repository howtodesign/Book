package service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import repository.FileDAO;
import vo.BookBoardVO;
import vo.FileVO;

@Component
public class FileService {

	@Autowired
	private FileDAO dao;
	
	public void fileUpload(HttpServletRequest request, MultipartFile[] files, BookBoardVO vo, 
			int insertedBoardNum){
		
				//String dirPath = "c:/springFiles/";
				String dirPath = request.getServletContext().getRealPath("/resource/img/");
				File dir = new File(dirPath);

				if(dir.exists() == false) {
					dir.mkdir();
				}

				List<FileVO> fileList = new ArrayList<>();
				for (MultipartFile f : files) {
					String savedName = new Random().nextInt(1000000000) + "";
					String originalName = f.getOriginalFilename();
					String savedPath = dirPath +savedName;
					String bb_code = vo.getBb_code();
					FileVO myFile = new FileVO();

					myFile.setBookb_num(insertedBoardNum);
					myFile.setOriginal_name(originalName);
					myFile.setSaved_path(savedPath);
					myFile.setBb_code(bb_code);

					File savedFile = new File(savedPath);

					try {
						f.transferTo(savedFile);
						dao.insertFile(myFile);
						fileList.add(myFile);
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
				
	}
	
	public List<FileVO> getFiles(int bookb_num){
		return dao.selectAll(bookb_num);
	}
	
	public FileVO getFile(int file_num){
		return dao.selectFile(file_num);
	}
}
