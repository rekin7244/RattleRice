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


@WebServlet("/bisinessSelect.ad")
public class BisinessSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BisinessSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String keyField = request.getParameter("keyField");
		String keyword = request.getParameter("keyword");
		
		System.out.println(keyField);
		System.out.println(keyword);
		
		ArrayList<Member> bisiSelect = new AdminService().bisinessSelect(keyField, keyword);
		
		System.out.println("서블릿실행");
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(bisiSelect, response.getWriter());
		
	/*	String page="";
		if(bisiSelect != null) {
			page="views/admin/bisinessmanForm.jsp";
			request.setAttribute("bisiSelect", bisiSelect);
		}
		
		request.getRequestDispatcher(page).forward(request, response);*/
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
