package com.test.mymall.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.service.MemberItemService;
import com.test.mymall.vo.Member;

@WebServlet("/order")
public class OrderController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OrderController.doGet()");
		int itemNo = Integer.parseInt(request.getParameter("itemNo"));
		Member member = (Member)request.getSession().getAttribute("loginMember");
		int memberNo = member.getNo();
		MemberItemService memberItemService = new MemberItemService();
		memberItemService.addOrder(memberNo, itemNo);
		//MemberItemDao.insertMemberItem(MemberItem);
		response.sendRedirect(request.getContextPath() + "/WEB-INF/view/orderList.jsp");
	}
}
