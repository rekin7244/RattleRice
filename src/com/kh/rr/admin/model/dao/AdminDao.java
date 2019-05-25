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
import java.util.HashMap;
import java.util.Properties;

import com.kh.rr.admin.model.vo.SMS;
import com.kh.rr.admin.model.vo.Settlement;
import com.kh.rr.board.model.vo.Board;
import com.kh.rr.common.model.vo.PageInfo;
import com.kh.rr.member.model.vo.Member;
import com.kh.rr.transaction.model.vo.Transaction;

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
				/*mlist.setUserId(rset.getString("M_ID"));
				mlist.setUserPwd(rset.getString("M_PWD"));
				mlist.setUserName(rset.getString("M_NAME"));
				mlist.setMemberType(rset.getString("M_TYPE"));
				mlist.setStatus(rset.getString("M_STATUS"));
				mlist.setEmail(rset.getString("EMAIL"));
				mlist.setPhone(rset.getString("PHONE"));*/

				mlist.setUserId(rset.getString("M_ID"));
				mlist.setUserName(rset.getString("M_NAME"));
				mlist.setEmail(rset.getString("EMAIL"));
				mlist.setPhone(rset.getString("PHONE"));
				mlist.setGender(rset.getString("GENDER"));
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
				bmlist.setUserName(rset.getString("M_NAME"));
				bmlist.setGender(rset.getString("GENDER"));
				bmlist.setPhone(rset.getString("PHONE"));	
				bmlist.setEmail(rset.getString("EMAIL"));
				

				Nonmemberlist.add(bmlist);

				System.out.println("탈퇴 회원 dao : " + bmlist );
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
	public ArrayList<HashMap<String, Object>> bisinesslist(Connection con) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		ArrayList<HashMap<String, Object>> bisilist = null;
		HashMap<String, Object> hmap = null;


		String query = prop.getProperty("bisinesslist");

		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			bisilist = new ArrayList<HashMap<String, Object>>();

			while(rset.next()) {

				hmap = new HashMap<String, Object>();
				hmap.put("userId", rset.getString("M_ID"));
				hmap.put("bcode", rset.getString("BCODE"));
				hmap.put("holder", rset.getString("HOLDER"));
				hmap.put("account", rset.getString("ACCOUNT"));
				hmap.put("brand", rset.getString("BRAND"));
				hmap.put("contact", rset.getString("CONTACT"));

				bisilist.add(hmap);



				/*		blist.setUserId(rset.getString("M_ID"));
				blist.setUserPwd(rset.getString("M_PWD"));
				blist.setUserName(rset.getString("M_NAME"));
				blist.setMemberType(rset.getString("M_TYPE"));
				blist.setStatus(rset.getString("M_STATUS"));

				bisilist.add(blist);

				System.out.println(blist);*/

			}


		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}

		return bisilist;
	}


	//검색어로 사업자 조회

	public ArrayList<HashMap<String, Object>> bisinessSelect(Connection con, String keyField, String keyword) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		ArrayList<HashMap<String, Object>> bisilist = null;
		HashMap<String, Object> hmap = null;


		String query = prop.getProperty("selectbisiness");

		if(keyword != null) {
			query += " AND " +  keyField.trim()+" LIKE '%" + keyword.trim() + "%' ";
			//trim 문자열 공백제거

			try {
				pstmt = con.prepareStatement(query);
				rset = pstmt.executeQuery();
				bisilist = new ArrayList<HashMap<String, Object>>();

				while(rset.next()) {

					hmap = new HashMap<String, Object>();
					hmap.put("userId", rset.getString("M_ID"));
					hmap.put("bcode", rset.getString("BCODE"));
					hmap.put("holder", rset.getString("HOLDER"));
					hmap.put("account", rset.getString("ACCOUNT"));
					hmap.put("brand", rset.getString("BRAND"));
					hmap.put("contact", rset.getString("CONTACT"));

					bisilist.add(hmap);

				}


			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
				close(rset);
			}
		}

		return bisilist;
	}
	/*public ArrayList<Member> selectbisiness(Connection con, String keyField, String keyword) {

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
	}*/

	//공지사항 리스트 조회
	public ArrayList<Board> communitylist(Connection con) {

		ArrayList<Board> list = null;
		Statement stmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("communitylist"); 

		try {
			stmt = con.createStatement();

			rset = stmt.executeQuery(query);
			/*System.out.println(query);*/
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

				/*System.out.println(list);*/
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}


		return list;
	}

	//공지사항 추가
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

			/*System.out.println(result);*/
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}


		return result;
	}

	//공지사항 상세보기
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
				community.setNbid(rset.getInt("NBID"));
				community.setTitle(rset.getString("TITLE"));
				community.setbContent(rset.getString("BCONTENT"));
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

	//조회수 증가 메소드
	public int updateCount(Connection con, int nbid) {

		int result = 0;
		PreparedStatement pstmt = null;

		String query = prop.getProperty("updeteCount");

		/*System.out.println("카운트 dao실행 : " + nbid);*/



		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, nbid);
			pstmt.setInt(2, nbid);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	//공지사항 삭제
	public int deleteCommunity(Connection con, int nbid) {

		int result = 0;
		PreparedStatement pstmt = null;

		String query =prop.getProperty("deleteCommunity");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, nbid);

			result=pstmt.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
		}finally {

			close(pstmt);
		}

		return result;
	}

	

	public int getCoinRecordListCount(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("getCoinRecordListCount");
		int listCount = 0;

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			while(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return listCount;
	}


	public ArrayList<HashMap<String, Object>> coinRecord(Connection con, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("coinRecord");
		ArrayList<HashMap<String,Object>> list = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pi.getStartPage());
			pstmt.setInt(2, pi.getEndpage());
			rset = pstmt.executeQuery();

			list = new ArrayList<HashMap<String,Object>>();
			while(rset.next()) {
				HashMap<String,Object> hmap = new HashMap<String,Object>();
				hmap.put("date", rset.getDate("TDATE"));
				hmap.put("userId", rset.getString("M_ID"));
				hmap.put("amount", rset.getInt("TPRICE"));
				hmap.put("type", rset.getString("TYPE"));

				list.add(hmap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int searchCoinRecordListCount(Connection con, String condition, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;
		String sql = prop.getProperty("searchCoinRecordListCount");

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, condition);
			pstmt.setString(2, userId);
			rset = pstmt.executeQuery();

			while(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}

	public ArrayList<HashMap<String, Object>> searchCoinRecord(Connection con, PageInfo pi, String condition,
			String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchCoinRecord");
		ArrayList<HashMap<String,Object>> list = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, condition);
			pstmt.setString(2, userId);
			pstmt.setInt(3, pi.getStartPage());
			pstmt.setInt(4, pi.getEndpage());
			rset = pstmt.executeQuery();

			list = new ArrayList<HashMap<String,Object>>();
			while(rset.next()) {
				HashMap<String,Object> hmap = new HashMap<String,Object>();
				hmap.put("date", rset.getDate("TDATE"));
				hmap.put("userId", rset.getString("M_ID"));
				hmap.put("amount", rset.getInt("TPRICE"));
				hmap.put("type", rset.getString("TYPE"));

				list.add(hmap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	//게시판 상세보기 수정용
	public Board SelectCommunity(Connection con, int nbid) {

		Board community = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectCommunity");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, nbid);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				community = new Board();
				community.setTitle(rset.getString("TITLE"));
				community.setbContent(rset.getString("BCONTENT"));
				community.setNbid(nbid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}


		return community;
	}

	//회원 검색 기능
	public ArrayList<Member> selectmember(Connection con, String keyField, String keyword) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		ArrayList<Member> memberSelect = null;

		String query = prop.getProperty("selectMember");

		/*System.out.println(keyField);
		System.out.println(keyword);*/

		if(keyword != null) {
			query += " AND " + keyField + " LIKE '%" + keyword.trim() + "%' ";
			/*System.out.println("회원검색쿼리" + query);*/

		}

		try {
			pstmt=con.prepareStatement(query);
			rset = pstmt.executeQuery();

			memberSelect = new ArrayList<Member>();

			System.out.println(query);

			if(rset != null) {
				while(rset.next()) {
					Member list = new Member();

					System.out.println("while문");

					list.setUserId(rset.getString("M_ID"));			
					list.setUserName(rset.getString("M_NAME"));
					list.setGender(rset.getString("GENDER"));
					list.setPhone(rset.getString("PHONE"));
					list.setEmail(rset.getString("EMAIL"));

					memberSelect.add(list);
				}

			}else {
				System.out.println("rset null");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(rset);
		}

		return memberSelect;
	}
	public int getPointSettlementListCount(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("getPointSettlementListCount");
		int listCount = 0;

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			while(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return listCount;
	}

	public ArrayList<Settlement> getPointSettlementList(Connection con, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("getPointSettlementList");
		ArrayList<Settlement> list = null;


		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pi.getStartPage());
			pstmt.setInt(2, pi.getEndpage());
			rset = pstmt.executeQuery();
			list = new ArrayList<Settlement>();
			while(rset.next()) {
				Settlement s = new Settlement();
				s.setRid(rset.getInt("RID"));
				s.settDate(rset.getDate("TDATE"));
				s.setrDate(rset.getDate("RDATE"));
				s.setrPrice(rset.getInt("RPRICE"));
				s.setrFees(rset.getInt("RFEES"));
				s.setTid(rset.getInt("TID"));
				s.setaId(rset.getString("A_ID"));
				s.setmId(rset.getString("M_ID"));
				s.setStatus(rset.getString("STATUS"));
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int pSettlementOne(Connection con, int rid) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateRefundOne");
		int result = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	//거래내역조회
	public ArrayList<Transaction> paymentlist(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		ArrayList<Transaction> list = null;

		String query = prop.getProperty("paymentlist");
		
		try {		
			pstmt=con.prepareStatement(query);
			rset = pstmt.executeQuery();
			list = new ArrayList<Transaction>();

			while(rset.next()) {

				Transaction paylist = new Transaction();
		
				paylist.settDate(rset.getDate("TDATE"));
				paylist.settPrice(rset.getInt("TPRICE"));
				paylist.setType(rset.getString("TYPE"));
				paylist.setUnit(rset.getString("UNIT"));
				paylist.setUserId(rset.getString("M_ID"));

				list.add(paylist);
				System.out.println("관리자 dao : " + list );
    	}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
	  }
		return list;
	}
	//공지사항수정
	public int updateNotice(Connection con, Board community) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("updateCommunity");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, community.getTitle());
			pstmt.setString(2, community.getbContent());
			pstmt.setInt(3, community.getNbid());
			
			result = pstmt.executeUpdate();
			
			System.out.println(result);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		
		
		return result;
	}

	//거래내역 필터 - 사용
		public ArrayList<Transaction> paymentSelect(Connection con) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;

			ArrayList<Transaction> list = null;

			String query = prop.getProperty("selectpaytype");

		
			try {
				pstmt=con.prepareStatement(query);
				rset = pstmt.executeQuery();

				list = new ArrayList<Transaction>();

				if(rset != null) {
					while(rset.next()) {
						Transaction paylist = new Transaction();

						paylist.settDate(rset.getDate("TDATE"));
						paylist.settPrice(rset.getInt("TPRICE"));
						paylist.setType(rset.getString("TYPE"));
						paylist.setUnit(rset.getString("UNIT"));
						paylist.setUserId(rset.getString("M_ID"));

						list.add(paylist);
						
						System.out.println(list);
					}

				}else {
					System.out.println("rset null");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				close(pstmt);
				close(rset);
			}

			return list;
		}

		//sms 내역조회
		public ArrayList<SMS> smslist(Connection con) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;

			ArrayList<SMS> smslist = null;

			String query = prop.getProperty("smslist");
			try {		
				pstmt=con.prepareStatement(query);
				rset = pstmt.executeQuery();
				smslist = new ArrayList<SMS>();

				while(rset.next()) {

					SMS slist = new SMS();
					

					slist.setSms_id(rset.getInt("SMS_ID"));
					slist.setDate(rset.getDate("SMS_DATE"));
					slist.setContent(rset.getString("SMS_CONTENT"));
					slist.setAid(rset.getString("A_ID"));
					slist.setMid(rset.getString("M_ID"));
					slist.setPhone(rset.getString("PHONE"));

					smslist.add(slist);
					/*System.out.println("관리자 dao : " + mlist );*/
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}


			return smslist;
		}

		//sms 내역 추가
		public int insertSmslist(Connection con, SMS smslist) {
			PreparedStatement pstmt = null;
			int result = 0;

			String query = prop.getProperty("insertsmslist");

			try {
				pstmt = con.prepareStatement(query);
			
				
				pstmt.setString(1, smslist.getContent());
				pstmt.setString(2, smslist.getPhone());
				
				result = pstmt.executeUpdate();

				System.out.println(result);
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}


			return result;
		}

		//거래내역조회 - 환불
		public ArrayList<Transaction> refundtSelect(Connection con) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;

			ArrayList<Transaction> list = null;

			String query = prop.getProperty("refundtype");

		
			try {
				pstmt=con.prepareStatement(query);
				rset = pstmt.executeQuery();

				list = new ArrayList<Transaction>();

				if(rset != null) {
					while(rset.next()) {
						Transaction paylist = new Transaction();

						paylist.settDate(rset.getDate("TDATE"));
						paylist.settPrice(rset.getInt("TPRICE"));
						paylist.setType(rset.getString("TYPE"));
						paylist.setUnit(rset.getString("UNIT"));
						paylist.setUserId(rset.getString("M_ID"));

						list.add(paylist);
						
						System.out.println(list);
					}

				}else {
					System.out.println("rset null");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				close(pstmt);
				close(rset);
			}

			return list;
		}

		//거래내역조회 - 충전
		public ArrayList<Transaction> chargetSelect(Connection con) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;

			ArrayList<Transaction> list = null;

			String query = prop.getProperty("chargetype");

		
			try {
				pstmt=con.prepareStatement(query);
				rset = pstmt.executeQuery();

				list = new ArrayList<Transaction>();

				if(rset != null) {
					while(rset.next()) {
						Transaction paylist = new Transaction();

						paylist.settDate(rset.getDate("TDATE"));
						paylist.settPrice(rset.getInt("TPRICE"));
						paylist.setType(rset.getString("TYPE"));
						paylist.setUnit(rset.getString("UNIT"));
						paylist.setUserId(rset.getString("M_ID"));

						list.add(paylist);
						
						System.out.println(list);
					}

				}else {
					System.out.println("rset null");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				close(pstmt);
				close(rset);
			}

			return list;
		}

		//FAQ list
		public ArrayList<Board> FAQlist(Connection con) {
			ArrayList<Board> list = null;
			Statement stmt = null;
			ResultSet rset = null;

			String query = prop.getProperty("FAQlist"); 

			try {
				stmt = con.createStatement();

				rset = stmt.executeQuery(query);
				/*System.out.println(query);*/
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

					/*System.out.println(list);*/
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(stmt);
			}


			return list;
		}

		//FAQ상세보기
		public Board FAQselectOne(Connection con, int num) {
			Board FAQ = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;

			String query = prop.getProperty("FAQselectOne");

			try {
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, num);

				rset= pstmt.executeQuery();

				if(rset.next()) {
					FAQ = new Board();
					FAQ.setFbid(rset.getInt("FBID"));
					FAQ.setTitle(rset.getString("TITLE"));
					FAQ.setbContent(rset.getString("BCONTENT"));
					FAQ.setWriter(rset.getString("M_ID"));
					FAQ.setbCount(rset.getInt("BCOUNT"));
					FAQ.setbDate(rset.getDate("BDATE"));
					FAQ.setfCategory(rset.getString("F_CATEGORY"));

					System.out.println(FAQ);

				}
        } catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
      return FAQ;
		}
=======
		public int getPointSettleSearchCount(Connection con, String condition, String keyword) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String sql = prop.getProperty("getPointSettleSearchCount");
			int listCount = 0;
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, condition);
				pstmt.setString(2, keyword);
				rset = pstmt.executeQuery();
				while(rset.next()) {
					listCount = rset.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			return listCount;
		}
			

		public int FAQCount(Connection con, int fbid) {
			int result = 0;
			PreparedStatement pstmt = null;

			String query = prop.getProperty("FAQCount");


			try {
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, fbid);
				pstmt.setInt(2, fbid);
				result = pstmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}

			return result;
		}

		public int updateFAQ(Connection con, Board FAQ) {
			int result = 0;
			PreparedStatement pstmt = null;
			
			String query = prop.getProperty("updateFAQ");
			
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, FAQ.getTitle());
				pstmt.setString(2, FAQ.getbContent());
				pstmt.setInt(3, FAQ.getFbid());
				
				result = pstmt.executeUpdate();
				
				System.out.println(result);
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
			
			
			
			return result;
		}

		public ArrayList<Settlement> getPointSettleSearchList(Connection con, PageInfo pi, String condition,
				String keyword) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String sql = prop.getProperty("getPointSettleSearchList");
			ArrayList<Settlement> list = null;
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, condition);
				pstmt.setString(2, keyword);
				pstmt.setInt(3, pi.getStartPage());
				pstmt.setInt(4, pi.getEndpage());
				rset = pstmt.executeQuery();
				
				list = new ArrayList<Settlement>();
				while(rset.next()) {
					Settlement s = new Settlement();
					s.setRid(rset.getInt("RID"));
					s.settDate(rset.getDate("TDATE"));
					s.setrDate(rset.getDate("RDATE"));
					s.setrPrice(rset.getInt("RPRICE"));
					s.setrFees(rset.getInt("RFEES"));
					s.setTid(rset.getInt("TID"));
					s.setaId(rset.getString("A_ID"));
					s.setmId(rset.getString("M_ID"));
					s.setStatus(rset.getString("STATUS"));
					list.add(s);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			return list;
		}

}
