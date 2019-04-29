package com.kh.w6.member.model.service;

import static com.kh.w6.common.JDBCTemplate.*;

import java.sql.Connection;

import com.kh.w6.member.controller.JoinServlet;
import com.kh.w6.member.controller.LoginServlet;
import com.kh.w6.member.model.dao.MemberDao;
import com.kh.w6.member.model.vo.Member;

public class MemberService {

	// 로그인 처리용 메소드
	public Member loginMember(Member requestMember) {
		Connection con = getConnection();

		MemberDao mDao = new MemberDao();

		int result = mDao.checkStatus(con, requestMember);

		Member loginUser = new Member();

		if (result == LoginServlet.LOGIN_OK) {
			loginUser = mDao.selectMember(con, requestMember);
			loginUser.setStatus(LoginServlet.LOGIN_OK);

		} else {
			if (result == LoginServlet.WRONG_PASSWORD) {
				loginUser.setStatus(LoginServlet.WRONG_PASSWORD);
			} else {
				loginUser.setStatus(LoginServlet.ID_NOT_EXIST);

			}
		}

		return loginUser;
	}

	public int joinMember(Member requestMember) {
		Connection con = getConnection();

		MemberDao mDao = new MemberDao();

		int result = mDao.insertMember(con, requestMember);

		if (result == JoinServlet.JOIN_OK) {
			commit(con);
		} else {
			rollback(con);
		}

		return result;
	}

}
