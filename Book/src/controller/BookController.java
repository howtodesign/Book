package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import service.BookBoardService;
import service.BookService;
import service.CommentService;
import service.EvernoteSubscribeService;
import service.FileService;
import vo.BookBoardVO;
import vo.FileVO;

@Controller
public class BookController {

	@Autowired
	private BookBoardService service;

	@Autowired
	private FileService fservice;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private EvernoteSubscribeService evernoteSubscribeService;
	
	
	@RequestMapping("/horror.do")
	public ModelAndView HorrorPage(@RequestParam(value="p", defaultValue = "1") int p, String bb_code, BookBoardVO vo) {
	
		ModelAndView mv = new ModelAndView();
		mv.addObject("horrorBoardPage", service.makePage(p, bb_code, vo));
		mv.addObject("bb_name", service.selectBBName(bb_code));
		mv.setViewName("horrorBoard");

		return mv;

	}

	@RequestMapping("/writeForm.do")
	public ModelAndView writeForm(String bb_code) {
		ModelAndView mv = new ModelAndView("write_form");
		mv.addObject("bb_code", bb_code);
		return mv;

	}

	@RequestMapping("/write.do")
	@ResponseBody
	public void write(HttpSession session, HttpServletResponse response, HttpServletRequest request,
			@RequestParam("uploadFiles") MultipartFile[] files, BookBoardVO vo) {
		String loginNick = (String) session.getAttribute("loginNick");
		vo.setWriter(loginNick);

		int insertedBoardNum = service.insertedBoardNum(vo);
		
		if(!files[0].isEmpty()){
			fservice.fileUpload(request, files, vo, insertedBoardNum);
		}
		
		try {
			response.sendRedirect("writeResult.do?bookb_num=" + insertedBoardNum + "&bb_code=" + vo.getBb_code());
		} catch (IOException e) {
			System.out.println("글쓰기 실패");
			e.printStackTrace();
		}
	}

	@RequestMapping("/writeResult.do")
	public ModelAndView writeResult(int bookb_num) {

		ModelAndView mv = new ModelAndView("write_result");
		mv.addObject("insertedBoard", service.readWithoutCount(bookb_num));
		mv.addObject("fileList", fservice.getFiles(bookb_num));
		return mv;
	}

	@RequestMapping("/read.do")
	@ResponseBody
	public void read(HttpServletRequest request, HttpServletResponse response) {
		int bookb_num = Integer.parseInt(request.getParameter("bookb_num"));
		int p = Integer.parseInt(request.getParameter("p"));
		int n = Integer.parseInt(request.getParameter("n"));
		//String bb_code = request.getParameter("bb_code");
		service.readWithReadCount(bookb_num);
		try {
			response.sendRedirect("readResult.do?b="+bookb_num+
					"&p="+p+"&n="+n);
		} catch (IOException e) {
			System.out.println("글읽기 실패");
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/readResult.do")
	public ModelAndView readResult(int b, int p, int n) {
		ModelAndView mv = new ModelAndView("read");
		mv.addObject("readBoard", service.readWithoutCount(b));
		mv.addObject("page", p);
		mv.addObject("num", n);
		mv.addObject("fileList", fservice.getFiles(b));
		return mv;
	}
	
	
	@RequestMapping("/download.do")
	@ResponseBody
	public void download(int file_num, int bookb_num, HttpServletResponse response) throws UnsupportedEncodingException {
		FileVO vo = fservice.getFile(file_num);
		System.out.println(vo);

		String filename = vo.getOriginal_name();
		String encodedFileName = "";
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < filename.length(); i++) {

			char c = filename.charAt(i);
			if (c > '~') {
				sb.append(URLEncoder.encode("" + c, "UTF-8"));
			} else {
				sb.append(c);
			}
			encodedFileName = sb.toString();
			response.setHeader("Content-Disposition", "attachment; filename=\"" + encodedFileName + "\"");

			try {
				FileInputStream is = new FileInputStream(vo.getSaved_path());
				ServletOutputStream os = response.getOutputStream();
				int data = 0;
				while ((data = is.read()) != -1) {
					os.write(data);
				}
				is.close();
				os.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {

			}

		}

	}

	@RequestMapping("/comment.do")
	@ResponseBody
    public void insertComment(@RequestParam(value="con", defaultValue="0")int comment_num, HttpServletRequest request,HttpServletResponse response) throws Exception {//ajax는 void형 함수를 사용한다.
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Map<String, Object> map = commentService.insertComment(comment_num, request);
        
        int result = (int) map.get("result");
        out.println(result);        
    }

	
	@RequestMapping(value="/commentList.do")
	@ResponseBody
    public void commentList(HttpServletRequest request, HttpServletResponse response) throws Exception {//ajax는 void형 함수를 사용한다.
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Map<String,Object> map = commentService.serviceCmt(request);
        String result = (String) map.get("AjaxMember");
        System.out.println(result+"------------------------------");
        out.println(result);        
    }



	@RequestMapping("/bookPage.do")
	public String bookPage() {
		return "book_page";
	}

	@RequestMapping(value = "/bookSearch.do")
	@ResponseBody 
	public String bookSearch(String keyword) throws UnsupportedEncodingException {

		return URLEncoder.encode(bookService.bookSearch(keyword), "UTF-8");

	}
	

	@RequestMapping("/processUpDown.do")
	@ResponseBody
	public void processUpDown(String code, int bookb_num, String bb_code, HttpServletResponse response, HttpSession session){
		
		String bookJson;
		String loginNick = (String) session.getAttribute("loginNick");
		
		BookBoardVO bookboard = service.processUpDown(code, bookb_num, bb_code, loginNick);
		
		if(bookboard != null){
	        bookJson = "{\"recommend\":\""+bookboard.getRecommend()
	                    +"\",\"opposite\":\""+bookboard.getOpposite()+"\"}";
	    }else{
	        bookJson = "null";
	    }

	    try {
	        response.getWriter().print(bookJson);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }   
	}

	
	@RequestMapping(value="/everNote.do")
	public String everNote(HttpServletRequest request) {
		evernoteSubscribeService.service(request);
	return "note_success";
	}
	
	
	

}
