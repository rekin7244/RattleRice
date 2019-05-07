package com.kh.rr.member.model.service;

import static com.kh.rr.common.JDBCTemplate.*;

import java.sql.Connection;


import com.kh.rr.member.model.dao.MemberDao;
import com.kh.rr.member.model.vo.Member;

public class MemberService {

	// 로그인 처리용 메소드
//	public Member loginMember(Member requestMember) {
//		Connection con = getConnection();
//
//		MemberDao mDao = new MemberDao();
//
//		int result = mDao.checkStatus(con, requestMember);
//
//		Member loginUser = new Member();
//
//		if (result == LoginServlet.LOGIN_OK) {
//			loginUser = mDao.selectMember(con, requestMember);
//			loginUser.setStatus(LoginServlet.LOGIN_OK);
//
//		} else {
//			if (result == LoginServlet.WRONG_PASSWORD) {
//				loginUser.setStatus(LoginServlet.WRONG_PASSWORD);
//			} else {
//				loginUser.setStatus(LoginServlet.ID_NOT_EXIST);
//
//			}
//		}
//
//		return loginUser;
//	}
//
//	public int joinMember(Member requestMember) {
//		Connection con = getConnection();
//
//		MemberDao mDao = new MemberDao();
//
//		int result = mDao.insertMember(con, requestMember);
//
//		if (result == JoinServlet.JOIN_OK) {
//			commit(con);
//		} else {
//			rollback(con);
//		}
//
//		return result;
//	}

	public Member loginCheck(String userId, String userPwd) {
		Connection con = getConnection();
		
		
		System.out.println("service 에서 받은 userId" + userId);
		System.out.println("service 에서 받은 password" + userPwd);
		Member loginUser = new MemberDao().loginCheck(con, userId, userPwd);
		
		close(con);
		
		return loginUser;
	}
	
	public int insertMember(Member reqMember) {
		Connection con = getConnection();

		int result = new MemberDao().insertMember(con, reqMember);

		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}

		return result;
	}
	public int insertBusinessMember(Member reqMember) {
		Connection con = getConnection();

		int result = new MemberDao().insertBusinessMember(con, reqMember);

		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}

		return result;
	}

}
