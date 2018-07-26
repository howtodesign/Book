package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.MemberService;

@Controller
public class MainController {

	@Autowired
	private MemberService service;
	
	@RequestMapping("/main.do")
	public String main(HttpServletRequest request){
		return "main";
	}
	
	@RequestMapping("/joinForm.do") // go to joinPage
	public String joinForm() {
		return "join_form";
	}
	
	@RequestMapping("/login.do") // login
	public ModelAndView login(String userId, String userPw, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(service.loginCheck(userId, userPw)) {
			if(service.isAdmin(userId)){
				session.setAttribute("loginId", userId);
				session.setAttribute("loginNick", service.getNickname(userId));
				session.setAttribute("flagAdmin", "admin11");
				mv.setViewName("login_success");
			}else{
			session.setAttribute("loginId", userId);
			session.setAttribute("loginNick", service.getNickname(userId));
			mv.setViewName("login_success");
			}
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
	
	@RequestMapping("/checkPassword.do")
	public String memberInfo() {
		return "check_password";
	}

}
