package com.kh.rr.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.rr.admin.model.service.AdminService;
import com.kh.rr.member.model.vo.Member;

@WebServlet("/memberSelect.ad")
public class MemberSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public MemberSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String keyField = request.getParameter("keyField");
		String keyword = request.getParameter("keyword");
		
		ArrayList<Member> memberSelect = new AdminService().memberSelect(keyField, keyword);
		
		System.out.println("memberSelect" + memberSelect);
		
		request.setAttribute("memberSelect", memberSelect);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(memberSelect, response.getWriter());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
