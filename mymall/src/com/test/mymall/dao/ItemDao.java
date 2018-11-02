package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.vo.Item;

public class ItemDao {
	/*
	public List<Item> selectItemList(SqlSession sqlSession) {	// ArrayList는 List로 받을 수 있지만 List는 ArrayList로 못 받음
		return sqlSession.selectList("com.test.mymall.dao.ItemMapper.selectItemList");
	}
	public int insertItem(SqlSession sqlSession, Item item) {
		return sqlSession.insert("", item);
	}
	*/
	
	public HashMap<String, Object> totalPage()	{
		return null;
	}
	
	// 상품리스트 전체조회
	public ArrayList<Item> selectItem(Connection conn) throws SQLException {
		System.out.println("ItemDao.selectItem()");
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Item> list = new ArrayList<Item>();
		Item item = null;
		
		String sql = "SELECT item.no, item.name, item.price FROM item";
		stmt = conn.prepareStatement(sql);
		System.out.println(stmt + "<-------selectItem stmt");
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
