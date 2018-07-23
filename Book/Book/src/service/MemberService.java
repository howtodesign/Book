package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.MemberDAO;
import vo.MemberVO;

@Component
public class MemberService {

	@Autowired
	private MemberDAO dao;
	
	//	회원가입
	public boolean memberValidator(MemberVO member) {
		if( member.getId()==null || member.getId()=="" ||
			member.getPassword()==null || member.getPassword()=="" ||
			member.getName()==null || member.getName()=="" ||
			member.getNickname()==null || member.getNickname()=="" ||
			member.getPhone() == null || member.getPhone()=="" ||
			member.getEmail()==null || member.getEmail()==""){
			return false;
		}else {
			dao.insertMem(member);
			return true;
		}
	}
	
	//	업데이트
	public boolean updateValidator(MemberVO member) {
		if( member.getId()==null || member.getId()=="" ||
			member.getPassword()==null || member.getPassword()=="" ||
			member.getName()==null || member.getName()=="" ||
			member.getNickname()==null || member.getNickname()=="" ||
			member.getPhone() == null || member.getPhone()=="" ||
			member.getEmail()==null || member.getEmail()==""){
			return false;
		}else {
			dao.updateMem(member);
			return true;
		}
	}
	
	//닉네임 가져오기 // 아이디 체크
	public String getNickname(String id){
		return dao.getNickbyId(id);
	}
	
	//닉네임 체크
	public String checkNick(String nickname){
		return dao.confirmNick(nickname);
	}
}
