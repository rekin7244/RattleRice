package com.kh.rr.member.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.rr.member.model.service.UserInfoService;

@WebServlet("/checkEmail.me")
public class CheckEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckEmailServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		String userId = request.getParameter("userId");
    	String email = request.getParameter("email");
    	
    	HashMap<String, Object> hmap = new UserInfoService().selectCheckEmail(userName, userId, email);
    	
    	response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		new Gson().toJson(hmap, response.getWriter());
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
