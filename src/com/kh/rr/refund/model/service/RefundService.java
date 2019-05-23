package com.kh.rr.refund.model.service;

import static com.kh.rr.common.JDBCTemplate.*;

import java.sql.Connection;

import com.kh.rr.refund.model.dao.RefundDao;
import com.kh.rr.transaction.model.vo.Transaction;

public class RefundService {

//	public int insertRefund(Transaction reqTr) {
//		Connection con = getConnection();
//		
//		int result = new RefundDao().insertRefund(con,reqTr);
//		
//		if(result > 0) {
//			commit(con);
//		}else {
//			rollback(con);
//		}
//	
//		close(con);
//		
//		return result;
//	}

}
