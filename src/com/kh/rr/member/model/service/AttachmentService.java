package com.kh.rr.member.model.service;

import static com.kh.rr.common.JDBCTemplate.close;
import static com.kh.rr.common.JDBCTemplate.commit;
import static com.kh.rr.common.JDBCTemplate.getConnection;
import static com.kh.rr.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.rr.member.model.dao.AttachmentDao;
import com.kh.rr.member.model.vo.Attachment;

public class AttachmentService {

	public int insertAttachment(Attachment reqAttachment) {
		Connection con = getConnection();

		int result = new AttachmentDao().firstInsertAttachment(con, reqAttachment);

		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		return result;
	}

	public int updateProfile(Attachment att, ArrayList<Attachment> fileList) {
		Connection con = getConnection();
		int result1 = 0, result2 = 0;

		result1 = new AttachmentDao().updateStatusAttachment(con, fileList);

		if (result1 > 0) {
			result2 = new AttachmentDao().insertAttachment(con, fileList);

			if (result2 > 0) {
				commit(con);
			} else {
				rollback(con);
			}
		}

		close(con);

		return result2;
	}

	public ArrayList<HashMap<String, Object>> selectAttachmentlList(String userId) {
		Connection con = getConnection();
		
		ArrayList<HashMap<String, Object>> list = new AttachmentDao().selectAttachmentlList(con,userId);

		close(con);

		return list;
	}

	public int BusinessShopImg(Attachment att, ArrayList<Attachment> fileList) {
		Connection con = getConnection();
		int result = 0, result1 =0;
		
		result = new AttachmentDao().updateStatusAttachment(con, fileList);
		
		if(result >0) {
			result1 = new AttachmentDao().insertAttachment(con,fileList);
			
			if(result1 > 0) {
				commit(con);
			}else {
				rollback(con);
			}
		}
		close(con);
		
		return result1;
	}

	public int insertAttachmentBusiness(Attachment reqAttachment) {
		Connection con = getConnection();

		int result = new AttachmentDao().firstInsertAttachmentBusiness(con, reqAttachment);

		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		return result;
	}

}
