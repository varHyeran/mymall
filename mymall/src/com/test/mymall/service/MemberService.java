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
	
	// 로그인
	public Member memberLogin(Member member) throws Exception {
		System.out.println("MemberService.memberLogin()");
		memberDao = new MemberDao();
		Member isLogin = new Member();
		isLogin = memberDao.loginMember(member);
		return isLogin;
	}

	// 회원가입
	public void addMember(Member member) throws Exception {	// 쌤이랑 다른사람들은 throws없이 되는데 나는 없으면 오류뜸 ㅠㅠ
		System.out.println("MemberService.addMember()");
		memberDao = new MemberDao();
		memberDao.insertMember(member);
	}
}