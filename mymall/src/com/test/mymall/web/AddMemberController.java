package com.test.mymall.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.dao.MemberDao;
import com.test.mymall.service.MemberService;
import com.test.mymall.vo.Member;

@WebServlet("/addMember")
public class AddMemberController extends HttpServlet {
	// 1. �����
	// 2. ��ȣ��
	// 3. �� ������
	private MemberService memberService;
	// ȸ������ ��
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AddMemberController.doGet()");
		request.getRequestDispatcher("/WEB-INF/view/addMember.jsp").forward(request, response);
	}
	// ȸ������ �׼�
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AddMemberController.doPost()");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println(id + "<-- id");
		System.out.println(pw + "<-- pw");
		
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		
		memberService = new MemberService();
		try {
			memberService.addMember(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + "/login");
	}
}