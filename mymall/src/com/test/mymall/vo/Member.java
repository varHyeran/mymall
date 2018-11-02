package com.test.mymall.vo;

public class Member {
	private int no;
	private String id;
	private String pw;
	private int level;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
		System.out.println(no + "<-- Member.setNo()");
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
		System.out.println(id + "<-- Member.setId()");
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
		System.out.println(pw + "<-- Member.setPw()");
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
		System.out.println(level + "<-- Member.setLevel()");
	}
	
}
