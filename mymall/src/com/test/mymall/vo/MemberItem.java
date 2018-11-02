package com.test.mymall.vo;

public class MemberItem {
	private int no;
	private int memberNo;
	private int itemNo;
	private String orderDate;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
		System.out.println(no + "<-- MemberItem.setNo()");
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
		System.out.println(memberNo + "<-- MemberItem.setMemberNo()");
	}
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
		System.out.println(itemNo + "<-- MemberItem.setItemNo()");
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
		System.out.println(orderDate + "<-- MemberItem.setOrderDate()");
	}
	
}
