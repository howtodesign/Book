package vo;

public class BookBoardVO {

	private int bookb_num;
	private String writer;
	private String title;
	private String book_name;
	private String bb_code;
	private String content;
	private String write_date;
	private int bookb_ref;
	private int bookb_seq;
	private int bookb_level;
	private int readcount;
	private int recommend;
	private int opposite;

	public int getBookb_num() {
		return bookb_num;
	}

	public void setBookb_num(int bookb_num) {
		this.bookb_num = bookb_num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getBb_code() {
		return bb_code;
	}

	public void setBb_code(String bb_code) {
		this.bb_code = bb_code;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWrite_date() {
		return write_date;
	}

	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}

	public int getBookb_ref() {
		return bookb_ref;
	}

	public void setBookb_ref(int bookb_ref) {
		this.bookb_ref = bookb_ref;
	}

	public int getBookb_seq() {
		return bookb_seq;
	}

	public void setBookb_seq(int bookb_seq) {
		this.bookb_seq = bookb_seq;
	}

	public int getBookb_level() {
		return bookb_level;
	}

	public void setBookb_level(int bookb_level) {
		this.bookb_level = bookb_level;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public int getRecommend() {
		return recommend;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}

	public int getOpposite() {
		return opposite;
	}

	public void setOpposite(int opposite) {
		this.opposite = opposite;
	}

	public BookBoardVO(int bookb_num, String writer, String title, String book_name, String bb_code, String content,
			String write_date, int bookb_ref, int bookb_seq, int bookb_level, int readcount, int recommend,
			int opposite) {
		super();
		this.bookb_num = bookb_num;
		this.writer = writer;
		this.title = title;
		this.book_name = book_name;
		this.bb_code = bb_code;
		this.content = content;
		this.write_date = write_date;
		this.bookb_ref = bookb_ref;
		this.bookb_seq = bookb_seq;
		this.bookb_level = bookb_level;
		this.readcount = readcount;
		this.recommend = recommend;
		this.opposite = opposite;
	}

	@Override
	public String toString() {
		return "BookBoardVO [bookb_num=" + bookb_num + ", writer=" + writer + ", title=" + title + ", book_name="
				+ book_name + ", bb_code=" + bb_code + ", content=" + content + ", write_date=" + write_date
				+ ", bookb_ref=" + bookb_ref + ", bookb_seq=" + bookb_seq + ", bookb_level=" + bookb_level
				+ ", readcount=" + readcount + ", recommend=" + recommend + ", opposite=" + opposite + "]";
	}

	public BookBoardVO() {

	}

}
