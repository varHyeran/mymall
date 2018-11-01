package com.test.mymall.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.dao.MemberItemDao;

@WebServlet("/orderList")
public class OrderListController extends HttpServlet {
	private MemberItemDao memberItemDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OrderListController.doGet()");
		request.getRequestDispatcher("/WEB-INF/view/orderList.jsp").forward(request, response);
		
		//MemberItemDao.getMemberItemList(int memberNo);

	}

}
