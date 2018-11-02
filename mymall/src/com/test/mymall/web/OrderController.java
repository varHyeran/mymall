package com.test.mymall.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.mymall.service.MemberItemService;
import com.test.mymall.vo.Member;

@WebServlet("/OrderController")
public class OrderController extends HttpServlet {
	// 주문
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OrderController.doGet()");
		// 주문상품번호 불러오기
		int itemNo = Integer.parseInt(request.getParameter("itemNo"));
		System.out.println(itemNo + "<-- OrderController itemNo");
		// 로그인된 상태의 No 불러오기
		Member orderMember = new Member();
		orderMember = (Member)request.getSession().getAttribute("loginMember");
		System.out.println(orderMember + "<-- OrderController orderMember");
		int memberNo = orderMember.getNo();
		System.out.println(memberNo + "<-- OrderController memberNo");
		
		MemberItemService memberItemService = new MemberItemService();
		memberItemService.addOrder(memberNo, itemNo);
		//MemberItemDao.insertMemberItem(MemberItem);
		response.sendRedirect(request.getContextPath() + "/orderList");
	}
}
