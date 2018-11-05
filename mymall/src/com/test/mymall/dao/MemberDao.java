package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.jasper.tagplugins.jstl.core.If;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.vo.Member;

public class MemberDao {
	// 회원탈퇴
	public void deleteMember(Connection conn, int memberNo) throws SQLException {
		System.out.println("MemberDao.deleteMember()");
		PreparedStatement stmt = null;
		
		String sql = "DELETE FROM member WHERE no=?";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, memberNo);
		System.out.println(stmt + "<---- deleteMember stmt");
		stmt.executeUpdate();
		stmt.close();
	}
	
	// 회원수정
	public void modifyMember(Connection conn, Member member) throws SQLException {
		System.out.println("MemberDao.modifyMember()");
		PreparedStatement stmt = null;
		
		String sql = "UPDATE member SET pw=? WHERE id=?";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, member.getPw());
		stmt.setString(2, member.getId());
		System.out.println(stmt + "<---- modifyMember stmt");
		stmt.executeUpdate();
		DBHelper.close(null, stmt, conn);
	}
	
	// 회원정보 불러오기
	public Member memberSelect(Connection conn, Member member) throws SQLException {
		System.out.println("MemberDao.memberSelect()");
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT id, level FROM member WHERE id=?";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, member.getId());
		System.out.println(stmt + "<----- memberSelect stmt");
		rs = stmt.executeQuery();
		Member selectMember = new Member();
		if(rs.next()) {
			selectMember.setId(rs.getString("id"));
			selectMember.setLevel(rs.getInt(2));
		}
		DBHelper.close(rs, stmt, conn);
		return selectMember;
	}
	
	// 로그인 실패시 -> null
	// 로그인 성공시 -> 성공한 Member객체
	public Member loginMember(Member member, Connection conn) throws Exception {
		System.out.println("MemberDao.loginMember(Member member)");
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String id = member.getId();
		String pw = member.getPw();
		
		String sql = "SELECT no, id, level FROM member WHERE id='" + id + "' and pw='" + pw + "'";
		stmt = conn.prepareStatement(sql);
		System.out.println(stmt + "<-- loginMember stmt");
		rs = stmt.executeQuery();
		if(rs.next()) {
			member.setNo(rs.getInt("no"));
			member.setId(rs.getString("id"));
			member.setLevel(rs.getInt("level"));
		} else {
			member.setId(null);
		}
		DBHelper.close(rs, stmt, conn);
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
		stmt.setString(1, member.getId());
		stmt.setString(2, member.getPw());
		stmt.setInt(3, 0);
		System.out.println(stmt + "<-- insertMember stmt");
		stmt.executeUpdate();
		dbHelper.close(null, stmt, conn);
	}
}