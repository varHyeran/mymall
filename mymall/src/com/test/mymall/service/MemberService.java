package com.test.mymall.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.MemberDao;
import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.vo.Member;

public class MemberService {
	private MemberDao memberDao;
	private MemberItemDao memberItemDao;
	
	/*
	// RemoveMemberController에서 MemberService.remoceMember()를 호출
	public void removeMember(int no) {
		SqlSession sqlSession = null;
		try {
			sqlSession = DBHelper.getSqlSession();
			sqlSession.commit();
		} catch(Exception e) {
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
	}
	*/
	
	// RemoveMemberController에서 MemberService.remoceMember()를 호출
	public void removeMember(int memberNo) {
		System.out.println("MemberService.removeMember()");
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
			conn.setAutoCommit(false);	// 자동으로 commit하지 않겠다
			// 2 function
			memberItemDao = new MemberItemDao();
			memberItemDao.deleteMemberItem(conn, memberNo);
			// 1 function(기능)
			memberDao = new MemberDao();
			memberDao.deleteMember(conn, memberNo);
			
			conn.commit();	// 묶음 단위로 커밋 -> 하나라도 문제가 생기면 롤백
		} catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBHelper.close(null, null, conn);
		}
	}
	
	// 회원정보 불러오기
	public Member selectMember(Member member) {
		System.out.println("MemberService.selectMember()");
		Connection conn = null;
		Member memberReturn = new Member();
		try {
			conn = DBHelper.getConnection();
			memberDao = new MemberDao();
			memberReturn = memberDao.memberSelect(conn, member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberReturn;
	}
	
	// 회원수정처리
	public void updateMember(Member member) throws SQLException {
		System.out.println("MemberService.updateMember()");
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
			MemberDao memberDao = new MemberDao();
			memberDao.modifyMember(conn, member);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 로그인
	public Member memberLogin(Member member) throws Exception {
		System.out.println("MemberService.memberLogin()");
		Connection conn = null;
		conn = DBHelper.getConnection();
		memberDao = new MemberDao();
		Member isLogin = new Member();
		isLogin = memberDao.loginMember(member, conn);
		return isLogin;
	}

	// 회원가입
	public void addMember(Member member) throws Exception {	// 쌤이랑 다른사람들은 throws없이 되는데 나는 없으면 오류뜸 ㅠㅠ
		System.out.println("MemberService.addMember()");
		memberDao = new MemberDao();
		memberDao.insertMember(member);
	}
}