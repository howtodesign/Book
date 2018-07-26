package repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.BookBoardMapper;

import vo.BookBoardVO;


@Component
public class BookBoardDAO {

	@Autowired
	private SqlSessionTemplate template;
	
	public List<BookBoardVO> selectBookBoardList(String bb_code){
		BookBoardMapper bookBoardMapper = template.getMapper(BookBoardMapper.class);
		return bookBoardMapper.selectBookBoardList(bb_code);
	}
	
	public int selectBookBoardCount(String bb_code) {
		BookBoardMapper bookBoardMapper= template.getMapper(BookBoardMapper.class);
		return bookBoardMapper.selectBookBoardCount(bb_code);
	}

	public int newReadCount(int bookb_num) {
		BookBoardMapper bookBoardMapper= template.getMapper(BookBoardMapper.class);
		return bookBoardMapper.newReadCount(bookb_num);
	}

	public BookBoardVO selectBoard(int bookb_num) {
		
		BookBoardMapper bookBoardMapper= template.getMapper(BookBoardMapper.class);
		return bookBoardMapper.selectBoard(bookb_num);
	}

	public int insertBoard(BookBoardVO vo) {
		BookBoardMapper bookBoardMapper= template.getMapper(BookBoardMapper.class);
		return bookBoardMapper.insertBoard(vo);
		
	}
	
	public List<BookBoardVO> selectBookBoardOnOnePage(int startRow, int viewRow, String bb_code) {
		BookBoardMapper bookBoardMapper= template.getMapper(BookBoardMapper.class);
		return bookBoardMapper.selectBookBoardOnOnePage(startRow, viewRow, bb_code);
	}
	
	public BookBoardVO processUpDown(int bookb_num){
		BookBoardMapper bookBoardMapper= template.getMapper(BookBoardMapper.class);
		return bookBoardMapper.selectUpDown(bookb_num);
	}
	
	public int processUp(int bookb_num){
		BookBoardMapper bookBoardMapper= template.getMapper(BookBoardMapper.class);
		return bookBoardMapper.upRecommend(bookb_num);
	}
	
	public int processDown(int bookb_num){
		BookBoardMapper bookBoardMapper= template.getMapper(BookBoardMapper.class);
		return bookBoardMapper.downOpposite(bookb_num);
	}
}
