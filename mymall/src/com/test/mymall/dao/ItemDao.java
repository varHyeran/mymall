package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.vo.Item;

public class ItemDao {
	// 상품리스트 전체조회
	public ArrayList<Item> selectItem(Connection conn) throws SQLException {
		System.out.println("ItemDao.selectItem()");
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Item> list = new ArrayList<Item>();
		Item item = null;
		
		String sql = "SELECT item.no, item.name, item.price FROM item";
		stmt = conn.prepareStatement(sql);
		System.out.println(sql + "<-------selectItem sql");
		rs = stmt.executeQuery();
		while(rs.next()) {
			item = new Item();
			item.setNo(rs.getInt("no"));
			item.setName(rs.getString("name"));
			item.setPrice(rs.getInt("price"));
			
			list.add(item);
		}
		System.out.println(list + " <- dao list");
		DBHelper.close(rs, stmt, null);
		return list;
	}
}
