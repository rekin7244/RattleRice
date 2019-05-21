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

import com.kh.rr.member.model.vo.Member;
import com.kh.rr.member.model.vo.StoreMenuInfo;

@WebServlet("/menuInfo.b")
public class BusinessMenuInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BusinessMenuInfo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       HttpSession session = request.getSession();
       Member loginUser = (Member)session.getAttribute("loginUser");
       String menu = request.getParameter("menu");
       //String price = Integer.parseInt(request.getParameter("price"));
       String origin = request.getParameter("origin");
       
       StoreMenuInfo menuInfo = new StoreMenuInfo();
       
       menuInfo.setMenu(menu);
       //menuInfo.setPrice(price);
       menuInfo.setOrigin(origin);
       
       //ArrayList<HashMap<String, Object>> list = new BusinessMenuInfo().
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
