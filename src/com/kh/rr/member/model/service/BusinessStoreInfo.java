package com.kh.rr.member.model.service;

import static com.kh.rr.common.JDBCTemplate.*;

import java.sql.Connection;

import com.kh.rr.member.model.dao.BusinessDao;
import com.kh.rr.member.model.vo.Member;
import com.kh.rr.member.model.vo.StoreInfo;

public class BusinessStoreInfo {

	public int insertStroreInfo(StoreInfo storeInfo, Member member) {
		Connection con = getConnection();
		
		int result = new BusinessDao().insertStoreInfo(con, storeInfo, member);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
				 
		return result;
	}

}
