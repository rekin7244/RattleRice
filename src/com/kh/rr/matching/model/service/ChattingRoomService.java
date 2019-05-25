package com.kh.rr.matching.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.rr.matching.model.dao.ChattingRoomDao;
import com.kh.rr.matching.model.vo.ChattingRoom;
import com.kh.rr.member.model.vo.Member;

import static com.kh.rr.common.JDBCTemplate.*;
public class ChattingRoomService {

	public ArrayList<ChattingRoom> selectAll() {
		Connection con = getConnection();
		ArrayList<ChattingRoom> list = new ChattingRoomDao().selectAll(con);
			
		return list;
	}

	public int insertChattingRoom(ChattingRoom reqCr) {
		Connection con = getConnection();
		int result = 0;
		
		//프리미엄 조건인 성별선택이 null이 아니라면 프리미엄 생성으로
		if(reqCr.getsRatio() != null) {
			result = new ChattingRoomDao().insertPremiumChattingRoom(con,reqCr);
		//비어있으면 일반 생성으로
		}else {
			result = new ChattingRoomDao().insertChattingRoom(con, reqCr);
		}
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
			
		close(con);
		
		return result;
	}

	public int getCurrval(ChattingRoom reqCr) {
		Connection con = getConnection();
		int currval = new ChattingRoomDao().getCurrval(con, reqCr);
		
		close(con);
		
		return currval;
	}
	
	//채팅방 입장시 RoomRecord 테이블에 정보 삽입 하는 메소드
	public int insertRoomRecord(Member loginUser, int rno) {
		Connection con = getConnection();
		int result = new ChattingRoomDao().insertRoomRecord(con, loginUser, rno);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public int insertMasterRoomRecord(Member loginUser, int currval) {
		Connection con = getConnection();
		int result = new ChattingRoomDao().insertMasterRoomRecord(con, loginUser, currval);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}
	
	//사용자가 채팅방을 나갔을 때 일반사용자인지 방장인지 확인하는 메소드
	public Member checkUserType(Member loginUser, int rno) {
		Connection con = getConnection();
		Member checkUser = new ChattingRoomDao().checkUserType(con, loginUser, rno);
		
		close(con);
		
		return checkUser;
	}

	//방장이 채팅방을 나갔을 때 그 방을 없애는 메소드
	public int deleteChattingRoom(int rno) {
		Connection con = getConnection();
		int result = new ChattingRoomDao().deleteChattingRoom(con, rno);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	//방장이 채팅방을 나갔을 때 그 방과 관련된 룸 레코드를 전부 없애는 메소드
	public int deleteAllRoomRecord(int rno) {
		Connection con = getConnection();
		
		int result = new ChattingRoomDao().deleteAllRoomRecord(con, rno);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}
	
	
	//일반 사용자가 채팅방을 나갔을 때 사용자와 관련된 룸레코드 전부 없애는 메소드
	public int deleteRoomRecord(Member loginUser, int rno) {
		Connection con = getConnection();
		int result = new ChattingRoomDao().deleteRoomRecord(con, loginUser, rno);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	//채팅방에 있는 사용자 정보 불러오는 메소드
	public ArrayList<Member> getUserList(int rno) {
		Connection con = getConnection();
		
		ArrayList<Member> list = new ChattingRoomDao().getUserList(con, rno);
		
		close(con);
		
		return list;
	}

	//채팅방 조건검색 메소드
	public ArrayList<ChattingRoom> searchChattingRoom(HashMap<String, Object> searchMap) {
		Connection con = getConnection();
		
		ArrayList<ChattingRoom> reqList = new ChattingRoomDao().searchChattingRoom(con, searchMap);
		
		close(con);
		
		return reqList;
		
	}

	//방장으로 들어온건지 아닌지 판단해주는 메소드
	//룸레코드 DB에 기록이 있는지 체크한다
	public int checkMasterRecord(Member loginUser, int rno) {
		Connection con = getConnection();
		
		int result = new ChattingRoomDao().checkMasterRecord(con, loginUser, rno);

		close(con);
		
		return result;
	}

	//마감시간 설정하는 메소드
	public int updateChattingRoom(int dtRno, ChattingRoom reqCr) {
		Connection con = getConnection();
		
		int result = new ChattingRoomDao().updateChattingRoom(con, dtRno, reqCr);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		return result;
	}

	//사용자 강퇴하는 메소드
	public int kickUser(String userId, int rno) {
		Connection con = getConnection();
		
		int result = new ChattingRoomDao().kickUser(con, userId, rno);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	//마감시간이 되면 dtime을 리셋해주는 메소드
	public int resetChattingRoom(int dtRno, ChattingRoom reqCr) {
		Connection con = getConnection();
		
		int result = new ChattingRoomDao().resetChattingRoom(con, dtRno, reqCr);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		return result;
	}

	//사용자 입장 시 현재 인원 수 증가시켜주는 메소드
	public int updatePperson(int rno) {
		Connection con = getConnection();
		
		int result = new ChattingRoomDao().updatePperson(con, rno);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	//사용자 퇴장 시 현재 인원 수 1 감소 
	public int decreasePperson(int rno) {
		Connection con = getConnection();
		
		int result = new ChattingRoomDao().decreasePperson(con, rno);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

//	//방 번호를 받아와서 식당 메뉴정보, 상호명, 위치 가져오는 메소드
//	public ArrayList<ArrayList> selectStoreInfo(int rno) {
//		Connection con = getConnection();
//		ArrayList<ArrayList> resList = new ChattingRoomDao().selectStoreInfo(con, rno);
//		
//		close(con);
//		
//		return resList;
//	}

	
	//방 번호를 받아와서 식당 메뉴정보, 유저정보 가져오는 메소드
	public ArrayList<ArrayList> reservation(int rno) {
		Connection con = getConnection();
		
		ArrayList<ArrayList> resList = new ArrayList<ArrayList>();
		
		//유저정보 불러오기
		ArrayList userList = new ChattingRoomDao().resUserList(con, rno);
		
		//메뉴정보 불러오기
		ArrayList<HashMap<String, Object>> menuList = new ChattingRoomDao().resMenuList(con, rno);
		
		if(userList != null && menuList != null) {
			System.out.println(userList);
			System.out.println(menuList);
			resList.add(userList);
			
			System.out.println(resList);
			resList.add(menuList);
		}else {
			System.out.println("유저정보 조회 실패!");
		}
		
		
		return resList;
	}

	//예약 내역 추가하는 메소드
	public int insertReservation(int rno) {
		Connection con = getConnection();
		
		int result = new ChattingRoomDao().insertReservation(con, rno);
		
		if(result > 0) {
			commit(con);
		}else{
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	//reservation 테이블 시퀀스 번호 가져오는 메소드
	public int getReservationCurrval(int rno) {
		Connection con = getConnection();
		int currval = new ChattingRoomDao().getReservationCurrval(con, rno);
		
		close(con);
		
		return currval;
	}

	//reservation_member 테이블에 맴버 수 만큼 컬럼 추가
	public int insertReservationMember(HashMap<String, Object> hmap) {
		Connection con = getConnection();
		int result = new ChattingRoomDao().insertReservationMember(con, hmap);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}