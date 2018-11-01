package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.jasper.tagplugins.jstl.core.If;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.vo.Member;

public class MemberDao {
	// 회원탈퇴
	public void deleteMember(int no) {
		
	}
	
	// 로그인 실패시 -> null
	// 로그인 성공시 -> 성공한 Member객체
	public Member loginMember(Member member) throws Exception {
		System.out.println("MemberDao.loginMember(Member member)");
		DBHelper dbHelper = new DBHelper();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String id = member.getId();
		String pw = member.getPw();
		
		conn = dbHelper.getConnection();
		String sql = "SELECT no, id,level FROM member WHERE id='" + id + "' and pw='" + pw + "'";
		stmt = conn.prepareStatement(sql);
		System.out.println(sql + "<-- loginMember sql");
		rs = stmt.executeQuery();
		if(rs.next()) {
			member.setNo(rs.getInt("no"));
			member.setId(rs.getString("id"));
			member.setLevel(rs.getInt("level"));
		}
		dbHelper.close(rs, stmt, conn);
		return member;
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