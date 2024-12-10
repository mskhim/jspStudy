package co.kh.dev.tempmember.model;

public class TempMemberVO {

	private String id; // 사용자 ID
	private String passwd; // 비밀번호
	private String name; // 사용자 이름
	private String memNum1; // 주민등록번호 앞자리
	private String memNum2; // 주민등록번호 뒷자리
	private String email; // 이메일
	private String phone; // 전화번호
	private String zipcode; // 우편번호
	private String address; // 주소
	private String job; // 직업
	
	
	public TempMemberVO() {
		super();
	}

	@Override
	public String toString() {
		return "TempMemberVO [id=" + id + ", passwd=" + passwd + ", name=" + name + ", memNum1=" + memNum1
				+ ", memNum2=" + memNum2 + ", email=" + email + ", phone=" + phone + ", zipcode=" + zipcode
				+ ", address=" + address + ", job=" + job + "]";
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMemNum1() {
		return memNum1;
	}


	public void setMemNum1(String memNum1) {
		this.memNum1 = memNum1;
	}


	public String getMemNum2() {
		return memNum2;
	}


	public void setMemNum2(String memNum2) {
		this.memNum2 = memNum2;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public TempMemberVO(String id, String passwd, String name, String memNum1, String memNum2, String email,
			String phone, String zipcode, String address, String job) {
		super();
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.memNum1 = memNum1;
		this.memNum2 = memNum2;
		this.email = email;
		this.phone = phone;
		this.zipcode = zipcode;
		this.address = address;
		this.job = job;
	}
}
