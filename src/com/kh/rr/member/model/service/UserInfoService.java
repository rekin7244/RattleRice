package com.kh.rr.member.model.service;

import static com.kh.rr.common.JDBCTemplate.close;
import static com.kh.rr.common.JDBCTemplate.commit;
import static com.kh.rr.common.JDBCTemplate.getConnection;
import static com.kh.rr.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.rr.member.model.dao.UserInfoDao;
import com.kh.rr.member.model.vo.Attachment;
import com.kh.rr.member.model.vo.UserInfo;

public class UserInfoService {

	public UserInfo userInfo(String userId) {
		Connection con = getConnection();
		UserInfo reqUi = new UserInfoDao().userInfo(con, userId);
		
		close(con);
		return reqUi;
	}

	public int updateUserInfo(UserInfo reqUi) {
		Connection con = getConnection();
		
		int result = new UserInfoDao().updateUserInfo(con, reqUi);
		
		close(con);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		
		return result;
	}


}
