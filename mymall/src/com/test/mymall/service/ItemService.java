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
	public ArrayList<Item> selectItemService() {
		System.out.println("ItemService.selectItemService()");
		Connection conn = null;
		ArrayList<Item> itemList = null;
		try {
			conn = DBHelper.getConnection();
			// 기능 1
			itemDao = new ItemDao();
			itemList= itemDao.selectItem(conn);
			System.out.println(itemList + " <- 서비스");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(null, null, conn);
		}
		return itemList;
	}
}