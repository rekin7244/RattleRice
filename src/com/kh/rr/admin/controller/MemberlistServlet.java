package com.kh.rr.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.rr.admin.model.service.AdminService;
import com.kh.rr.member.model.vo.Member;

@WebServlet("/memberlist.ad")
public class MemberlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public MemberlistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ArrayList<Member> list = new AdminService().memberlist();
		
		System.out.println("servlet : " + list);
		
		String page="";
		
		if(list != null) {
			page="views/admin/adminForm.jsp";
			request.setAttribute("list", list);
			
		}else {
			page="views/common/errorPage.jsp";
			request.setAttribute("msg", "실패");
		}
		
		request.getRequestDispatcher(page).forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
