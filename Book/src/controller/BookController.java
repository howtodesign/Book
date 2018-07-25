package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import repository.FileDAO;
import service.BookBoardService;
import vo.BookBoardVO;
import vo.FileVO;



@Controller
public class BookController {

	@Autowired
	private BookBoardService service;
	
	@Autowired
	private FileDAO dao;
	
	
	
	

	@RequestMapping("/main.do")

	public String main(){

		return "main";

	}
	
	@RequestMapping("/horror.do")
	public ModelAndView HorrorPage(@RequestParam(defaultValue="1")int p,String bb_code, HttpSession session, BookBoardVO vo) {
		
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
	/*	String loginId = (String) session.getAttribute("loginId");
		vo.setWriter(loginId);*/
		
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
			myFile.setReal_path(savedPath);
			myFile.setBb_code(bb_code);
			
			File savedFile = new File(savedPath);

			try {
				f.transferTo(savedFile);
				dao.insertFile(myFile);
				fileList.add(myFile);

				response.sendRedirect("writeResult.do?bookb_num="+ insertedBoardNum+"&bb_code="+bb_code);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
