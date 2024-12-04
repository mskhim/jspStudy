package co.kh.dev.login.model;

import java.sql.Date;

public class MemberVO {
  private int no;	//         number(5,0) not null,
  private String name;//     varchar2(20) not null,
  private String id;//     varchar2(20) not null,
  private String pwd;//     varchar2(20) not null,
  private String phone;//  varchar2(20) not null,
  private Date regdate;//   date not null
public MemberVO() {
	super();
}
public MemberVO(int no, String name, String id, String pwd, String phone, Date regdate) {
	super();
	this.no = no;
	this.name = name;
	this.id = id;
	this.pwd = pwd;
	this.phone = phone;
	this.regdate = regdate;
}
public MemberVO(String name, String id, String pwd, String phone) {
	super();
	this.name = name;
	this.id = id;
	this.pwd = pwd;
	this.phone = phone;
}
public int getNo() {
	return no;
}
public void setNo(int no) {
	this.no = no;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public Date getRegdate() {
	return regdate;
}
public void setRegdate(Date regdate) {
	this.regdate = regdate;
}
@Override
public String toString() {
	return "MemberVO [no=" + no + ", name=" + name + ", id=" + id + ", pwd=" + pwd + ", phone=" + phone + ", regdate="
			+ regdate + "]";
}
  
  
}