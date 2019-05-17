package com.kh.rr.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.rr.member.model.service.AttachmentService;
import com.kh.rr.member.model.service.MemberService;
import com.kh.rr.member.model.service.UserInfoService;
import com.kh.rr.member.model.vo.Attachment;
import com.kh.rr.member.model.vo.Member;
import com.kh.rr.member.model.vo.UserInfo;

@WebServlet("/pointCharge")
public class PointChargeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PointChargeServlet() {
		super(); 

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String amount = request.getParameter("amount");
		String userId = request.getParameter("userId");

		int result = new MemberService().pointCharge(amount, userId);

		if (result > 0 ) {
			System.out.println("포인트 충전 성공");
		} else {System.out.println("포인트 충전 실패");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
