package com.kh.rr.matching.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.rr.matching.model.service.ChattingRoomService;
import com.kh.rr.matching.model.vo.ChattingRoom;

@WebServlet("/insert.cr")
public class InsertChattingRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertChattingRoomServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rTitle = request.getParameter("rTitle");
		String date = request.getParameter("pTime");
		int mPerson = Integer.parseInt(request.getParameter("mPerson"));
		String location = request.getParameter("location");
		int cNum = Integer.parseInt(request.getParameter("category"));
		
		//카테고리 처리
		String category = "";
		switch(cNum) {
			case 10: category = "한식"; break;
			case 20: category = "중식"; break;
			case 30: category = "일식"; break;
			case 40: category = "양식"; break;
		}
		
		//date로 받은 값을 pDate와 pTime으로 나누는 처리
		String [] splitDate = date.split("T");
		Date pDate = Date.valueOf(splitDate[0]);
		String pTime = splitDate[1];
	
		ChattingRoom reqCr = new ChattingRoom();
		reqCr.setrTitle(rTitle);
		reqCr.setpDate(pDate);
		reqCr.setCategory(category);
		reqCr.setpTime(pTime);
		reqCr.setmPerson(mPerson);
		reqCr.setLocation(location);
		reqCr.setrKind("일반");
		
		int result = new ChattingRoomService().insertChattingRoom(reqCr);
		if(result > 0) {
			response.sendRedirect("views/matching/chatting.jsp");
		}else {
			request.setAttribute("msg", "채팅방 생성 실패!");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
