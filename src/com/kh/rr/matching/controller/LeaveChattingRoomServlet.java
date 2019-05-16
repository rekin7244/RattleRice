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
		int rno = (int) session.getAttribute("rno");
		
		//방장인지 일반 사용자 인지 판별
		Member checkUser = new ChattingRoomService().checkUserType(loginUser, rno);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
