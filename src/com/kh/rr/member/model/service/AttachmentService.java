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

	public int updateProfile(Attachment att, ArrayList<Attachment> fileList) {
		Connection con = getConnection();
		int result1 = 0, result2 = 0;
		
		result1 = new AttachmentDao().updateStatusAttachment(con,fileList);
		
		if(result1 > 0) {
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

	public ArrayList<HashMap<String, Object>> selectAttachmentlList() {
		Connection con = getConnection();

		ArrayList<HashMap<String, Object>> list = new AttachmentDao().selectThumbnailList(con);

		close(con);

		return list;
	}

}
