package com.test.mymall.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.service.MemberService;
import com.test.mymall.vo.Member;

@WebServlet("/modifyMember")
public class ModifyController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ModifyController.doGet()");
		Member member = new Member();
		member = (Member)request.getSession().getAttribute("loginMember");
		
		MemberService memberService = new MemberService();
		memberService.selectMember(member);
		request.getRequestDispatcher("/WEB-INF/view/modifyMember.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ModifyController.doPost()");

	}
}
