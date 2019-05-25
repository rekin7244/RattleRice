package com.kh.rr.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.rr.admin.model.service.AdminService;
import com.kh.rr.admin.model.vo.SMS;


@WebServlet("/smslist.ad")
public class SmslistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SmslistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ArrayList<SMS> smslist = new AdminService().smslist();
		
		System.out.println("smslist 서블릿 ");
		
		String page = "";
		if(smslist != null) {
			page = "views/admin/smslist.jsp";
			request.setAttribute("smslist", smslist);
		}else {
			System.out.println("sms내역 조회 실패");
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
