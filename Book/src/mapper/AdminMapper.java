package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import vo.MemberVO;

public interface AdminMapper {
	// memberList
	public List<MemberVO> selectMemberList(@Param("adminId")String adminId, @Param("startRow")int startRow, @Param("endRow")int endRow);
	public int selectMemberCount(@Param("adminId")String adminId); // total member count
	public int updateFlag(@Param("id")String id, @Param("flag_admin")String flag_admin); // flag update
	
}
