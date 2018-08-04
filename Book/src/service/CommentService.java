package service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.BookBoardDAO;
import repository.CommentDAO;
import repository.FileDAO;
import vo.BookBoardVO;
import vo.CommentVO;
import vo.FileVO;

@Component
public class CommentService {

	@Autowired
	private CommentDAO commentDAO;
	
	@Autowired
	private BookBoardDAO dao;
	
	@Autowired
	private FileDAO fileDAO;
	
	@Autowired
	private BookBoardService bookBoardService;

	public Map<String, Object> insertComment(int comment_num, HttpServletRequest request) {
		HttpSession session = request.getSession();
		CommentVO vo = new CommentVO();
		String loginNick = (String) session.getAttribute("loginNick");
		int bookb_num = Integer.parseInt(request.getParameter("bookb_num"));
		vo.setWriter(loginNick);
		vo.setComment_pw(request.getParameter("comment_pw"));
		vo.setContent(request.getParameter("content"));
		vo.setBookb_num(bookb_num);
		if(comment_num==0){
		vo.setComment_origin_num(commentDAO.selectMaxNum()+1);	
		vo.setBookc_level(0);
		}else{
		vo.setComment_origin_num(comment_num);
		int bookc_level = commentDAO.getCommentLevel(comment_num);
		bookc_level++;
		vo.setBookc_level(bookc_level);
		}
		commentDAO.insertComment(vo);
		System.out.println("success comment dao proc in commentService");
		Map<String, Object> map = new HashMap<>();
		map.put("result", 1);

		return map;
	}

	public Map<String, Object> serviceCmt(HttpServletRequest request) {
		int bookb_num = Integer.parseInt(request.getParameter("bookb_num"));
		String result = "<?xml version='1.0' encoding='UTF-8'?>";
		result += "<comments>";
		List<CommentVO> list = commentDAO.commentList(bookb_num);
		for (CommentVO vo : list) {
			result += "<comment>";
			result += "<comment_num>" + vo.getComment_num() + "</comment_num>";
			result += "<writer>" + vo.getWriter() + "</writer>";
			result += "<content>" + vo.getContent() + "</content>";
			result += "<write_date>" + vo.getWrite_date() + "</write_date>";
			result += "<bookc_level>"+ vo.getBookc_level() +"</bookc_level>";
			result += "</comment>";
		}
		result += "</comments>";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("AjaxMember", result);

		return map;
	}

	public Map<String, Object> commentProc(HttpServletRequest request) {
		int bookb_num = Integer.parseInt(request.getParameter("bookb_num"));
		System.out.println(bookb_num);
		BookBoardVO	vo = bookBoardService.readWithReadCount(bookb_num);
		List<FileVO> fileList = fileDAO.selectAll(bookb_num);
		List<CommentVO> commentList = commentDAO.commentList(bookb_num);
		//성공 :System.out.println("dao 너 제대로 작동 하긴 했니???????"+commentList);
		LinkedList<CommentVO> commentLinkedList = new LinkedList<CommentVO>();
		
		
		for(int i=0; i<commentList.size(); i++) {
			if(commentList.get(i).getBookc_level()==0) {
				commentLinkedList.add(commentList.get(i));
			}
		}
		//성공: System.out.println(commentLinkedList);
		
		for(int i =0; i <commentList.size(); i++){
			if(commentList.get(i).getBookc_level()!=0) {
				int comment_origin_num = commentList.get(i).getComment_origin_num();				
				for(int j = 0; j<commentLinkedList.size(); j++) {					
					if(commentLinkedList.get(j).getComment_num()==comment_origin_num) {
						commentLinkedList.add(j+1, commentList.get(i));						
					}	
				}
			}
		}
		for (int i = 0; i < commentLinkedList.size(); i++) {
			System.out.println(commentLinkedList.get(i).getComment_num() +" = "+commentLinkedList.get(i).getContent());
		}
		Map<String, Object> map = new HashMap<>();
		map.put("page", "read");
		map.put("vo", vo);
		map.put("fileList", fileList);
		map.put("commentList", commentLinkedList);
		
		return map;
	}

	public Map<String, Object> comment_request(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String loginNick = (String) session.getAttribute("loginNick");
		String comment_pw = request.getParameter("comment_pw");
		int comment_num = Integer.parseInt(request.getParameter("comment_num"));
		String content = request.getParameter("content");
		int bookb_num= commentDAO.selectBookb_num(comment_num);
		int bookc_level= commentDAO.selectBookc_level(comment_num);
		
		CommentVO vo = new CommentVO();
		vo.setBookb_num(bookb_num);
		vo.setWriter(loginNick);
		vo.setComment_pw(comment_pw);
		vo.setContent(content);
		vo.setComment_origin_num(comment_num);
		vo.setBookc_level(bookc_level + 1);

		commentDAO.insertComment2(vo);
		Map<String, Object> map = new HashMap<>();
	    map.put("result", 1);
	 
	    return map;
	}
	
}