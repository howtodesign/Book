
package vo;

public class MemberVO {

	private String id;
	private String password;
	private String name;
	private String nickname;
	private String phone;
	private String email;
	private String registDate;
	private String flagAdmin;
	
	public MemberVO() { }

	public MemberVO(String id, String password, String name, String nickname, String phone, String email,
			String registDate, String flagAdmin) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
		this.phone = phone;
		this.email = email;
		this.registDate = registDate;
		this.flagAdmin = flagAdmin;
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

	public String getregistDate() {
		return registDate;
	}

	public void setregistDate(String registDate) {
		this.registDate = registDate;
	}

	public String getflagAdmin() {
		return flagAdmin;
	}

	public void setflagAdmin(String flagAdmin) {
		this.flagAdmin = flagAdmin;
	}
	
	
}
