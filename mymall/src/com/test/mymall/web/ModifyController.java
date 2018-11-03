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
		Member resultMember = new Member();
		resultMember = memberService.selectMember(member);
		request.getSession().setAttribute("member", resultMember);
		request.getRequestDispatcher("/WEB-INF/view/modifyMember.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ModifyController.doPost()");
		String id = request.getParameter("modifyId");
		String pw = request.getParameter("modifyPw");
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		
		MemberService memberService = new MemberService();
		try {
			memberService.updateMember(member);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + "/index");
	}
}
