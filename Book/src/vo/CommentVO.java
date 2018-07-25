package vo;

public class CommentVO {

	private int comment_num;
	private int bookb_num;
	private String writer;
	private String comment_pw;
	private String content;
	private int comment_origin_num;
	private String write_date;
	private int bookc_level;
	private int flag_lock;

	public int getComment_num() {
		return comment_num;
	}

	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}

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

	public String getComment_pw() {
		return comment_pw;
	}

	public void setComment_pw(String comment_pw) {
		this.comment_pw = comment_pw;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getComment_origin_num() {
		return comment_origin_num;
	}

	public void setComment_origin_num(int comment_origin_num) {
		this.comment_origin_num = comment_origin_num;
	}

	public String getWrite_date() {
		return write_date;
	}

	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}

	public int getBookc_level() {
		return bookc_level;
	}

	public void setBookc_level(int bookc_level) {
		this.bookc_level = bookc_level;
	}

	public int getFlag_lock() {
		return flag_lock;
	}

	public void setFlag_lock(int flag_lock) {
		this.flag_lock = flag_lock;
	}

	@Override
	public String toString() {
		return "CommentVO [comment_num=" + comment_num + ", bookb_num=" + bookb_num + ", writer=" + writer
				+ ", comment_pw=" + comment_pw + ", content=" + content + ", comment_origin_num=" + comment_origin_num
				+ ", write_date=" + write_date + ", bookc_level=" + bookc_level + ", flag_lock=" + flag_lock + "]";
	}

	public CommentVO(int comment_num, int bookb_num, String writer, String comment_pw, String content,
			int comment_origin_num, String write_date, int bookc_level, int flag_lock) {
		super();
		this.comment_num = comment_num;
		this.bookb_num = bookb_num;
		this.writer = writer;
		this.comment_pw = comment_pw;
		this.content = content;
		this.comment_origin_num = comment_origin_num;
		this.write_date = write_date;
		this.bookc_level = bookc_level;
		this.flag_lock = flag_lock;
	}

	public CommentVO() {

	}

}
