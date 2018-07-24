package vo;

import java.util.List;

public class BookBoardPageVO {

	private List<BookBoardVO> bookBoardList;
	private int startPage;
	private int endPage;
	private int totalPage;
	private int currentPage;
	private int number;
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
	@Override
	public String toString() {
		return "BookBoardPageVO [bookBoardList=" + bookBoardList + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", totalPage=" + totalPage + ", currentPage=" + currentPage + ", number=" + number + "]";
	}
	public BookBoardPageVO(List<BookBoardVO> bookBoardList, int startPage, int endPage, int totalPage, int currentPage,
			int number) {
		super();
		this.bookBoardList = bookBoardList;
		this.startPage = startPage;
		this.endPage = endPage;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
		this.number = number;
	}
	
	public BookBoardPageVO() {

	}
}
