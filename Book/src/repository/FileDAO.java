package repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.FileMapper;
import vo.FileVO;

@Component
public class FileDAO {
	@Autowired
	private SqlSessionTemplate template;
	
	public int insertFile(FileVO vo) {
		FileMapper mapper = template.getMapper(FileMapper.class);
		return mapper.insertFile(vo);
	}

	
	public List<FileVO> selectAll(int boardNum){
		FileMapper mapper = template.getMapper(FileMapper.class);
		return mapper.selectAll(boardNum);
	}
	
	public FileVO selectFile(int file_num) {
		FileMapper mapper = template.getMapper(FileMapper.class);
		return mapper.selectFile(file_num);
		
	}
}
