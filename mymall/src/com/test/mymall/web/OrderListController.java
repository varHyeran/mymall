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
		
		int currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		Member loginMember = (Member)request.getSession().getAttribute("loginMember");
		int memberNo = loginMember.getNo();
		MemberItemService memberItemService = new MemberItemService();
		HashMap<String, Object> maplist = memberItemService.orderListService(memberNo, currentPage);
		ArrayList<HashMap<String, Object>> memberItemList = (ArrayList<HashMap<String, Object>>) maplist.get("memberItemList");
		
		int lastPage = (int)maplist.get("lastPage");
		
		request.setAttribute("memberItemList", memberItemList);
		request.setAttribute("lastPage", lastPage);
		request.setAttribute("currentPage", currentPage);
		request.getRequestDispatcher("/WEB-INF/view/orderList.jsp").forward(request, response);
	}
}
