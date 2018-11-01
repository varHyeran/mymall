package com.test.mymall.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.service.MemberItemService;
import com.test.mymall.vo.Member;

@WebServlet("/orderList")
public class OrderListController extends HttpServlet {
	private MemberItemDao memberItemDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OrderListController.doGet()");
		Member loginMember = (Member)request.getSession().getAttribute("loginMember");
		int memberNo = loginMember.getNo();
		request.getRequestDispatcher("/WEB-INF/view/orderList.jsp").forward(request, response);
		MemberItemService memberItemService = null;

		memberItemService.orderListService(memberNo);
		//MemberItemDao.getMemberItemList(int memberNo);

	}

}
