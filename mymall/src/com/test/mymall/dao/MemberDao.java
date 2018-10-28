package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.jasper.tagplugins.jstl.core.If;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.vo.Member;

public class MemberDao {
	// 로그인
	public Member loginMember(Member member) throws Exception {
		System.out.println("MemberDao.loginMember(Member member");
		DBHelper dbHelper = new DBHelper();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String loginId = null;
		String loginPw = null;
		
		conn = dbHelper.getConnection();
		String sql = "SELECT id,pw FROM member WHERE id=? and pw=?";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, loginId);
		stmt.setString(2, loginPw);
		System.out.println(sql + "<-- loginMember sql");
		rs = stmt.executeQuery();
		if(rs.next()) {
			
		}
		
		
		return null;
	}
	
	// 회원가입
	public void insertMember(Member member) throws Exception {
		System.out.println("MemberDao.insertMember(Member member)");
		DBHelper dbHelper = new DBHelper();
		Connection conn = null;
		PreparedStatement stmt = null;
		
		conn = dbHelper.getConnection();
		String sql = "INSERT INTO member(id, pw, level) VALUES(?, ?, ?)";
		stmt = conn.prepareStatement(sql);
		System.out.println(sql + "<-- insertMember sql");
		stmt.setString(1, member.getId());
		stmt.setString(2, member.getPw());
		stmt.setInt(3, 0);
		
		stmt.executeUpdate();
		dbHelper.close(null, stmt, conn);
	}
}
