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
		String rTitle = valArr[3];
		
		int male = Integer.parseInt(request.getParameter("male"));
		int female = Integer.parseInt(request.getParameter("female"));
		int age = Integer.parseInt(request.getParameter("age"));
		String job = request.getParameter("job");
		ChattingRoom reqCr = new ChattingRoom();
		
		
		System.out.println(location);
		System.out.println(pDate);
		System.out.println(pTime);
		System.out.println(rTitle);
		System.out.println(male);
		System.out.println(female);
		System.out.println(age);
		System.out.println(job);
		
		reqCr.setrTitle(rTitle);
		reqCr.setpDate(pDate);
		reqCr.setLocation(location);
		reqCr.setpTime(pTime);
		reqCr.setsRatio(male + " / " + female);
		reqCr.setAge(age);
		reqCr.setJob(job);
		
		int result = new ChattingRoomService().insertChattingRoom(reqCr);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
