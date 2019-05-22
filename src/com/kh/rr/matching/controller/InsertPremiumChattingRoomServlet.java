package com.kh.rr.matching.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.rr.matching.model.service.ChattingRoomService;
import com.kh.rr.matching.model.vo.ChattingRoom;
import com.kh.rr.member.model.vo.Member;

@WebServlet("/insert.pcr")
public class InsertPremiumChattingRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertPremiumChattingRoomServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		//묶여서 가져온 값들을 쪼개서 값 생성
		String allVal = request.getParameter("allVal");
		String valArr[] = allVal.split(",");
		
		String location = valArr[0];
		String brand = valArr[1];
		Date pDate = java.sql.Date.valueOf(valArr[2]);
		String pTime = valArr[3];
		int mPerson = Integer.parseInt(valArr[4]);
		String rTitle = valArr[5];
		int cNum = Integer.parseInt(valArr[6]);
		
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
		reqCr.setBrand(brand);
		reqCr.setrKind("pre");
		//성비는 남자성비/여자성비 형태로 삽입한다.
		reqCr.setsRatio(male + " / " + female);
		reqCr.setJob(job);
		reqCr.setAge(age);
		
		int result = new ChattingRoomService().insertChattingRoom(reqCr);
		int currval = new ChattingRoomService().getCurrval(reqCr);
		int result2 = new ChattingRoomService().insertMasterRoomRecord(loginUser, currval);
		if(result > 0 && result2 > 0) {
			request.getSession().setAttribute("rno", currval);
			response.sendRedirect(request.getContextPath()+"/selectOne.cr?rno="+currval);
		}else {
			request.setAttribute("msg", "채팅방 생성 실패!");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
