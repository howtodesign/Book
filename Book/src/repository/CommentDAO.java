package repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.CommentMapper;
import vo.CommentVO;

@Component
public class CommentDAO {

	@Autowired
	private SqlSessionTemplate template;

	public int insertComment(CommentVO vo) {
		CommentMapper mapper = template.getMapper(CommentMapper.class);
		return mapper.insertComment(vo);
	}
}
