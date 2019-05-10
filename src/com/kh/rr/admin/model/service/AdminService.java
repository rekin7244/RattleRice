package com.kh.rr.admin.model.service;

import com.kh.rr.admin.model.dao.AdminDao;
import com.kh.rr.admin.model.vo.SMS;
import static com.kh.rr.common.JDBCTemplate.*;

import java.sql.Connection;

public class AdminService {
	
	public int insertSms(SMS newsms) {
		Connection con = getConnection();
		
		int result = new AdminDao().insertSms(con, newsms);
		
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

}
