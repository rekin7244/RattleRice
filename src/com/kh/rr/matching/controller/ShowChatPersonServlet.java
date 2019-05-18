package com.kh.rr.matching.controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.kh.rr.matching.model.service.ChattingRoomService;
import com.kh.rr.member.model.service.AttachmentService;
import com.kh.rr.member.model.vo.Member;

/**
 * Servlet implementation class ShowChatPersonServlet
 */
@WebServlet("/chatPerson.cr")
public class ShowChatPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowChatPersonServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		int rno = Integer.parseInt(request.getParameter("rno"));

		ArrayList<Member> list = new ChattingRoomService().getUserList(rno);

		System.out.println("list : "+ list);
		ArrayList<HashMap<String, Object>> userlist = new AttachmentService().selectAttachmentlList(list);

		System.out.println("userList : " + userlist);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(userlist, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
