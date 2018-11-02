package com.test.mymall.vo;

public class Item {
	private int no;
	private String name;
	private int price;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
		System.out.println(no + "<-- Item.setNo()");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		System.out.println(name + "<-- Item.setName()");
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
		System.out.println(price + "<-- Item.setPrice()");
	}
}
