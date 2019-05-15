package com.kh.rr.member.model.service;

import com.kh.rr.member.model.dao.BusinessDao;
import com.kh.rr.member.model.vo.StoreInfo;
import static com.kh.rr.common.JDBCTemplate.*;

import java.sql.Connection;

public class BusinessService {

	public int businessInfoUpdate(StoreInfo storeUser) {
		Connection con = getConnection();
		int result = new BusinessDao().businessInfoUpdate(con, storeUser);
		
		close(con);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		return result;
	}

}
