package com.kh.rr.admin.model.dao;

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

import com.kh.rr.board.model.vo.Board;
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

	//회원목록 조회
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

				/*System.out.println("관리자 dao : " + mlist );*/
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}


		return memberlist;
	}

	
	//탈퇴 회원목록 조회
		public ArrayList<Member> Nonmemberlist(Connection con) {

			PreparedStatement pstmt = null;
			ResultSet rset = null;

			ArrayList<Member> Nonmemberlist = null;

			String query = prop.getProperty("Nonmemberlist");
			try {		
				pstmt=con.prepareStatement(query);
				rset = pstmt.executeQuery();
				Nonmemberlist = new ArrayList<Member>();

				while(rset.next()) {

					Member bmlist = new Member();

					bmlist.setUserId(rset.getString("M_ID"));
					bmlist.setUserPwd(rset.getString("M_PWD"));
					bmlist.setUserName(rset.getString("M_NAME"));
					bmlist.setMemberType(rset.getString("M_TYPE"));
					bmlist.setStatus(rset.getString("M_STATUS"));

					Nonmemberlist.add(bmlist);

					/*System.out.println("관리자 dao : " + mlist );*/
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}


			return Nonmemberlist;
		}
	//사업자 정보조회
	public ArrayList<Member> bisinesslist(Connection con) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		ArrayList<Member> bisilist = null;

		String query = prop.getProperty("bisinesslist");

		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			bisilist = new ArrayList<Member>();

			while(rset.next()) {
				Member blist = new Member();

				blist.setUserId(rset.getString("M_ID"));
				blist.setUserPwd(rset.getString("M_PWD"));
				blist.setUserName(rset.getString("M_NAME"));
				blist.setMemberType(rset.getString("M_TYPE"));
				blist.setStatus(rset.getString("M_STATUS"));

				bisilist.add(blist);

				/*System.out.println(blist);*/

			}


		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}

		return bisilist;
	}


	//검색어로 조회
	public ArrayList<Member> selectbisiness(Connection con, String keyField, String keyword) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		ArrayList<Member> bisilist = null;

		String query = prop.getProperty("selectbisiness"); 
		
		if(keyword != null) {
			query += " AND " +  keyField.trim()+" LIKE '%" + keyword.trim() + "%' ";
			//trim 문자열 공백제거
		}

		try {
			pstmt = con.prepareStatement(query);

			rset = pstmt.executeQuery();
			bisilist = new ArrayList<Member>();

			System.out.println("query: " + query);
			while(rset.next()) {
				Member blist = new Member();

				blist.setUserId(rset.getString("M_ID"));		
				blist.setUserPwd(rset.getString("M_PWD"));
				blist.setUserName(rset.getString("M_NAME"));
				blist.setMemberType(rset.getString("M_TYPE"));
				blist.setStatus(rset.getString("M_STATUS"));
								
				bisilist.add(blist);
				
			

			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset); 
		}



		return bisilist;
	}

	//공지사항 리스트 조회
	public ArrayList<Board> communitylist(Connection con) {
		
		ArrayList<Board> list = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("communitylist"); 
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(query);
			System.out.println(query);
			list = new ArrayList<Board>();
			
			while(rset.next()) {
				
				Board clist = new Board();
				clist.setBid(rset.getInt("BID"));
				clist.setFbid(rset.getInt("FBID"));
				clist.setNbid(rset.getInt("NBID"));
				clist.setRbid(rset.getInt("RBID"));
				clist.setRefBid(rset.getInt("REF_BID"));
				clist.setWriter(rset.getString("M_ID"));
				clist.setbType(rset.getString("BTYPE"));
				clist.setTitle(rset.getString("TITLE"));
				clist.setbDate(rset.getDate("BDATE"));
				clist.setType(rset.getInt("TYPE"));
				clist.setbContent(rset.getString("BCONTENT"));
				clist.setTarget(rset.getString("TARGET"));
				//S_ID
				clist.setGrade(rset.getInt("GRADE"));
				clist.setbCount(rset.getInt("BCOUNT"));
				//S_COD
				clist.setfCategory(rset.getString("F_CATEGORY"));
				//STATUS
				
				list.add(clist);
				
				System.out.println(list);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		
		return list;
	}

	public int insertCommunity(Connection con, Board community) {

		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertCommunity");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, community.getTitle());
			pstmt.setString(2, community.getbContent());
			pstmt.setString(3, community.getTarget());
			
			result = pstmt.executeUpdate();
			
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		 
		
		return result;
	}

	public Board selectOne(Connection con, int num) {

		Board community = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectOne");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
			
			rset= pstmt.executeQuery();
			
			if(rset.next()) {
				community = new Board();
				community.setTitle(rset.getString("TITLE"));
				community.setbContent(rset.getString("CONTENT"));
				community.setWriter(rset.getString("M_ID"));
				community.setbCount(rset.getInt("BCOUNT"));
				community.setbDate(rset.getDate("BDATE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return community;
	}

	public int updateCount(Connection con, int bid) {
		// TODO Auto-generated method stub
		return 0;
	}

}
