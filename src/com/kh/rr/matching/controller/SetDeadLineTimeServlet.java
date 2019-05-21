package com.kh.rr.matching.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.kh.rr.matching.model.service.ChattingRoomService;
import com.kh.rr.matching.model.vo.ChattingRoom;

/**
 * Servlet implementation class SetDeadLineTimeServlet
 */
@WebServlet("/deadLine.cr")
public class SetDeadLineTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetDeadLineTimeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//현재시간
		long now = System.currentTimeMillis();
		
		Date d = new Date(now);
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String getTime = sdf.format(d);
		
		System.out.println("현재시간 : " + getTime);

		int dtRno = Integer.parseInt(request.getParameter("dtRno"));
		
		String dTime = request.getParameter("dTime").trim();
		
		ChattingRoom reqCr = new ChattingRoom();
		reqCr.setdTime(dTime);
		
		if(dTime == "25") {
				int result2 = new ChattingRoomService().resetChattingRoom(dtRno, reqCr);
				
				if(result2 > 0) {
					System.out.println("리셋한 마감시간 : " + reqCr.getdTime());
				}
		}else {			
			int result = new ChattingRoomService().updateChattingRoom(dtRno, reqCr);
			
			
			if(result > 0) {
				System.out.println("설정한 마감시간 : " + reqCr.getdTime());
			}
			
			/*
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			new Gson().toJson(reqCr.getdTime(), response.getWriter());*/			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
