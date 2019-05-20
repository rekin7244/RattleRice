package com.kh.rr.matching.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		int rno = Integer.parseInt(request.getParameter("rno"));
		String dTime = request.getParameter("dTime");
		
		ChattingRoom reqCr = new ChattingRoom();
		reqCr.setdTime(dTime);
		
		int result = new ChattingRoomService().updateChattingRoom(rno, reqCr);
		
		//현재시간
		long now = System.currentTimeMillis();
		
		Date d = new Date(now);
		
		if(result > 0) {
			
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
