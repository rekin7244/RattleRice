package com.kh.rr.transaction.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.kh.rr.member.model.vo.Member;
import com.kh.rr.transaction.model.service.TransactionService;
import com.kh.rr.transaction.model.vo.Transaction;

@WebServlet("/selectbell.tr")
public class SelectBellTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectBellTransactionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		System.out.println(loginUser);
		
		ArrayList<Transaction> list = new TransactionService().selectBellTransaction(loginUser);
		
		if(list != null) {
			System.out.println(list);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			new Gson().toJson(list, response.getWriter());
			
		}else {
			request.getRequestDispatcher("views/common/errorPage.jsp")
				.forward(request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
