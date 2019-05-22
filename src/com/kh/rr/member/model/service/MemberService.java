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

	public Member loginCheck(String userId, String userPwd) {
		Connection con = getConnection();

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

	//카카오톡 로그인 시 기존 회원 인지 판단하는 매소드
	public Member kakaoCheck(String id) {
		Connection con = getConnection();
		
		Member reqMember = new MemberDao().kakaoCheck(con, id);
		
		close(con);
		
		return reqMember;
	}

}
