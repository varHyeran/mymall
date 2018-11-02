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
	
	public ArrayList<HashMap<String, Object>> orderListService(int memberNo){
		System.out.println("MemberItemService.orderListService()");
		Connection conn = null;
		ArrayList<HashMap<String, Object>> memberItemList = null;
		try {
			conn = DBHelper.getConnection();
			// 기능1
			memberItemDao = new MemberItemDao();
			memberItemList = memberItemDao.getMemberItemList(memberNo, conn);
			System.out.println(memberItemList + "<-- 서비스 memberItemList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberItemList;
	}
}
