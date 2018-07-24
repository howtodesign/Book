package vo;


public class MemberVO {

	private String id;

	private String password;

	private String name;

	private String nickname;

	private String phone;

	private String email;

	private String regist_date;

	private String flag_admin;

	

	public MemberVO() { }



	public MemberVO(String id, String password, String name, String nickname, String phone, String email,

			String regist_date, String flag_admin) {

		this.id = id;

		this.password = password;

		this.name = name;

		this.nickname = nickname;

		this.phone = phone;

		this.email = email;

		this.regist_date = regist_date;

		this.flag_admin = flag_admin;

	}



	public String getId() {

		return id;

	}



	public void setId(String id) {

		this.id = id;

	}



	public String getPassword() {

		return password;

	}



	public void setPassword(String password) {

		this.password = password;

	}



	public String getName() {

		return name;

	}



	public void setName(String name) {

		this.name = name;

	}



	public String getNickname() {

		return nickname;

	}



	public void setNickname(String nickname) {

		this.nickname = nickname;

	}



	public String getPhone() {

		return phone;

	}



	public void setPhone(String phone) {

		this.phone = phone;

	}



	public String getEmail() {

		return email;

	}



	public void setEmail(String email) {

		this.email = email;

	}



	public String getregist_date() {

		return regist_date;

	}



	public void setregist_date(String regist_date) {

		this.regist_date = regist_date;

	}



	public String getflag_admin() {

		return flag_admin;

	}



	public void setflag_admin(String flag_admin) {

		this.flag_admin = flag_admin;

	}

	

	

}