package com.test.mymall.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.vo.MemberItem;

public class MemberItemService {
	private MemberItemDao memberItemDao;
	
	public void addOrder(int memberNo, int itemNo) {
		System.out.println("MemberItemService.addOrder()");
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
			// 기능1
			memberItemDao = new MemberItemDao();
			memberItemDao.insertOrder(memberNo, itemNo, conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(null, null, conn);
		}
	}
	
	public HashMap<String, Object> orderListService(int memberNo, int currentPage){
		System.out.println("MemberItemService.orderListService()");
		Connection conn = null;
		ArrayList<HashMap<String, Object>> memberItemList = null;
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			conn = DBHelper.getConnection();
			int rowPerPage = 5;
			int startRow = (currentPage-1)*rowPerPage;
			map.put("startRow", startRow);
			map.put("rowPerPage", rowPerPage);
			memberItemDao = new MemberItemDao();
			memberItemList = (ArrayList<HashMap<String, Object>>)memberItemDao.getMemberItemList(memberNo, conn, map);
			map.put("memberItemList", memberItemList);
			int count = memberItemDao.totalCount(conn, memberNo);
			System.out.println(count + "<==================================count");
			int lastPage = count/rowPerPage;
			if(count % rowPerPage != 0) {
				lastPage++;
			}
			System.out.println(lastPage + "<==================================lastPage");
			map.put("lastPage", lastPage);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(null, null, conn);
		}
		return map;
		
	}
}
