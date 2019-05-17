package com.kh.rr.matching.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.rr.matching.model.service.ChattingRoomService;
import com.kh.rr.member.model.vo.Member;

@WebServlet("/leave.cr")
public class LeaveChattingRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LeaveChattingRoomServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//채팅방 나가기 버튼을 선택하면 세션에서 사용자 정보를 받아옴
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		System.out.println("서블릿에서 가져온 유저 세션 정보 : "+loginUser);
		//방번호도 받아옴
		int rno = (int) session.getAttribute("rno");
		
		//방장인지 일반 사용자 인지 판별
		Member checkUser = new ChattingRoomService().checkUserType(loginUser, rno);
		
		if(checkUser.getUserId() != null ) {
			System.out.println("방장인 경우 가져온 유저정보" + checkUser);
			//방장 이라면
			//해당 방을 지우고, 관련된 룸 레코드를 전부 지운다
			
			//1. rno 값을 넘겨서 해당 방 지우기
			int result = new ChattingRoomService().deleteChattingRoom(rno);
			
			//2. 방 삭제 성공 시 Room_Record 지우기
			if(result > 0) {
				int result2 = new ChattingRoomService().deleteAllRoomRecord(rno);
				
				//Room_Record 삭제 성공 시
				if(result2 > 0) {
					response.sendRedirect(request.getContextPath()+"/selectAll.cr");
				}else {
					request.getRequestDispatcher("views/common/errorPage.jsp")
						.forward(request, response);
				}
			}else {
					request.getRequestDispatcher("views/common/errorPage.jsp")
						.forward(request, response);
			}
			
		}else {
			System.out.println("방장이 아닌 경우");
			//방장 아니라면
			//이사람과 관련된 룸레코드만 지운다
			int result = new ChattingRoomService().deleteRoomRecord(loginUser, rno);
			
			if(result > 0) {
				System.out.println("방장 아닌 경우 룸레코드 삭제 성공");
				response.sendRedirect(request.getContextPath()+"/selectAll.cr");
			}else {
				request.getRequestDispatcher("views/common/errorPage.jsp")
				.forward(request, response);
			}
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
