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


@WebServlet("/bisinessSelect.ad")
public class BisinessSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BisinessSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String keyField = request.getParameter("keyField");
		String keyword = request.getParameter("keyword");
		
		System.out.println(keyField);
		System.out.println(keyword);
		
		ArrayList<Member> bisilist = new AdminService().bisinessSelect(keyField, keyword);
		
		/*System.out.println("서블릿실행");*/
		
		String page="";
		
		if(bisilist != null) {
			page="views/admin/bisinessmanForm.jsp";
			request.setAttribute("bisilist", bisilist);
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
