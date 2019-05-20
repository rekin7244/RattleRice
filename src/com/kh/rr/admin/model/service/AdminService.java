package com.kh.rr.admin.model.service;
import static com.kh.rr.common.JDBCTemplate.close;
import static com.kh.rr.common.JDBCTemplate.commit;
import static com.kh.rr.common.JDBCTemplate.getConnection;
import static com.kh.rr.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.rr.admin.model.dao.AdminDao;
import com.kh.rr.board.model.vo.Board;
import com.kh.rr.member.model.vo.Member;

public class AdminService {

	//회원 조회
	public ArrayList<Member> memberlist() {

		Connection con = getConnection();
		
		ArrayList<Member> list = new AdminDao().memberlist(con);
		
		close(con);
		
		return list;
	}
	
	//탈퇴회원 조회
	public ArrayList<Member> NonMemberlist() {

		Connection con = getConnection();
		
		ArrayList<Member> blist = new AdminDao().Nonmemberlist(con);
		
		System.out.println("dao : " + blist);
		
		close(con);
		
		return blist;
	}

	//사업자 조회
	public ArrayList<Member> bisinesslist() {
		
		Connection con = getConnection();
		
		ArrayList<Member> bisilist = new AdminDao().bisinesslist(con);
		
		close(con);
		
		
		
		return bisilist;
	}

	//검색어로 회원 조회
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
		
		System.out.println("서비스실행 : " + list);
		
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
		
		/*System.out.println("게시판 상세보기 서비스");*/
		
		return community;
	}

}
