package com.kh.rr.transaction.model.dao;

import static com.kh.rr.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.rr.member.model.vo.Member;
import com.kh.rr.transaction.model.vo.Transaction;

public class TransactionDao {
	private Properties prop = new Properties();
	
	public TransactionDao() {
		String fileName = TransactionDao.class
				.getResource("/sql/transaction/transaction-query.properties")
				.getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	//환불신청 내역 추가하는 메소드
	public int insertTransaction(Connection con, int point, Member loginUser) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertTransaction");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, point);
			pstmt.setString(2, loginUser.getUserId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
	
		return result;
	}

	//모든 트랜잭션 정보 불러와서 채팅방 마이페이지에 뿌려주는 메소드
	public ArrayList<Transaction> selectAllTransaction(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Transaction> list = null;
		String query = prop.getProperty("selectAllTransaction");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			list = new ArrayList<Transaction>();
			while(rset.next()) {
				Transaction t = new Transaction();
				
				t.settId(rset.getInt("TID"));
				t.settDate(rset.getDate("TDATE"));
				t.settPrice(rset.getInt("TPRICE"));
				t.setType(rset.getString("TYPE"));
				t.setUnit(rset.getString("UNIT"));
				t.setUserId(rset.getString("M_ID"));
				
				list.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}
		return list;
	}

	//가장 최근 transaction 불러오는 메소드
	public Transaction selectLatestTransaction(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		Transaction reqTr = new Transaction();
		String query = prop.getProperty("selectLatestTransaction");
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(query);

			if(rset.next()) {
				reqTr.settId(rset.getInt("TId"));
				reqTr.settDate(rset.getDate("TDATE"));
				reqTr.settPrice(rset.getInt("TPRICE"));
				reqTr.setType(rset.getString("TYPE"));
				reqTr.setUnit(rset.getString("UNIT"));
				reqTr.setUserId(rset.getString("M_ID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}
		
		return reqTr;
	}

	//벨 충전 내역 추가하는 메소드
	public int insertBellTransaction(Connection con, int bell, Member loginUser) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertBellTransaction");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, bell);
			pstmt.setString(2, loginUser.getUserId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	//벨 관련 트랜잭션 가져오는 메소드
	public ArrayList<Transaction> selectBellTransaction(Connection con, Member loginUser) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Transaction> list = null;
		
		String query = prop.getProperty("selectBellTransaction");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, loginUser.getUserId());
			
			rset = pstmt.executeQuery();
			list = new ArrayList<Transaction>();
			while(rset.next()) {
				Transaction t = new Transaction();
				t.settId(rset.getInt("TID"));
				t.settDate(rset.getDate("TDATE"));
				t.settPrice(rset.getInt("TPRICE"));
				t.setType(rset.getString("TYPE"));
				t.setUnit(rset.getString("UNIT"));
				t.setUserId(rset.getString("M_ID"));
				
				list.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return list;
	}

	//transaction 테이블에 컬럼추가 - 포인트 사용
	public int payPoint(Connection con, int bell, Member loginUser) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("payPoint");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, bell*500);
			pstmt.setString(2, loginUser.getUserId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
				
		
		return result;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

