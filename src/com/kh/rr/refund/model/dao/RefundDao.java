package com.kh.rr.refund.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.kh.rr.common.JDBCTemplate.*;
import com.kh.rr.transaction.model.vo.Transaction;

public class RefundDao {
	private Properties prop = new Properties();
	
	public RefundDao() {
		String fileName = RefundDao.class
					.getResource("/sql/transaction/refund-query.properties")
					.getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//리펀드 테이블에 추가하는 메소드
//	public int insertRefund(Connection con, Transaction reqTr) {
//		PreparedStatement pstmt = null;
//		int result = 0;
//		String query = prop.getProperty("insertRefund");
//		
//		try {
//			pstmt = con.prepareStatement(query);
//			pstmt.setInt(1, reqTr.gettPrice());
//			pstmt.setInt(2, reqTr.gettId());
//			
//			result = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//		
//		return result;
//	}

}
