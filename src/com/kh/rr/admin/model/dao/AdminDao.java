package com.kh.rr.admin.model.dao;

import static com.kh.rr.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.rr.member.model.vo.Member;

public class AdminDao {

	private Properties prop = new Properties();
	
	public AdminDao() {
		
		String fileName = AdminDao.class.getResource("/sql/admin/admin-query.properties").getPath();
		
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Member> memberlist(Connection con) {
	
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<Member> memberlist = null;
		
		String query = prop.getProperty("memberlist");
		
		
		try {
			
			pstmt=con.prepareStatement(query);
			rset = pstmt.executeQuery();
			memberlist = new ArrayList<Member>();
			
			while(rset.next()) {
				
				Member mlist = new Member();
				
				mlist.setUserId(rset.getString("M_ID"));
				mlist.setUserPwd(rset.getString("M_PWD"));
				mlist.setUserName(rset.getString("M_NAME"));
				mlist.setMemberType(rset.getString("M_TYPE"));
				mlist.setStatus(rset.getString("M_STATUS"));
				
				memberlist.add(mlist);
				
				System.out.println("관리자 dao : " + mlist );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return memberlist;
	}

}
