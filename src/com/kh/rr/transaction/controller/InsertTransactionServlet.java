package com.kh.rr.transaction.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.rr.member.model.vo.Member;
import com.kh.rr.refund.model.service.RefundService;
import com.kh.rr.transaction.model.service.TransactionService;
import com.kh.rr.transaction.model.vo.Transaction;

@WebServlet("/insert.tr")
public class InsertTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertTransactionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		int point = Integer.parseInt(request.getParameter("point"));
		
		//transaction 테이블에 컬럼 추가
		int result = new TransactionService().insertTransaction(point, loginUser);
		//방금 추가한 transaction을 가져옴
		Transaction reqTr = new TransactionService().selectLatestTransaction();
		//refund 테이블에 컬럼 추가
		int result2 = new RefundService().insertRefund(reqTr);
		
		if(result > 0 && result2 > 0) {
			response.sendRedirect(request.getContextPath()+"/selectAll.tr");
		}else {
			request.getRequestDispatcher("views/common/errorPage.jsp")
				.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
