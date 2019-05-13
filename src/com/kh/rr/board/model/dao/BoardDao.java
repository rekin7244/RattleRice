package com.kh.rr.board.model.dao;

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
import com.kh.rr.common.model.vo.PageInfo;

import static com.kh.rr.common.JDBCTemplate.*;

public class BoardDao {
	private Properties prop = new Properties();
	
	public BoardDao() {
		String fileName = BoardDao.class
							.getResource("/sql/board/board-query.properties")
							.getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getFAQListCount(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int listCount = 0;
		String sql = prop.getProperty("getFAQListCount");
		
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

	public ArrayList<Board> selectFAQList(Connection con, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = null;
		String sql = prop.getProperty("selectFAQList");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pi.getStartPage());
			pstmt.setInt(2, pi.getEndpage());
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Board>();
			while(rset.next()) {
				Board b = new Board();
				b.setBid(rset.getInt("BID"));
				b.setFbid(rset.getInt("FBID"));
				b.setWriter(rset.getString("M_NAME"));
				b.setType(rset.getInt("TYPE"));
				b.setbContent(rset.getString("BCONTENT"));
				b.setbDate(rset.getDate("BDATE"));
				b.setbCount(rset.getInt("BCOUNT"));
				list.add(b);
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
