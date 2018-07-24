package mapper;

import java.util.List;

import vo.FileVO;

public interface FileMapper {

	public List<FileVO> selectAll(int bookb_num);
	public int insertFile(FileVO vo);
	
	
}
