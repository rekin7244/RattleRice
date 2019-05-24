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
import com.kh.rr.transaction.model.vo.Transaction;

/**
 * Servlet implementation class PaytypeSelectServlet
 */
@WebServlet("/paytypeSelect.ad")
public class PaytypeSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PaytypeSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("radio");
		
		System.out.println(type);
		
		ArrayList<Transaction> list = new AdminService().paymentSelect(); 
		
		
		request.setAttribute("list", list);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(list, response.getWriter());
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
