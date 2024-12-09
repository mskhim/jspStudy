package co.kh.dev.board.model;

import java.sql.Date;

public class BoardVO {
	
	private int rownum;          // Primary Key
    private int no;          // Primary Key
    private int memberNo;       // Foreign Key
    private String name;       // Foreign Key
    private String title;       // Not Null
    private String text;        // Not Null
    private int count;          // Default 0
    public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public int getNo() {
		return no;
	}
	private Date subdate;       // Not Null
    


	public int getRownum() {
		return rownum;
	}





	public BoardVO(int rownum, int no, String name, String title, String text, int count, Date subdate) {
		super();
		this.rownum = rownum;
		this.no = no;
		this.name = name;
		this.title = title;
		this.text = text;
		this.count = count;
		this.subdate = subdate;
	}





	public void setRownum(int rownum) {
		this.rownum = rownum;
	}


	public void setNo(int no) {
		this.no = no;
	}



	public BoardVO(int memberNo, String title, String text) {
		super();
		this.memberNo = memberNo;
		this.title = title;
		this.text = text;
	}


	public BoardVO() {
		super();
	}
	
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getSubdate() {
		return subdate;
	}
	public void setSubdate(Date subdate) {
		this.subdate = subdate;
	}
    
    

}
