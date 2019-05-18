package com.kh.rr.member.model.dao;

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

import com.kh.rr.member.model.vo.Attachment;
import com.kh.rr.member.model.vo.Member;

public class AttachmentDao {

	public AttachmentDao() {
		String fileName = AttachmentDao.class.getResource("/sql/member/Attachment-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Properties prop = new Properties();

	public int insertAttachment(Connection con, ArrayList<Attachment> fileList) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertAttachment");

		try {
			for (int i = 0; i < fileList.size(); i++) {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, fileList.get(i).getFilePath());
				pstmt.setString(2, fileList.get(i).getOriginName());
				pstmt.setString(3, fileList.get(i).getChangeName());
				pstmt.setString(4, fileList.get(i).getType());
				pstmt.setString(5, fileList.get(i).getUserId());

				result = pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public ArrayList<HashMap<String, Object>> selectAttachmentlList(Connection con,String userId) {
		PreparedStatement pstmt = null;
		ArrayList<HashMap<String, Object>> list = null;
		HashMap<String, Object> hmap = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectAttachmentMap");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			

			list = new ArrayList<HashMap<String, Object>>();

			while (rset.next()) {
				hmap = new HashMap<String, Object>();

				hmap.put("userId", rset.getString("M_ID"));
				hmap.put("nickName", rset.getString("NICK_NAME"));
				hmap.put("msg", rset.getString("MESSAGE"));
				hmap.put("birthday", rset.getDate("BIRTHDAY"));
				hmap.put("job", rset.getString("JOB"));
				hmap.put("phone", rset.getInt("PHONE"));
				hmap.put("fid", rset.getInt("FID"));
				hmap.put("originName", rset.getString("ORIGIN_NAME"));
				hmap.put("changeName", rset.getString("CHANGE_NAME"));
				hmap.put("filePath", rset.getString("FILE_PATH"));
				hmap.put("uploadDate", rset.getDate("UPLOAD_DATE"));
				hmap.put("email", rset.getString("EMAIL"));
				hmap.put("point", rset.getInt("POINT"));
				hmap.put("bell", rset.getInt("BELL"));
				
				list.add(hmap);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return list;
	}

	public int updateStatusAttachment(Connection con, ArrayList<Attachment> fileList) {

		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateStatusAttachment");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, fileList.get(0).getUserId());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;

	}

	public int firstInsertAttachment(Connection con, Attachment reqAttachment) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("firstInsertAttachment");

		try {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, reqAttachment.getUserId());

				result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	
	
	
	

	public int firstInsertAttachmentBusiness(Connection con, Attachment reqAttachment) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("firstInsertAttachmentBusiness");

		try {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, reqAttachment.getUserId());

				result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	//체팅방에 있는 사용자 정보를 불러오는 메소드
	public ArrayList<HashMap<String, Object>> selectAttachmentlList(Connection con, ArrayList<Member> list) {
		PreparedStatement pstmt = null;
		ArrayList<HashMap<String, Object>> userList = null;
		HashMap<String, Object> hmap = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectAttachmentMap");
		
		try {
			userList = new ArrayList<HashMap<String, Object>>();
			
			for(int i = 0; i < list.size(); i++) {
				
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, list.get(i).getUserId());
				
				rset = pstmt.executeQuery();
				
				
				
				while (rset.next()) {
					hmap = new HashMap<String, Object>();
					
					hmap.put("userId", rset.getString("M_ID"));
					hmap.put("nickName", rset.getString("NICK_NAME"));
					hmap.put("msg", rset.getString("MESSAGE"));
					hmap.put("birthday", rset.getDate("BIRTHDAY"));
					hmap.put("job", rset.getString("JOB"));
					hmap.put("phone", rset.getInt("PHONE"));
					hmap.put("fid", rset.getInt("FID"));
					hmap.put("originName", rset.getString("ORIGIN_NAME"));
					hmap.put("changeName", rset.getString("CHANGE_NAME"));
					hmap.put("filePath", rset.getString("FILE_PATH"));
					hmap.put("uploadDate", rset.getDate("UPLOAD_DATE"));
					hmap.put("email", rset.getString("EMAIL"));
					System.out.println(i+"번쨰 - "+hmap);
					userList.add(hmap);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return userList;
	}
}
