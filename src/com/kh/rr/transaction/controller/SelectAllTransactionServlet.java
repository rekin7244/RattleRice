package com.kh.rr.transaction.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.rr.member.model.service.AttachmentService;
import com.kh.rr.member.model.vo.Member;
import com.kh.rr.transaction.model.service.TransactionService;
import com.kh.rr.transaction.model.vo.Transaction;

@WebServlet("/selectAll.tr")
public class SelectAllTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectAllTransactionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Transaction> list = new TransactionService().selectAllTransaction();
		
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		ArrayList<HashMap<String, Object>> list2 = new AttachmentService().selectAttachmentlList(loginUser.getUserId());
		System.out.println(list2);
		String page = "";
		if(list != null) {
			request.setAttribute("list", list);
			request.setAttribute("list2", list2);
			page = "views/matching/payment.jsp";
		}else {
			page = "views/common/errorPage.jsp";
		}
		request.getRequestDispatcher(page).forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
