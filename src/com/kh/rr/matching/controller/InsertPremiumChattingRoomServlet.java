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

@WebServlet("/insert.pcr")
public class InsertPremiumChattingRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertPremiumChattingRoomServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//묶여서 가져온 값들을 쪼개서 값 생성
		String allVal = request.getParameter("allVal");
		String valArr[] = allVal.split(",");
		
		String location = valArr[0];
		Date pDate = Date.valueOf(valArr[1]);
		String pTime = valArr[2];
		int mPerson = Integer.parseInt(valArr[3]);
		String rTitle = valArr[4];
		int cNum = Integer.parseInt(valArr[5]);
		
		//카테고리 처리
		String category = ""; 
		switch(cNum) { 
			case 10: category = "한식"; break; 
			case 20: category = "중식"; break; 
			case 30: category = "일식"; break; 
			case 40: category = "양식"; break; 
		}
		
		int male = Integer.parseInt(request.getParameter("male"));
		int female = Integer.parseInt(request.getParameter("female"));
		int age = Integer.parseInt(request.getParameter("age"));
		String job = request.getParameter("job");
		ChattingRoom reqCr = new ChattingRoom();
		
		reqCr.setrTitle(rTitle);
		reqCr.setpDate(pDate);
		reqCr.setCategory(category);
		reqCr.setpTime(pTime);
		reqCr.setmPerson(mPerson);
		reqCr.setLocation(location);
		reqCr.setrKind("프리미엄");
		//성비는 남자성비/여자성비 형태로 삽입한다.
		reqCr.setsRatio(male + " / " + female);
		reqCr.setJob(job);
		reqCr.setAge(age);
		
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
