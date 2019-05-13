package com.kh.rr.admin.model.service;
import static com.kh.rr.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.rr.admin.model.dao.AdminDao;
import com.kh.rr.member.model.vo.Member;

public class AdminService {

	//ȸ����� ��ȸ
	public ArrayList<Member> memberlist() {

		Connection con = getConnection();
		
		ArrayList<Member> list = new AdminDao().memberlist(con);
		
		close(con); 
		
		System.out.println("������ sevice : " + list);
		
		return list;
	}

}
