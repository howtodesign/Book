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
	                    +"\",\"regist_date\":\""+member.getRegist_date()
	                    +"\",\"admin_flag\":\""+member.getFlag_admin()
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
	
	@RequestMapping("/updateMember.do")
	public ModelAndView updateProc(MemberVO member, HttpSession session) {
		ModelAndView mv = new ModelAndView();
			if(service.updateValidator(member)) {
				mv.addObject("checkup", "success");
				mv.setViewName("member_info");
			}else {
				mv.setViewName("update_fail");
			}
		return mv;		
	}
	
	@RequestMapping("updatePasswordForm.do")
	public String updatePasswordForm(){
		return "update_password_form";
	}
	
	@RequestMapping("updatePassword.do")
	public String updatePassword(String beforepassword, String password, String passwordre, HttpSession session){
		String id = (String)session.getAttribute("loginId");
		if(service.loginCheck(id, beforepassword)){
			if(password.equals(passwordre)){
				if(service.updatePassword(id, password)>0){
					session.invalidate();
					return "update_success";
				}else{
					return "update_fail";
				}
			}else{
				return "update_fail";
			}
		}else{
			return "update_fail";
		}
	}
	
	@RequestMapping("deleteMemberForm.do")
	public String deleteMemberForm(){
		return "delete_member_form";
	}
	
	@RequestMapping("deleteMember.do")
	public String deleteMember(String password, String passwordre, HttpSession session){
		String id = (String)session.getAttribute("loginId");
		if(service.loginCheck(id, password)){
			if(password.equals(passwordre)){
				service.deleteMember(id);
				session.invalidate();
				return "delete_success";
			}else{
				return "delete_fail";
			}
		}else{
			return "delete_fail";
		}
	}
}
