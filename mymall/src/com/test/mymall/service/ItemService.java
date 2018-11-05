package com.test.mymall.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.catalina.connector.Request;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.ItemDao;
import com.test.mymall.vo.Item;

public class ItemService {
	public ItemDao itemDao;

	// 아이템리스트 조회
	public ArrayList<Item> selectItemService(HashMap<String, Object> map) {
		System.out.println("ItemService.selectItemService()");
		Connection conn = null;
		ArrayList<Item> itemList = null;
		try {
			conn = DBHelper.getConnection();
			int rowPerPage = 5;
			int startRow = ((int)map.get("currentPage")-1)*rowPerPage;
			map.put("startRow", startRow);
			map.put("rowPerPage", rowPerPage);
			itemDao = new ItemDao();
			itemList= itemDao.selectItem(conn, map);
			
			int count = itemDao.totalCount(conn);
			int lastPage = count/rowPerPage;
			if(count % rowPerPage != 0) {
				lastPage++;
			}
			map.put("lastPage", lastPage);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(null, null, conn);
		}
		return itemList;
	}
}