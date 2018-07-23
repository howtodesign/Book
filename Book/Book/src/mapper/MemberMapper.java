package mapper;

import vo.MemberVO;

public interface MemberMapper {

	public int insertMem(MemberVO member); // 회원정보 입력
	public int updateMem(MemberVO member); // 회원정보 수정
	public MemberVO selectMem(String id); // 회원정보 조회
	
	public String getPassbyId(String id); // 비밀번호 가져오기
	public String getNickbyId(String id); // 닉네임 가져오기
	public String cofirmNick(String nickname); // 닉네임 유효성 체크
	
	public int grantAdmin(String id, String flagAdmin); // 회원 권한 설정
	
}
