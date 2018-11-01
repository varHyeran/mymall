package com.test.mymall.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.MemberDao;
import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.vo.Member;

public class MemberService {
	private MemberDao memberDao;
	private MemberItemDao memberItemDao;
	
	// RemoveMemberController���� MemberService.remoceMember()�� ȣ��
	public void removeMember(int no) {
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
			conn.setAutoCommit(false);	// �ڵ����� commit���� �ʰڴ�
			// 1 function(���)
			memberDao = new MemberDao();
			memberDao.deleteMember(conn, no);
			// 2 function
			memberItemDao = new MemberItemDao();
			memberItemDao.deleteMemberItem(conn, no);
			conn.commit();	// ���� ������ Ŀ�� -> �ϳ��� ������ ����� �ѹ�
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
	
	public void addMember(Member member) throws Exception {	// ���̶� �ٸ�������� throws���� �Ǵµ� ���� ������ ������ �Ф�
		memberDao = new MemberDao();
		memberDao.insertMember(member);
	}
}