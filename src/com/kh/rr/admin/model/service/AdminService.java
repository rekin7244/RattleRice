package com.kh.rr.admin.model.service;
import static com.kh.rr.common.JDBCTemplate.close;
import static com.kh.rr.common.JDBCTemplate.commit;
import static com.kh.rr.common.JDBCTemplate.getConnection;
import static com.kh.rr.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.rr.admin.model.dao.AdminDao;
import com.kh.rr.admin.model.vo.Settlement;
import com.kh.rr.board.model.vo.Board;
import com.kh.rr.common.model.vo.PageInfo;
import com.kh.rr.member.model.vo.Member;

public class AdminService {

	//회원 조회
	public ArrayList<Member> memberlist() {

		Connection con = getConnection();
		
		ArrayList<Member> list = new AdminDao().memberlist(con);
		
		System.out.println("service접근");
		
		close(con);
		
		return list;
	}
	
	//탈퇴회원 조회
	public ArrayList<Member> NonMemberlist() {

		Connection con = getConnection();
		
		ArrayList<Member> bmlist = new AdminDao().Nonmemberlist(con);
		
	
		
		close(con);
		
		return bmlist;
	}

	//사업자 조회
	public ArrayList<Member> bisinesslist() {
		
		Connection con = getConnection();
		
		ArrayList<Member> bisilist = new AdminDao().bisinesslist(con);
		
		close(con);
		
		
		
		return bisilist;
	}

	//검색어로 사업자 조회
	public ArrayList<Member> bisinessSelect(String keyField, String keyword) {
		
		 Connection con = getConnection();
		 
		 ArrayList<Member> bisilist = new AdminDao().selectbisiness(con, keyField, keyword);
		 
		 close(con);
		
		/* System.out.println("서비스 실행");*/
		 
		return bisilist;
	}

	//공지사항 목록조회
	public ArrayList<Board> communitylist() {

		Connection con = getConnection();
		
		ArrayList<Board> list = new AdminDao().communitylist(con);
		
		close(con);
		
		/*System.out.println("서비스실행 : " + list);*/
		
		return list;
	}

	//공지사항 추가
	public int insertCommunity(Board community) {

		Connection con = getConnection();
		
		int result = new AdminDao().insertCommunity(con, community);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	//공지사항 상세보기
	public Board selectOne(int num) {

		Connection con = getConnection();
		
		Board community = new AdminDao().selectOne(con, num);
		
		if(community != null) {
			
			int result = new AdminDao().updateCount(con, community.getNbid());
			
			if(result>0) {
				commit(con);
			}else {
				rollback(con);
			}
		}
		
		close(con);
		
		/*System.out.println("게시판 상세보기 서비스");
		*/
		return community;
	}
	
	
    //공지사항 삭제
	public int deleteCommunity(int nbid) {
		
		Connection con = getConnection();
		
		int result = new AdminDao().deleteCommunity(con, nbid);
		
		
		if(result>0) {
			commit(con);
			
		}else {
			rollback(con);
		}
    close(con);
		
		return result;
	}

	//공지사항 수정
	public int updateCommunity(Board community) {
		
		Connection con = getConnection();
		
		int result = new AdminDao().updateCommunity(con, community);
		
		System.out.println("서비스" + result);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		
		return result;
	
	}
  	//코인 내역 전체 카운트 조회
	public int getCoinRecordListCount() {
		Connection con = getConnection();
		
		int listCount = new AdminDao().getCoinRecordListCount(con);
		
		close(con);
		
		return listCount;
	}
	//코인 내역 전체 조회
	public ArrayList<HashMap<String, Object>> coinRecord(PageInfo pi) {
		Connection con = getConnection();
		
		ArrayList<HashMap<String,Object>> list = new AdminDao().coinRecord(con, pi);
		
		close(con);
		
		return list;
	}
	//코인 내역 검색 카운트 조회
	public int searchCoinRecordListCount(String condition, String userId) {
		Connection con = getConnection();
		
		int listCount = new AdminDao().searchCoinRecordListCount(con,condition,userId);
		
		close(con);
		
		return listCount;
	}

	public ArrayList<HashMap<String, Object>> searchCoinRecord(PageInfo pi, String condition, String userId) {
		Connection con = getConnection();
		
		ArrayList<HashMap<String,Object>> list = new AdminDao().searchCoinRecord(con,pi,condition,userId);
		
		close(con);
		
		return list;
	}

	//게시판 상세보기 수정용
	public Board selectCommunity(int nbid) {
		
		Connection con = getConnection();
		
		Board community = new AdminDao().SelectCommunity(con, nbid);
			
		if(community != null) {
			int result = new AdminDao().updateCount(con, community.getNbid());
			
			if(result>0) {
				commit(con);
			}else {
				rollback(con);
			}
		}
		
		close(con);
		
		
		return community;
	}

	//일반 회원 검색 기능
	public ArrayList<Member> memberSelect(String keyField, String keyword) {
		Connection con = getConnection();
		 
		 ArrayList<Member> memberSelect = new AdminDao().selectmember(con, keyField, keyword);
		 
		 System.out.println("멤버 서비스 : " + memberSelect);
		 
		 close(con);
		 
		System.out.println("일반 회원 검색 서비스 실행");
		 
		return memberSelect;
  }
  
	public int getPointSettlementListCount() {
		Connection con = getConnection();
		
		int listCount = new AdminDao().getPointSettlementListCount(con);
		
		close(con);
		
		return listCount;
	}

	public ArrayList<Settlement> getPointSettlementList(PageInfo pi) {
		Connection con = getConnection();
		
		ArrayList<Settlement> list = new AdminDao().getPointSettlementList(con,pi);
		
		close(con);
		
		return list;
	}
	//포인트 한 건 정산 처리
	public int pSettlementOne(int tid) {
		Connection con = getConnection();
		//REFUND 테이블 update
		int result = new AdminDao().pSettlementOne(con,tid);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		return result;
	}

	public int pSettleChecked(String[] arr) {
		Connection con = getConnection();

		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			System.out.println("arr"+i+" : "+arr[i]);
			result += new AdminDao().pSettlementOne(con, Integer.parseInt(arr[i]));
		}
		System.out.println("result : "+result);
		if(result == arr.length) {
			commit(con);
		}else {
			rollback(con);
		}
		return result;
	}

	public int getPointSettleSearchCount(String condition, String keyword) {
		Connection con = getConnection();
		
		int listCount = new AdminDao().getPointSettleSearchCount(con,condition,keyword);
		
		close(con);
		
		return listCount;
	}

	public ArrayList<Settlement> getPointSettleSearchList(PageInfo pi, String condition, String keyword) {
		Connection con = getConnection();
		
		ArrayList<Settlement> list = new AdminDao().getPointSettleSearchList(con,pi,condition,keyword);
		
		close(con);
		
		return list;
	}

	



}
