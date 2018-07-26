package vo;

public class FileVO {

	private int file_num;
	private String original_name;
	private String saved_path;
	private int bookb_num;
	private String bb_code;

	
	public int getFile_num() {
		return file_num;
	}


	public void setFile_num(int file_num) {
		this.file_num = file_num;
	}


	public String getOriginal_name() {
		return original_name;
	}


	public void setOriginal_name(String original_name) {
		this.original_name = original_name;
	}


	public String getSaved_path() {
		return saved_path;
	}


	public void setSaved_path(String saved_path) {
		this.saved_path = saved_path;
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

	
	

	public FileVO(int file_num, String original_name, String saved_path, int bookb_num, String bb_code) {
		super();
		this.file_num = file_num;
		this.original_name = original_name;
		this.saved_path = saved_path;
		this.bookb_num = bookb_num;
		this.bb_code = bb_code;
	}


	@Override
	public String toString() {
		return "FileVO [file_num=" + file_num + ", original_name=" + original_name + ", saved_path=" + saved_path
				+ ", bookb_num=" + bookb_num + ", bb_code=" + bb_code + "]";
	}


	public FileVO() {

	}
}
