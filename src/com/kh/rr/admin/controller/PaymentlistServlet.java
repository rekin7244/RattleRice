package com.kh.rr.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.rr.admin.model.service.AdminService;
import com.kh.rr.transaction.model.vo.Transaction;


@WebServlet("/paymentlist.ad")
public class PaymentlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public PaymentlistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ArrayList<Transaction> list = new AdminService().paymentlist();
		
		System.out.println("servlet");
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
