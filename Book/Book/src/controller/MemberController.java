package controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import service.MemberService;
import vo.MemberVO;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	@RequestMapping("/joinForm.do") // go to joinPage
	public String joinForm() {
		return "join_form";
	}
	
	@RequestMapping("/idCheck.do") // id check
	@ResponseBody
	public String idCheck(String id) {
		if(service.getNickname(id) == null) {
			return "true";
		}else {
			return "false";
		}
	}
	
	@RequestMapping("/nickCheck.do") // nickname check
	@ResponseBody
	public String nickCheck(String nick) {
		if(service.checkNick(nick) == null) {
			return "true";
		}else {
			return "false";
		}
	}
	
	@RequestMapping("/join.do") // join
	public String joinProc(MemberVO member) {
		if(service.memberValidator(member)) {
			return "join_success";
		}else {
			return "join_fail";
		}
	}
	
	@RequestMapping("/login.do") // login
	public ModelAndView loginProc(String userId, String userPw, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(service.loginCheck(userId, userPw)) {
			session.setAttribute("loginId", userId);
			session.setAttribute("loginNick", service.getNickname(userId));
			mv.setViewName("login_success");
		}else {
			mv.setViewName("login_fail");
		}
		return mv;
	}
	
	@RequestMapping("/logout.do") // logout
	public String logout(HttpSession session) {
		session.invalidate();
		return "logout";
	}
	
	@RequestMapping("/memberInfo.do")
	public ModelAndView memberInfo(String userPw, HttpSession session) {
		
		ModelAndView mv = new ModelAndView();
		if(service.loginCheck((String)session.getAttribute("loginId"), userPw)) {
			mv.setViewName("member_info");
		}else {
			mv.addObject("checkpw", "getout");
			mv.setViewName("member_info");
		}
		return mv;
	}
	
	@RequestMapping("/getMember.do")
	@ResponseBody
	public void getMember(String id, HttpServletResponse response){

		String memberJson;

	    MemberVO member = service.getMember(id);
	    if(member != null){
	        memberJson = "{\"id\":\""+member.getId()
	                    +"\",\"name\":\""+member.getName()
	                    +"\",\"password\":\""+member.getPassword()
	                    +"\",\"phone\":\""+member.getPhone()
	                    +"\",\"nickname\":\""+member.getNickname()
	                    +"\",\"regitsDate\":\""+member.getregistDate()
	                    +"\",\"adminFlag\":\""+member.getflagAdmin()
	                    +"\",\"email\":\""+member.getEmail()+"\"}";
	    }
	    else{
	        memberJson = "null";
	    }
	    try {
	        response.getWriter().print(memberJson);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }   
	}
}
