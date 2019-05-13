package com.kh.rr.common.model.service;

import java.sql.Connection;

import com.kh.rr.common.model.dao.IndexDao;
import com.kh.rr.common.model.vo.IndexInfo;
import static com.kh.rr.common.JDBCTemplate.*;

public class IndexService {

	public IndexInfo loadInfo() {
		Connection con = getConnection();
		
		IndexInfo info = new IndexDao().selectIndexInfo(con);
		
		close(con);
		
		return info;
	}

	public int updateSiteInfo(IndexInfo info) {
		Connection con = getConnection();
		
		IndexInfo oldInfo = new IndexDao().selectIndexInfo(con);
		
		int result = new IndexDao().disableSiteInfo(con);
		
		if(result > 0) {
			result = new IndexDao().updateSiteInfo(con,info,oldInfo);
			commit(con);
		}else {
			rollback(con);
		}
		return result;
	}

	public int updateTerms(String terms) {
		Connection con = getConnection();
		
		IndexInfo oldInfo = new IndexDao().selectIndexInfo(con);
		
		int result = new IndexDao().disableSiteInfo(con);
		
		if(result > 0) {
			result = new IndexDao().updateTerms(con,terms,oldInfo);
			commit(con);
		}else {
			rollback(con);
		}
		return result;
	}
	
}
