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
	
	public List<CommentVO> commentList(int bookb_num){
		CommentMapper mapper = template.getMapper(CommentMapper.class);
		return mapper.commentList(bookb_num);
	}
	
	public int getCommentLevel(int comment_num){
		CommentMapper mapper = template.getMapper(CommentMapper.class);
		return mapper.selectCommentLevel(comment_num);
	}

	public int selectMaxNum(){
		CommentMapper mapper = template.getMapper(CommentMapper.class);
		return mapper.selectMaxNum();
	}
	
	public int selectCommentOriginNum(int comment_num){
		CommentMapper mapper = template.getMapper(CommentMapper.class);
		return mapper.selectCommentOriginNum(comment_num);
	}
}
