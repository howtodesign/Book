package service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import repository.AdminDAO;
import repository.MemberDAO;
import vo.MemberPageVO;
import vo.MemberVO;

@Component
public class AdminService {

	private static final int PAGE_PER_COUNT = 5; 
	private static final int PAGE_BLOCK_COUNT = 5;
	
	@Autowired
	private AdminDAO dao;
	@Autowired
	private MemberDAO mdao;
	
	public MemberPageVO makeMemberPage(String adminId, int currentPage) {
		//총 페이지 수 
		int totalMemberCount = dao.selectMemberCount(adminId);
		int totalPageCount = totalMemberCount/PAGE_PER_COUNT;
		if(totalMemberCount%PAGE_PER_COUNT != 0) totalPageCount++;
		//게시판 글번호
		int number = 1+(currentPage-1)*PAGE_PER_COUNT;
		
		// 목록에 출력할 게시글 
		int startRow = (currentPage-1)*PAGE_PER_COUNT+1;
		int endRow = currentPage*PAGE_PER_COUNT;
		List<MemberVO> memberList = dao.selectMemberList(adminId ,startRow, endRow);

		//화면 하단의 페이지 링크중 시작 페이지
		int startPage = (currentPage-1)/PAGE_BLOCK_COUNT*PAGE_BLOCK_COUNT+1;
		
		//화면 하단의 페이지 링크중 끝 페이지
		int endPage = startPage+PAGE_BLOCK_COUNT-1;
		if(endPage>totalPageCount) endPage = totalPageCount;
		
		return new MemberPageVO(memberList, currentPage, startPage, endPage, totalPageCount, number);
	}
	
	// reset password
	public boolean resetPassword(String id){
		if(mdao.updatePassword(id, "1111")>0){
			return true;
		}else{
			return false;
		}
	}
	// grant admin
	public boolean grantAdmin(String id){
		if(dao.updateFlag(id, "admin13")>0){
			return true;
		}else{
			return false;
		}
	}
	
	// revoke admin
	public boolean revokeAdmin(String id){
		if(dao.updateFlag(id, "m")>0){
			return true;
		}else{
			return false;
		}
	}
	
	// ban
	public boolean ban(String id){
		if(dao.updateFlag(id, "b")>0){
			return true;
		}else{
			return false;
		}
	}
	
	// unban
	public boolean unban(String id){
		if(dao.updateFlag(id, "m")>0){
			return true;
		}else{
			return false;
		}
	}
	
	// kick
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	public boolean kick(String id) throws Exception{
		MemberVO member = mdao.selectDeleteMem(id);
		mdao.insertDeleteMem(member);
		if(new Random().nextBoolean()){
			throw new Exception("에러");
		}
		if(mdao.deleteMem(id)>0){
			return true;
		}else{
			return false;
		}
	}	
}
