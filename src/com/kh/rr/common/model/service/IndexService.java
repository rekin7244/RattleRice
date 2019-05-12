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
	
}
