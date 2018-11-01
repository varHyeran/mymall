package com.test.mymall.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.mymall.dao.MemberDao;
import com.test.mymall.vo.Member;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private MemberDao memberDao;
	// 로그인 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginController.doGet()");
		if(request.getSession().getAttribute("loginMember") == null) {
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
		} else {
			System.out.println("로그인 중입니다...");
			response.sendRedirect(request.getContextPath() + "/index");
		}
	}
	// 로그인 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. id, password 
		System.out.println("LoginController.doPost()");
		String loginId = request.getParameter("loginId");
		String loginPw = request.getParameter("loginPw");
		System.out.println(loginId + "<-- loginId");
		System.out.println(loginPw + "<-- loginPw");
	
		memberDao = new MemberDao();
		Member member = new Member();
		member.setId(loginId);
		member.setPw(loginPw);

		Member sessionMember = new Member();
		try {
			sessionMember = memberDao.loginMember(member);
			if(sessionMember.getId() != null) {
				HttpSession session = request.getSession();
				session.setAttribute("loginMember", sessionMember);
				response.sendRedirect(request.getContextPath() + "/index");
				System.out.println("로그인 성공");
			} else {
				response.sendRedirect(request.getContextPath() + "/login");
				System.out.println("로그인 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

}
