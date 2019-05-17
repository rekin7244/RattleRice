package com.kh.rr.transaction.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.rr.transaction.model.service.TransactionService;

@WebServlet("/insert.tr")
public class InsertTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertTransactionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String point = request.getParameter("point");
		
		int result = new TransactionService().insertTransaction(point);
		
		if(result > 0) {
			response.sendRedirect("");
		}else {
			request.getRequestDispatcher("views/common/errorPage.jsp")
				.forward(request, response);
		}
		
		
		System.out.println(point);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
