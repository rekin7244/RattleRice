package com.kh.rr.matching.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.rr.matching.model.service.ChattingRoomService;
import com.kh.rr.matching.model.vo.ChattingRoom;


@WebServlet("/search.cr")
public class SearchChattingRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchChattingRoomServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String values = request.getParameter("searchHidden");
		String gender = request.getParameter("optradio");
		String age = request.getParameter("searchAge");
		String job = request.getParameter("jobName");
		
		String [] valArr = values.split(",");
		
		String location = valArr[0];
		
		String date = null;
		if(!valArr[1].isEmpty()) {
			 date = valArr[1];
		}
		
		String time = valArr[2];
		String member = valArr[3];
		String category = valArr[4];
		
		HashMap<String, Object> searchMap = new HashMap<String, Object>();
		searchMap.put("location", location);
		searchMap.put("date", date);
		searchMap.put("time", time);
		searchMap.put("member", member);
		searchMap.put("category", category);
		searchMap.put("gender", gender);
		searchMap.put("age", age);
		searchMap.put("job", job);
		ArrayList<ChattingRoom> list = new ChattingRoomService().searchChattingRoom(searchMap);


		String page = "";
		
		if(list != null) {
			page = "views/matching/main.jsp";
			request.setAttribute("list", list);
		}else {
			page="views/common/errorPage.jsp";
			request.setAttribute("msg", "채팅방 검색 실패!");
		}
		request.getRequestDispatcher(page).forward(request, response);
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
