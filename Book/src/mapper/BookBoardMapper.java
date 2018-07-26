package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import vo.BookBoardVO;



public interface BookBoardMapper {
	public int newReadCount(int bookb_num);
	public BookBoardVO selectBoard(int bookb_num);
	public int insertBoard(BookBoardVO vo);
	public List<BookBoardVO> selectBookBoardList(String bb_code);
	public int selectBookBoardCount(String bb_code);
	public List<BookBoardVO> selectBookBoardOnOnePage(@Param("startRow") int startRow, @Param("viewRow") int viewRow, @Param("bb_code")String bb_code);
	
	public BookBoardVO selectUpDown(int bookb_num);
	public int upRecommend(int bookb_num);
	public int downOpposite(int bookb_num);
}
