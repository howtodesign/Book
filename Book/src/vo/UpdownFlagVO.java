package vo;

public class UpdownFlagVO {

	private int updown_num;
	private int flag_up;
	private int flag_down;
	private String nickname;
	private int bookb_num;
	private String bb_code;
	
	public UpdownFlagVO() { }

	public UpdownFlagVO(int updown_num, int flag_up, int flag_down, String nickname, int bookb_num, String bb_code) {
		this.updown_num = updown_num;
		this.flag_up = flag_up;
		this.flag_down = flag_down;
		this.nickname = nickname;
		this.bookb_num = bookb_num;
		this.bb_code = bb_code;
	}

	public int getUpdown_num() {
		return updown_num;
	}

	public void setUpdown_num(int updown_num) {
		this.updown_num = updown_num;
	}

	public int getFlag_up() {
		return flag_up;
	}

	public void setFlag_up(int flag_up) {
		this.flag_up = flag_up;
	}

	public int getFlag_down() {
		return flag_down;
	}

	public void setFlag_down(int flag_down) {
		this.flag_down = flag_down;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getBookb_num() {
		return bookb_num;
	}

	public void setBookb_num(int bookb_num) {
		this.bookb_num = bookb_num;
	}

	public String getBb_code() {
		return bb_code;
	}

	public void setBb_code(String bb_code) {
		this.bb_code = bb_code;
	}
	
	
}
