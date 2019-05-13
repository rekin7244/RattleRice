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


@WebServlet("/bisinesslist.ad")
public class BisinesslistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BisinesslistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Member> bisilist = new AdminService().bisinesslist();
			
		System.out.println("사업자 servlet : " + bisilist);
		
		String page = "";
		
		if(bisilist != null) {
			page = "views/admin/bisinessmanForm.jsp";
			request.setAttribute("bisilist", bisilist);
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
