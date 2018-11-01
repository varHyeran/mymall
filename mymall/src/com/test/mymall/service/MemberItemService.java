package com.test.mymall.service;

import java.sql.Connection;
import java.util.ArrayList;

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
			// 기능 1
			memberItemDao = new MemberItemDao();
			memberItemDao.insertOrder(memberNo, itemNo, conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(null, null, conn);
		}
	}
	
	public ArrayList<MemberItem> orderListService(int memberNo){
		System.out.println("MemberItemService.orderListService()");
		Connection conn = null;
		ArrayList<MemberItem> orderList = null;
		try {
			conn = DBHelper.getConnection();
			// 기능 1
			memberItemDao = new MemberItemDao();
			memberItemDao.getMemberItemList(memberNo, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
