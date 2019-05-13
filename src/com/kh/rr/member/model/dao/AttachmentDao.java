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

	public ArrayList<HashMap<String, Object>> selectThumbnailList(Connection con) {
		Statement stmt = null;
		ArrayList<HashMap<String, Object>> list = null;
		HashMap<String, Object> hmap = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectAttachmentMap");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

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

				list.add(hmap);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(stmt);
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
}