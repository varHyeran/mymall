package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.vo.Member;

public class MemberDao {
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
		
		stmt.executeUpdate();
		dbHelper.close(null, stmt, conn);
	}
}
