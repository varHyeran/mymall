package com.test.mymall.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.service.MemberItemService;
import com.test.mymall.vo.Member;

@WebServlet("/orderList")
public class OrderListController extends HttpServlet {
	private MemberItemDao memberItemDao;
	// 주문리스트
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OrderListController.doGet()");
		Member loginMember = new Member();
		loginMember = (Member)request.getSession().getAttribute("loginMember");
		int memberNo = loginMember.getNo();
		System.out.println(memberNo + "<----------주문리스트 memberNo");
		MemberItemService memberItemService = new MemberItemService();
		ArrayList<HashMap<String, Object>> memberItemList = memberItemService.orderListService(memberNo);

		request.setAttribute("memberItemList", memberItemList);
		request.getRequestDispatcher("/WEB-INF/view/orderList.jsp").forward(request, response);
	}
}
