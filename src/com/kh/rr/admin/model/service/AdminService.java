package com.kh.rr.admin.model.service;
import static com.kh.rr.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.rr.admin.model.dao.AdminDao;
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
		
		 System.out.println("서비스 실행");
		 
		return bisilist;
	}






}
