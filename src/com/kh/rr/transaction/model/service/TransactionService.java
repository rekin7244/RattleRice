package com.kh.rr.transaction.model.service;

import static com.kh.rr.common.JDBCTemplate.close;
import static com.kh.rr.common.JDBCTemplate.commit;
import static com.kh.rr.common.JDBCTemplate.getConnection;
import static com.kh.rr.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.rr.member.model.vo.Member;
import com.kh.rr.transaction.model.dao.TransactionDao;
import com.kh.rr.transaction.model.vo.Transaction;
public class TransactionService {

	//환불신청 내역 추가하는 메소드
	public int insertTransaction(int point, Member loginUser) {
		Connection con = getConnection();
		
		int result = new TransactionDao().insertTransaction(con, point, loginUser);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		return result;
	}

	//모든 트랜잭션 정보 불러와서 채팅방 마이페이지에 뿌려주는 메소드
	public ArrayList<Transaction> selectAllTransaction() {
		Connection con = getConnection();
		
		ArrayList<Transaction> list = new TransactionDao().selectAllTransaction(con);
		
		return list;
	}
	//가장 최근 transaction 불러오는 메소드
	public Transaction selectLatestTransaction() {
		Connection con = getConnection();
		
		Transaction reqTr = new TransactionDao().selectLatestTransaction(con);
		
		close(con);
		
		return reqTr;
	}
	
	//벨 충전 내역 추가하는 메소드
	public int insertBellTransaction(int bell, Member loginUser) {
		Connection con = getConnection();
		int result = new TransactionDao().insertBellTransaction(con, bell, loginUser);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	//벨 관련 트랜잭션 가져오는 메소드
	public ArrayList<Transaction> selectBellTransaction(Member loginUser) {
		Connection con = getConnection();
		ArrayList<Transaction> list = new TransactionDao().selectBellTransaction(con, loginUser);
		
		return list;
	}

	//transaction 테이블에 컬럼추가 - 포인트 사용
	public int payPoint(int bell, Member loginUser) {
		Connection con = getConnection();
		
		int result = new TransactionDao().payPoint(con, bell, loginUser);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

}
















