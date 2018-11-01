package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.vo.Item;
import com.test.mymall.vo.MemberItem;

public class MemberItemDao {
	public void deleteMemberItem(Connection conn, int no) {
		PreparedStatement stmt = conn.prepareStatement("");
	}
	
	public void insertOrder(int memberNo, int itemNo, Connection conn) throws SQLException {
		System.out.println("MemberItemDao.insertOrder()");
		PreparedStatement stmt = null;
		String sql = "INSERT INTO member_item(member_no, item_no, order_date) VALUES('" + memberNo + "', '" + itemNo + "', now())";
		stmt = conn.prepareStatement(sql);
		System.out.println(sql + "<-- insertOrder sql");
		stmt.executeUpdate();
		DBHelper.close(null, stmt, null);
	}
	
	// Member INNER JOIN item
	public ArrayList<HashMap<String, Object>> getMemberItemList(int memberNo, Connection conn) throws SQLException{
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT mi.no, mi.order_date, mi.item_no, i.name, i.price FROM member_item mi INNER JOIN item i ON mi.item_no = i.no WHERE mi.member_no = ?";
		stmt = conn.prepareStatement(sql);
		System.out.println(sql + "<--getMemberItemList sql");
		stmt.setInt(1, memberNo);
		rs = stmt.executeQuery();
		while(rs.next()) {
			// MemberItemJoinItem -> HashMap (원래는 MemberItemJoinItem 데이터 타입을 만들어야되는데 일회용이라 굳이 만들필요가 없어서 HashMap을 사용하겠다)
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("memberItemNo", rs.getInt("no"));
			map.put("orderDate", rs.getString("order_date"));
			map.put("itemNo", rs.getInt("item_no"));
			map.put("itemName", rs.getString("name"));
			map.put("itemPrice", rs.getInt("price"));
			
			list.add(map);
		}
		return list;
	}
	
	
		/*
	public ArrayList<HashMap<String, Object>> getMemberItemList(int memberNo) {
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String sql = "";
		
	 	SELECT mi.no, mi.order_date, mi.item_no, i.name, i.price 
		FROM member_item mi INNER JOIN item i 
		ON mi.item_NO = i.no 
		WHERE mi.member_no = 1
		 
		while(rs.next()) {
			// MemberItemJoinItem -> HashMap (원래는 MemberItemJoinItem 데이터 타입을 만들어야되는데 일회용이라 굳이 만들필요가 없어서 HashMap을 사용하겠다)
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("memberItemNo", rs.getInt("mi.no"));
			map.put("itemPrice", rs.getInt("i.price"));
			list.add(map);
		}
		return list;
	}
	*/
}