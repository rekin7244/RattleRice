package com.kh.rr.matching.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/selectOne.cr")
public class SelectOneChattingRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectOneChattingRoomServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rno = Integer.parseInt(request.getParameter("rno"));
		
		System.out.println(rno);
		
		
		request.getSession().setAttribute("rno", rno);
		request.getRequestDispatcher("views/matching/chatting.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
