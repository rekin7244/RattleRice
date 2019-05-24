package com.kh.rr.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.rr.member.model.service.ReservationService;
import com.kh.rr.member.model.vo.Member;
import com.kh.rr.member.model.vo.Reservation;

@WebServlet("/reservation.b")
public class BusinessReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BusinessReservationServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		System.out.println("사업자 로그인 체크 : " + loginUser.getUserId());
		
		ArrayList<HashMap<String, Object>> list = new ReservationService().selectReservation(loginUser);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
