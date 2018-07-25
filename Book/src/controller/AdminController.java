package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import service.AdminService;
import service.MemberService;

@Controller
public class AdminController {

	@Autowired
	private AdminService service;
	@Autowired
	private MemberService mservice;
	
	@RequestMapping("/adminMain.do")
	public String adminMain(){
		return "admin_main";
	}
	
	@RequestMapping("/adminMemberList.do")
	public ModelAndView memberList(@RequestParam(value="p", defaultValue="1")int page, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("memberPage", service.makeMemberPage((String)session.getAttribute("loginId"), page));
		mv.setViewName("admin_member_list");
		return mv;
	}
	
	@RequestMapping("/adminMemberInfo.do")
	public ModelAndView adminMemberInfo(String id){
		ModelAndView mv = new ModelAndView("admin_member_info");
		mv.addObject("member", mservice.getMember(id));
		return mv;
	}
	
	@RequestMapping("/adminResetPassword.do")
	@ResponseBody
	public String adminResetPassword(String id){
		if(service.resetPassword(id)){
			return "true";
		}else{
			return "false";
		}
	}
	
	@RequestMapping("/adminGrant.do")
	@ResponseBody
	public String adminGrant(String id){
		if(service.grantAdmin(id)){
			return "true";
		}else{
			return "false";
		}
	}
	
	@RequestMapping("/adminRevoke.do")
	@ResponseBody
	public String adminRevock(String id){
		if(service.revokeAdmin(id)){
			return "true";
		}else{
			return "false";
		}
	}
	
	@RequestMapping("/adminBan.do")
	@ResponseBody
	public String adminBan(String id){
		if(service.ban(id)){
			return "true";
		}else{
			return "false";
		}
	}
	
	@RequestMapping("/adminUnban.do")
	@ResponseBody
	public String adminUnban(String id){
		if(service.unban(id)){
			return "true";
		}else{
			return "false";
		}
	}
	
	@RequestMapping("/adminKick.do")
	@ResponseBody
	public String adminKick(String id){
		if(service.kick(id)){
			return "true";
		}else{
			return "false";
		}
	}
}
