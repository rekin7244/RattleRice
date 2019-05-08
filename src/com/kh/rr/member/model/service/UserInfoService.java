package com.kh.rr.member.model.service;

import java.sql.Connection;

import com.kh.rr.member.model.dao.UserInfoDao;
import com.kh.rr.member.model.vo.UserInfo;

import static com.kh.rr.common.JDBCTemplate.*;

public class UserInfoService {

	public UserInfo userInfo(String userId) {
		Connection con = getConnection();
		UserInfo reqUi = new UserInfoDao().userInfo(con, userId);
		
		
		return reqUi;
	}

}
