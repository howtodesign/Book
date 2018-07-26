package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

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

import repository.FileDAO;
import service.BookBoardService;
import service.BookService;
import service.CommentService;
import vo.BookBoardVO;
import vo.FileVO;

@Controller
public class BookController {

	@Autowired
	private BookBoardService service;

	@Autowired
	private FileDAO dao;

	@Autowired
	private CommentService commentService;
	
	@Autowired
	private BookService bookService;
	
	
	@RequestMapping("/horror.do")
	public ModelAndView HorrorPage(@RequestParam(defaultValue = "1") int p, String bb_code, HttpSession session,
			BookBoardVO vo) {

		ModelAndView mv = new ModelAndView();
		mv.addObject("horrorBoardPage", service.makePage(p, bb_code, vo));
		mv.setViewName("horrorBoard");

		return mv;

	}

	@RequestMapping("/writeForm.do")
	public String writeForm(HttpSession session) {

		return "write_form";

	}

	@RequestMapping("/write.do")
	public void write(HttpSession session, HttpServletResponse response, HttpServletRequest request,
			@RequestParam("uploadFiles") MultipartFile[] files, BookBoardVO vo) {
		String loginNick = (String) session.getAttribute("loginNick");
		vo.setWriter(loginNick);

		int insertedBoardNum = service.insertedBoardNum(vo, request);

		String dirPath = "c:/springFiles/";

		File dir = new File(dirPath);

		if (dir.exists() == false) {
			dir.mkdir();
		}

		List<FileVO> fileList = new ArrayList<>();
		for (MultipartFile f : files) {
			String savedName = new Random().nextInt(1000000000) + "";
			String savedPath = dirPath + savedName;
			String originalName = f.getOriginalFilename();
			String bb_code = request.getParameter("bb_code");
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

				response.sendRedirect("writeResult.do?bookb_num=" + insertedBoardNum + "&bb_code=" + bb_code);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	@RequestMapping("/writeResult.do")
	public ModelAndView writeResult(int bookb_num) {

		ModelAndView mv = new ModelAndView("write_result");
		mv.addObject("insertedBoard", service.readWithoutCount(bookb_num));
		mv.addObject("fileList", dao.selectAll(bookb_num));
		return mv;
	}

	@RequestMapping("/read.do")
	public ModelAndView read(HttpServletRequest request) {
		int bookb_num = Integer.parseInt(request.getParameter("bookb_num"));
		int p = Integer.parseInt(request.getParameter("p"));
		//String bb_code = request.getParameter("bb_code");
		ModelAndView mv = new ModelAndView("read");
		mv.addObject("readBoard", service.readWithReadCount(bookb_num));
		mv.addObject("page", p);
		mv.addObject("fileList", dao.selectAll(bookb_num));
		return mv;
	}
	
	
	@RequestMapping("/download.do")
	@ResponseBody
	public void download(int file_num, int bookb_num, HttpServletResponse response) throws UnsupportedEncodingException {
		FileVO vo = dao.selectFile(file_num);
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
    public void insertComment(HttpServletRequest request,HttpServletResponse response) throws Exception {//ajax는 void형 함수를 사용한다.
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Map<String, Object> map = commentService.insertComment(request);
        
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
	
}
