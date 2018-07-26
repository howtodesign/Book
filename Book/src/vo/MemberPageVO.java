package vo;

import java.util.List;

public class MemberPageVO {

	private List<MemberVO> memberList;
	private int currentPage;
	private int startPage;
	private int endPage;
	private int totalPageCount;
	private int number;
	
	public MemberPageVO() { }

	public MemberPageVO(List<MemberVO> memberList, int currentPage, int startPage, int endPage, int totalPageCount,
			int number) {
		this.memberList = memberList;
		this.currentPage = currentPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.totalPageCount = totalPageCount;
		this.number = number;
	}

	public List<MemberVO> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<MemberVO> memberList) {
		this.memberList = memberList;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
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

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	
}
