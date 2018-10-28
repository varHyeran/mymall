package com.test.mymall.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.dao.MemberDao;
import com.test.mymall.vo.Member;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private MemberDao memberDao;
	// 로그인 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginController.doGet()");
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}
	// 로그인 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginController.doPost()");
		String loginId = request.getParameter("loginId");
		String loginPw = request.getParameter("loginPw");
		System.out.println(loginId + "<-- loginId");
		System.out.println(loginPw + "<-- loginPw");
		
		Member member = new Member();
		member.setId(loginId);
		member.setPw(loginPw);
		
		this.memberDao = new MemberDao();
		try {
			memberDao.loginMember(member);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
