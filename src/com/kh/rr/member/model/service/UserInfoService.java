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
import com.kh.rr.member.model.vo.UserInfo;

public class UserInfoService {

	public UserInfo userInfo(String userId) {
		Connection con = getConnection();
		UserInfo reqUi = new UserInfoDao().userInfo(con, userId);

		close(con);
		return reqUi;
	}

	public int insertUserInfo(UserInfo reqUserInfo) {
		Connection con = getConnection();

		int result = new UserInfoDao().insertUserInfo(con, reqUserInfo);
		int result2 = new MemberDao().defaultPointCharge(con, reqUserInfo.getUserId());

		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}

		return result;
	}

	public int ChatUpdateUserInfo(UserInfo reqUi) {
		Connection con = getConnection();

		int result = new UserInfoDao().ChatUpdateUserInfo(con, reqUi);

		close(con);

		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}

		return result;
	}

	public int updateProfile(UserInfo ui) {
		Connection con = getConnection();

		int result = new UserInfoDao().updateProfile(con, ui);

		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}

		close(con);

		return result;
	}

	public int updateUserInfo(UserInfo ui) {
		Connection con = getConnection();

		int result = new UserInfoDao().updateInfo(con, ui);

		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}

		close(con);

		return result;
	}

	public int pointUpdate(String amount, String userId) {
		Connection con = getConnection();

		int result = new UserInfoDao().updatePoint(con, amount, userId);

		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}

		return result;
	}

	public ArrayList<HashMap<String, Object>> selectUserPoint(String userId) {

		Connection con = getConnection();

		ArrayList<HashMap<String, Object>> list = new UserInfoDao().selectUserPoint(con, userId);

		close(con);

		return list;
	}


	//벨 충전시, 보유포인트는 차감하고 벨은 증가시키는 메소드
	public int chargeBell(int bell, Member loginUser) {
		Connection con = getConnection();
		
		int result = new UserInfoDao().chargeBell(con, bell, loginUser);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}

		close(con);
		
		return result;
	}
	public HashMap<String, Object> selectCheckEmail(String userName, String userId, String email) {
		Connection con = getConnection();

		HashMap<String, Object> hmap = new UserInfoDao().selectCheckEmail(con, userName, userId, email);

		close(con);

		return hmap;
	}

	public int selectCheckEmailPwd(String userName, String userId, String email) {
		Connection con = getConnection();

		int result = new UserInfoDao().selectCheckEmailPwd(con, userName, userId, email);

		close(con);

		return result;
	}

	public int updateCheckEmailPwd(String userId, String newPwd) {
		Connection con = getConnection();

		int result = new UserInfoDao().updateCheckEmailPwd(con, userId,newPwd);

		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}

		return result;
	}

}
