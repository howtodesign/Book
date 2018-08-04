package repository;

import java.util.List;

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
	
	public int insertComment2(CommentVO vo) {
		CommentMapper mapper = template.getMapper(CommentMapper.class);
		return mapper.insertComment2(vo);
	}
	
	public List<CommentVO> commentList(int bookb_num){
		CommentMapper mapper = template.getMapper(CommentMapper.class);
		return mapper.commentList(bookb_num);
	}

	public int selectBookb_num(int comment_num) {
		CommentMapper mapper = template.getMapper(CommentMapper.class);
		return mapper.selectBookb_num(comment_num);
	}
	
	public int selectBookc_level(int comment_num) {
		CommentMapper mapper = template.getMapper(CommentMapper.class);
		return mapper.selectBookc_level(comment_num);
	}
	
}
