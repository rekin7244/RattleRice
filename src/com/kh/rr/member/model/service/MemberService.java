package com.kh.rr.member.model.service;

import static com.kh.rr.common.JDBCTemplate.close;
import static com.kh.rr.common.JDBCTemplate.commit;
import static com.kh.rr.common.JDBCTemplate.getConnection;
import static com.kh.rr.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.rr.member.model.dao.MemberDao;
import com.kh.rr.member.model.dao.UserInfoDao;
import com.kh.rr.member.model.vo.Member;

public class MemberService {

	// 로그인 처리용 메소드
	// public Member loginMember(Member requestMember) {
	// Connection con = getConnection();
	//
	// MemberDao mDao = new MemberDao();
	//
	// int result = mDao.checkStatus(con, requestMember);
	//
	// Member loginUser = new Member();
	//
	// if (result == LoginServlet.LOGIN_OK) {
	// loginUser = mDao.selectMember(con, requestMember);
	// loginUser.setStatus(LoginServlet.LOGIN_OK);
	//
	// } else {
	// if (result == LoginServlet.WRONG_PASSWORD) {
	// loginUser.setStatus(LoginServlet.WRONG_PASSWORD);
	// } else {
	// loginUser.setStatus(LoginServlet.ID_NOT_EXIST);
	//
	// }
	// }
	//
	// return loginUser;
	// }
	//
	// public int joinMember(Member requestMember) {
	// Connection con = getConnection();
	//
	// MemberDao mDao = new MemberDao();
	//
	// int result = mDao.insertMember(con, requestMember);
	//
	// if (result == JoinServlet.JOIN_OK) {
	// commit(con);
	// } else {
	// rollback(con);
	// }
	//
	// return result;
	// }

	public Member loginCheck(String userId, String userPwd) {
		Connection con = getConnection();
		System.out.println("서비스 실행");

		Member loginUser = new MemberDao().loginCheck(con, userId, userPwd);

		close(con);

		return loginUser;
	}

	public int insertMember(Member reqMember) {
		Connection con = getConnection();

		int result = new MemberDao().insertMember(con, reqMember);

		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}

		return result;
	}

	public int insertBusinessMember(Member reqMember) {
		Connection con = getConnection();


		int result = new MemberDao().insertBusinessMember(con, reqMember);
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}

		return result;
	}

	public ArrayList<HashMap<String, Object>> logincheckBusiness(String userId) {
		Connection con = getConnection();

		ArrayList<HashMap<String, Object>> list = new MemberDao().logincheckBusiness(con, userId);

		close(con);

		return list;
	}

	// 아이디 중복 확인용 메소드
	public int idCheck(String userId) {
		Connection con = getConnection();

		int result = new MemberDao().idCheck(con, userId);

		close(con);

		return result;
	}

	public int updatePwd(Member member, String newUserPwd) {
		Connection con = getConnection();

		int result = new MemberDao().updatePwd(con, member,newUserPwd);

		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		return result;
	}

	public int deleteMember(Member loginUser) {
		Connection con = getConnection();

		int result = new MemberDao().deleteMember(con, loginUser);

		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		return result;
	}

	public ArrayList<HashMap<String, Object>> BusinessUpdateForm(String userId) {
		Connection con = getConnection();

		ArrayList<HashMap<String, Object>> list = new MemberDao().logincheckBusiness(con, userId);

		close(con);

		return list;
	}

	public int pointCharge(String amount, String userId) {
		Connection con = getConnection();
		
		int result = new MemberDao().pointCharge(con, amount, userId);

		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}

		return result;

	}

}
