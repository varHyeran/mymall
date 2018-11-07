package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.apache.jasper.tagplugins.jstl.core.If;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.vo.Member;

public class MemberDao {
	// 회원탈퇴
	public void deleteMember(SqlSession sqlSession, int memberNo) {
		System.out.println("MemberDao.deleteMember()");
		sqlSession.delete("com.test.mymall.dao.MemberMapper.deleteMember", memberNo);
	}
	
	// 회원수정
	public void modifyMember(SqlSession sqlSession, Member member){
		System.out.println("MemberDao.modifyMember()");
		sqlSession.update("com.test.mymall.dao.MemberMapper.modifyMember", member);
	}
	
	// 회원정보 불러오기
	public Member memberSelect(SqlSession sqlSession, Member member){
		System.out.println("MemberDao.selectMember()");
		return sqlSession.selectOne("com.test.mymall.dao.MemberMapper.selectMember", member);
	}
	
	// 로그인 실패시 -> null
	// 로그인 성공시 -> 성공한 Member객체
	public Member loginMember(SqlSession sqlSession, Member member) {
		System.out.println("MemberDao.loginMember()");
		return sqlSession.selectOne("com.test.mymall.dao.MemberMapper.login", member);
	}
	
	// 회원가입
	public void insertMember(SqlSession sqlSession, Member member) {
		System.out.println("MemberDao.insertMember()");
		sqlSession.insert("com.test.mymall.dao.MemberMapper.insertMember", member);
	}
}