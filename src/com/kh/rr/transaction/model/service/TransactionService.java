package com.kh.rr.transaction.model.service;

import static com.kh.rr.common.JDBCTemplate.commit;
import static com.kh.rr.common.JDBCTemplate.getConnection;
import static com.kh.rr.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.kh.rr.transaction.model.dao.TransactionDao;
public class TransactionService {

	public int insertTransaction(String point) {
		Connection con = getConnection();
		
		int result = new TransactionDao().insertTransaction(con, point);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		return result;
	}
	
}
