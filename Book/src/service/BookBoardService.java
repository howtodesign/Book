package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.BookBoardDAO;
import vo.BookBoardPageVO;
import vo.BookBoardVO;


@Component
public class BookBoardService {

	@Autowired
	private BookBoardDAO bookBoardDAO;
	
	private static final int PAGE_PER_COUNT = 10;
	private static final int PAGE_PER_BLOCK=10;

	
	public BookBoardPageVO makePage(int currentPage, String bb_code, BookBoardVO vo) {
		
		int totalBoardCount = bookBoardDAO.selectBookBoardCount(bb_code);	
		// System.out.println(vo.getBook_name()+vo.getBb_code());
		int totalPage= totalBoardCount / PAGE_PER_COUNT;
		if (totalBoardCount % PAGE_PER_COUNT != 0) {
			totalPage++;
		}
		//WHAT IS THIS MEANS...? BOARD BOARD NUM ...../
		int number = totalBoardCount+(currentPage-1)*PAGE_PER_COUNT;
		System.out.println("number:"+number);
		
		int startRow = (currentPage - 1) * PAGE_PER_BLOCK+1;
		int endRow= currentPage* PAGE_PER_BLOCK ;
		List<BookBoardVO> bookBoardList = bookBoardDAO.selectBookBoardOnOnePage(startRow, endRow, bb_code);
		
		int startPage = (currentPage-1)/PAGE_PER_BLOCK*PAGE_PER_BLOCK+1;
		int endPage = startPage + PAGE_PER_BLOCK-1;
		if (endPage > totalPage) {
			endPage = totalPage;
		}

		return new BookBoardPageVO(bookBoardList, startPage, endPage, totalPage, currentPage, number, bb_code);
	}

	public int insertedBoardNum(BookBoardVO vo) {
		
		bookBoardDAO.insertBoard(vo);
		System.out.println(vo);
		return vo.getBookb_num();
	}

	public BookBoardVO readWithoutCount(int bookb_num) {
		return bookBoardDAO.selectBoard(bookb_num);
	}

	public BookBoardVO readWithReadCount(int bookb_num) {
		// 조회수 증가를 먼저 시킴
		if (bookBoardDAO.newReadCount(bookb_num) > 0) {
			// 글이 있다면 조회수가 증가할 것이고 그 다음에 글을 불러온다.
			return bookBoardDAO.selectBoard(bookb_num);
		} else {
			return null;
		}
	}
	
	public BookBoardVO processUpDown(String code, int bookb_num){
		if(code.equals("check")){
			
		}else if(code.equals("up")){
			bookBoardDAO.processUp(bookb_num);
		}else if(code.equals("down")){
			bookBoardDAO.processDown(bookb_num);
		}
		return bookBoardDAO.processUpDown(bookb_num);
	}
}
