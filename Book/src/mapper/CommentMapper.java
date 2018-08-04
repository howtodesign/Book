package mapper;

import java.util.List;

import vo.CommentVO;

public interface CommentMapper {
	public int insertComment(CommentVO vo);
	public int insertComment2(CommentVO vo);
	public List<CommentVO> commentList(int bookb_num);
	public int selectBookb_num(int comment_num);
	public int selectBookc_level(int comment_num);
}
