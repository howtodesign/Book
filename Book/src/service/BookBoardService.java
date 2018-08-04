package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import repository.BookBoardDAO;
import vo.BookBoardPageVO;
import vo.BookBoardVO;
import vo.UpdownFlagVO;


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
		int number = totalBoardCount-(currentPage-1)*PAGE_PER_COUNT;
	
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
	
	public BookBoardVO processUpDown(String code, int bookb_num, String bb_code, String nickname){
		UpdownFlagVO udf = null; 
		udf =	bookBoardDAO.selectUpdownFlag(bookb_num, bb_code, nickname);
		int up = 0;
		int down = 0;
		if(udf!=null){
			up = udf.getFlag_up();
			down = udf.getFlag_down();
		}else{
			udf = new UpdownFlagVO();
			udf.setNickname(nickname);
			udf.setBookb_num(bookb_num);
			udf.setBb_code(bb_code);
		}
		if(code.equals("check")){
			
		}else if(code.equals("up")){
			if(up==0 && down==0){
				udf.setFlag_up(1);
				udf.setFlag_down(0);
				bookBoardDAO.insertUpdownFlag(udf);
				bookBoardDAO.processUp(bookb_num);
			}else if(up==1 && down==0){
				return null;
			}else if(up==0 && down==1){
				udf.setFlag_up(1);
				udf.setFlag_down(0);
				bookBoardDAO.updateUpdownFlag(udf);
				bookBoardDAO.processUp(bookb_num);
				bookBoardDAO.processReDown(bookb_num);
			}
		}else if(code.equals("down")){
			if(up==0 && down==0){
				udf.setFlag_up(0);
				udf.setFlag_down(1);
				bookBoardDAO.insertUpdownFlag(udf);
				bookBoardDAO.processDown(bookb_num);
			}else if(up==1 && down==0){
				udf.setFlag_up(0);
				udf.setFlag_down(1);
				bookBoardDAO.updateUpdownFlag(udf);
				bookBoardDAO.processDown(bookb_num);
				bookBoardDAO.processReUp(bookb_num);
			}else if(up==0 && down==1){
				return null;
			}
		}
		return bookBoardDAO.processUpDown(bookb_num);
	}
	
	//@Scheduled(cron="0 0 24 * * *") 매일 24시 초기화
	@Scheduled(cron="0 * * * * *") // 테스트를위한 1분마다 초기화
	public void deleteUpdownFlag(){
		bookBoardDAO.deleteUpdownFlag();
		System.out.println("추천반대 리셋");
	}
	
	public String selectBBName(String bb_code){
		return bookBoardDAO.selectBBName(bb_code);
	}
}
