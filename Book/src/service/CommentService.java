package service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.CommentDAO;
import vo.CommentVO;

@Component
public class CommentService {

	@Autowired
	private CommentDAO commentDAO;
	
	public Map<String, Object> insertComment(HttpServletRequest request) {
		 HttpSession session = request.getSession();
		 CommentVO vo= new CommentVO();	
		 String loginNick = (String) session.getAttribute("loginNick");
		 int bookb_num = Integer.parseInt(request.getParameter("bookb_num"));		 	
	        vo.setWriter(loginNick);
	        vo.setComment_pw(request.getParameter("comment_pw"));
	        vo.setContent(request.getParameter("content"));
	        vo.setBookb_num(bookb_num);
	        commentDAO.insertComment(vo);
	        System.out.println("success comment dao proc in commentService");
	        Map<String, Object> map = new HashMap<>();
	        map.put("result", 1);
	    
	        return map;
	    }

	
}
