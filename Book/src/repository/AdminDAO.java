package repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.AdminMapper;
import vo.MemberVO;

@Component
public class AdminDAO {

	@Autowired
	private SqlSessionTemplate template;
	
	public List<MemberVO> selectMemberList(String adminId, int startRow, int endRow){
		AdminMapper mapper = template.getMapper(AdminMapper.class);
		return mapper.selectMemberList(adminId ,startRow, endRow);
	}
	
	public int selectMemberCount(String adminId){
		AdminMapper mapper = template.getMapper(AdminMapper.class);
		return mapper.selectMemberCount(adminId);
	}
	
	public int updateFlag(String id, String flag_admin){
		AdminMapper mapper = template.getMapper(AdminMapper.class);
		return mapper.updateFlag(id, flag_admin);
	}
}
