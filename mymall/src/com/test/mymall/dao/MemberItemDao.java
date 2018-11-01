package com.test.mymall.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class MemberItemDao {
	// Member INNER JOIN item
	public ArrayList<HashMap<String, Object>> getMemberItemList(int memberNo) {
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String sql = "";
		/*
	 	SELECT mi.no, mi.order_date, mi.item_no, i.name, i.price 
		FROM member_item mi INNER JOIN item i 
		ON mi.item_NO = i.no 
		WHERE mi.member_no = 1
		 */
		while(rs.next()) {
			// MemberItemJoinItem -> HashMap (원래는 MemberItemJoinItem 데이터 타입을 만들어야되는데 일회용이라 굳이 만들필요가 없어서 HashMap을 사용하겠다)
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("memberItemNo", rs.getInt("mi.no"));
			map.put("itemPrice", rs.getInt("i.price"));
			list.add(map);
		}
		return list;
	}
}
