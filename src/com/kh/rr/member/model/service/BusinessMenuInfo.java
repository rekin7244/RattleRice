package com.kh.rr.member.model.service;

import static com.kh.rr.common.JDBCTemplate.commit;
import static com.kh.rr.common.JDBCTemplate.getConnection;
import static com.kh.rr.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.rr.member.model.dao.BusinessDao;
import com.kh.rr.member.model.vo.Member;
import com.kh.rr.member.model.vo.StoreMenuInfo;

public class BusinessMenuInfo {

	public int insertMenuInfo(StoreMenuInfo storeMenuInfo, Member member) {
		Connection con = getConnection();
		
		int result = new BusinessDao().insertStoreInfo(con, storeMenuInfo, member);
		
		if(result > 0 ) {
			commit(con);
		}else {
			rollback(con);
		}
		
		return result;
	}

	public int menuUpdate(StoreMenuInfo menuInfo, Member loginUser) {
		Connection con = getConnection();
		
		int result = new BusinessDao().updateMenu(con, menuInfo, loginUser);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		return result;
	}

	public int menuInsert(Member loginUser, StoreMenuInfo menuInfo) {
		Connection con = getConnection();
		
		/*ArrayList<StoreMenuInfo> list = new ArrayList();
		
		list.add(loginUser);*/
		
		//System.out.println(list);
		
		int result = new BusinessDao().insertMenu(con, loginUser, menuInfo);
		
		if(result > 0 ) {
			commit(con);
		}else {
			rollback(con);
		}
		
		return result;
	}

}
