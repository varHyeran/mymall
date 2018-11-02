package com.test.mymall.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mymall.service.MemberService;
import com.test.mymall.vo.Member;
import com.test.mymall.vo.MemberItem;

@WebServlet("/deleteMember")
public class DeleteMemberController extends HttpServlet {
	// 회원탈퇴
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DeleteMemberController.doGet()");
		// 로그인 상태 No
		Member deleteMember = new Member();
		deleteMember = (Member)request.getSession().getAttribute("loginMember");
		int memberNo = deleteMember.getNo();
		
		MemberService memberService = new MemberService();
		memberService.removeMember(memberNo);

		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath() + "/index");
	}
}
