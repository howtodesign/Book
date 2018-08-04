package mapper;

import java.util.List;

import vo.CommentVO;

public interface CommentMapper {
	public int insertComment(CommentVO vo);
	public int insertComment(CommentVO vo);	public List<CommentVO> commentList(int bookb_num);
	public int selectCommentLevel(int comment_num);
	public int selectMaxNum();
	public int selectCommentOriginNum(int comment_num);
}
