package vo;

import java.util.List;

public class BookBoardPageVO {

	private List<BookBoardVO> bookBoardList;
	private int startPage;
	private int endPage;
	private int totalPage;
	private int currentPage;
	private int number;
	private String bb_code;
	
	public List<BookBoardVO> getBookBoardList() {
		return bookBoardList;
	}
	public void setBookBoardList(List<BookBoardVO> bookBoardList) {
		this.bookBoardList = bookBoardList;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public String getBb_code() {
		return bb_code;
	}
	public void setBb_code(String bb_code) {
		this.bb_code = bb_code;
	}
	@Override
	public String toString() {
		return "BookBoardPageVO [bookBoardList=" + bookBoardList + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", totalPage=" + totalPage + ", currentPage=" + currentPage + ", number=" + number + "]";
	}
	public BookBoardPageVO(List<BookBoardVO> bookBoardList, int startPage, int endPage, int totalPage, int currentPage,
			int number, String bb_code) {
		super();
		this.bookBoardList = bookBoardList;
		this.startPage = startPage;
		this.endPage = endPage;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
		this.number = number;
		this.bb_code = bb_code;
	}
	
	public BookBoardPageVO() {

	}
}
