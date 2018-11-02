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
	// 주문리스트 삭제
	public void deleteMemberItem(Connection conn, int memberNo) throws SQLException {
		System.out.println("MemberDao.deleteItem()");
		PreparedStatement stmt = null;
		
		String sql = "DELETE FROM member_item WHERE member_no=?";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, memberNo);
		System.out.println(stmt + "<---- deleteMemberItem stmt");
		stmt.executeUpdate();
		DBHelper.close(null, stmt, null);
	}
	// 주문
	public void insertOrder(int memberNo, int itemNo, Connection conn) throws SQLException {
		System.out.println("MemberItemDao.insertOrder()");
		PreparedStatement stmt = null;
		String sql = "INSERT INTO member_item(member_no, item_no, order_date) VALUES('" + memberNo + "', '" + itemNo + "', now())";
		stmt = conn.prepareStatement(sql);
		System.out.println(stmt + "<-- insertOrder stmt");
		stmt.executeUpdate();
		DBHelper.close(null, stmt, null);
	}
	
	// Member INNER JOIN item	주문리스트
	public ArrayList<HashMap<String, Object>> getMemberItemList(int memberNo, Connection conn) throws SQLException{
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT mi.no, mi.order_date, mi.item_no, i.name, i.price FROM member_item mi INNER JOIN item i ON mi.item_no = i.no WHERE mi.member_no = ?";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, memberNo);
		System.out.println(stmt + "<--getMemberItemList stmt");
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
}