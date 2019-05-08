package com.kh.rr.matching.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.rr.matching.model.service.ChattingRoomService;
import com.kh.rr.matching.model.vo.ChattingRoom;

@WebServlet("/selectAll.cr")
public class SelectAllChattingRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectAllChattingRoomServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ChattingRoom> list = new ChattingRoomService().selectAll();
		
		String page = "";
		if(list != null) {
			page = "views/matching/main.jsp";
			request.setAttribute("list", list);
		}else {
			page="views/common/errorPage.jsp";
			request.setAttribute("msg", "채팅방 조회 실패!");
		}
		request.getRequestDispatcher(page).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
