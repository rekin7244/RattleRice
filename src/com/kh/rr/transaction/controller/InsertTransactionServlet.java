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
import com.kh.rr.member.model.service.UserInfoService;
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
		
		String pointString  = request.getParameter("point");
		String bellString = request.getParameter("bell");
		
		
		//포인트 환불 내역 삽입 일 경우
		if(pointString != null) {
			System.out.println("포인트 환불 신청입니다!");
			
			int point = Integer.parseInt(pointString);
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
		//벨 충전 내역 삽입일 경우
		}else {
			System.out.println("벨 충전 입니다!");
			int bell = Integer.parseInt(bellString);
			System.out.println(bell);
			//transaction 테이블에 컬럼 추가 - 벨 충전 
			int result = new TransactionService().insertBellTransaction(bell, loginUser);
			//유저의 보유 포인트는 차감시키고, 벨은 증가시킴
			int result2 = new UserInfoService().chargeBell(bell, loginUser);
			//transaction 테이블에 컬럼추가 - 포인트 사용
			int result3 = new TransactionService().payPoint(bell, loginUser);
			
			if(result > 0 && result2 > 0 && result3 > 0) {
				System.out.println("벨 트랜잭션 삽입 성공!");
			}else {
				request.getRequestDispatcher("views/common/errorPage.jsp")
				.forward(request, response);
			}
			
			
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
