package vo;

public class BookCodeVO {

	private String bb_code;
	private String bb_name;
	
	public BookCodeVO() { }

	public BookCodeVO(String bb_code, String bb_name) {
		super();
		this.bb_code = bb_code;
		this.bb_name = bb_name;
	}

	public String getBb_code() {
		return bb_code;
	}

	public void setBb_code(String bb_code) {
		this.bb_code = bb_code;
	}

	public String getBb_name() {
		return bb_name;
	}

	public void setBb_name(String bb_name) {
		this.bb_name = bb_name;
	}
	
	
}
