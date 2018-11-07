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
		SqlSession sqlSession = null;
		try {
			sqlSession = DBHelper.getSqlSession();
			memberItemDao = new MemberItemDao();
			memberItemDao.deleteMemberItem(sqlSession, memberNo);
			memberDao = new MemberDao();
			memberDao.deleteMember(sqlSession, memberNo);
			sqlSession.commit();	// 묶음 단위로 커밋 -> 하나라도 문제가 생기면 롤백
		} catch(Exception e) {
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
	}
	
	// 회원정보 불러오기
	public Member selectMember(Member member) {
		System.out.println("MemberService.selectMember()");
		SqlSession sqlSession = null;
		Member memberReturn = new Member();
		sqlSession = DBHelper.getSqlSession();
		MemberDao memberDao = new MemberDao();
		memberDao.memberSelect(sqlSession, member);
		sqlSession.close();
		return memberReturn;
	}

	// 회원수정처리
	public void updateMember(Member member) throws SQLException {
		System.out.println("MemberService.updateMember()");
		SqlSession sqlSession = null;
		sqlSession = DBHelper.getSqlSession();
		MemberDao memberDao = new MemberDao();
		memberDao.modifyMember(sqlSession, member);
		sqlSession.close();
	}
	
	// 로그인
	public Member memberLogin(Member member) {
		System.out.println("MemberService.memberLogin()");
		SqlSession sqlSession = null;
		memberDao = new MemberDao();
		Member isLogin = new Member();
		isLogin = memberDao.loginMember(sqlSession, member);
		sqlSession.close();
		return isLogin;
	}
	
	// 회원가입
	public void addMember(Member member) {
		System.out.println("MemberService.addMember()");
		SqlSession sqlSession = null;
		memberDao = new MemberDao();
		sqlSession = DBHelper.getSqlSession();
		memberDao.insertMember(sqlSession, member);
		sqlSession.close();
	}
}