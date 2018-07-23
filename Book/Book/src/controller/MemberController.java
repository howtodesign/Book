package controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	@RequestMapping("/joinForm.do")
	public String joinForm() {
		return "join_form";
	}
	
	@RequestMapping("/idCheck.do")
	@ResponseBody
	public String idCheck(String id) {
		if(service.getNickname(id) == null) {
			return "true";
		}else {
			return "false";
		}
	}
	
	@RequestMapping("/nickCheck.do")
	@ResponseBody
	public String nickCheck(String nick) {
		if(service.checkNick(nick) == null) {
			return "true";
		}else {
			return "false";
		}
	}
}
