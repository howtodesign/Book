package repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.MemberMapper;
import vo.MemberVO;

@Component
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate template;
	
	public int insertMem(MemberVO member){
		MemberMapper mapper = template.getMapper(MemberMapper.class);
		return mapper.insertMem(member);
	}
	
	public int updateMem(MemberVO member){
		MemberMapper mapper = template.getMapper(MemberMapper.class);
		return mapper.updateMem(member);
	}
	
	public MemberVO selectMem(String id){
		MemberMapper mapper = template.getMapper(MemberMapper.class);
		return mapper.selectMem(id);
	}
	
	public String getPassbyId(String id){
		MemberMapper mapper = template.getMapper(MemberMapper.class);
		return mapper.getPassbyId(id);
	}
	
	public String getNickbyId(String id){
		MemberMapper mapper = template.getMapper(MemberMapper.class);
		return mapper.getNickbyId(id);
	}
	
	public String confirmNick(String nickname){
		MemberMapper mapper = template.getMapper(MemberMapper.class);
		return mapper.cofirmNick(nickname);
	}
	
	public int updatePassword(String id, String password){
		MemberMapper mapper = template.getMapper(MemberMapper.class);
		return mapper.updatePassword(id, password);
	}
	
	public int deleteMem(String id){
		MemberMapper mapper = template.getMapper(MemberMapper.class);
		return mapper.deleteMem(id);
	}
	
	public int grantAdmin(String id, String flagAdmin){
		MemberMapper mapper = template.getMapper(MemberMapper.class);
		return mapper.grantAdmin(id, flagAdmin);
	}
}
