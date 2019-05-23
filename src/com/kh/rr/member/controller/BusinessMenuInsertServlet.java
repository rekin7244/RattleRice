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

import com.kh.rr.member.model.service.BusinessMenuInfo;
import com.kh.rr.member.model.vo.Member;
import com.kh.rr.member.model.vo.StoreInfo;
import com.kh.rr.member.model.vo.StoreMenuInfo;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/menuInfoInsert.b")
public class BusinessMenuInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BusinessMenuInsertServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("메뉴인서트 서블릿");
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		System.out.println("ctn : " + request.getParameter("lastCtn"));
		
		//int lastCtn = Integer.parseInt(request.getParameter("lastCtn"));
		
		//System.out.println("lastCtn : " + lastCtn);
		
		String value = request.getParameter("menuArr");
		System.out.println("value : " + value);
		
		String[] oneslice = value.split(",");
		System.out.println("oneslice.length : " + oneslice.length);
		for(int i = 0; i < oneslice.length; i++) {
			String[] menuInfo = oneslice[i].split(" ");
		}
		//System.out.println("menuInfo : " + menuInfo[0]);
		
		
		
		/*String menu = request.getParameter("menu");
		System.out.println(menu);
		String price = request.getParameter("menuPrice");
		System.out.println(price);
		String[] origin = request.getParameterValues("origin");
		System.out.println("오리진" + origin);*/
		
		ArrayList<HashMap<String, Object>> menuList = new ArrayList<HashMap<String, Object>>();
		/*for(int i = 0; i < lastCtn ; i++) {
			HashMap<String, Object> hmap = new HashMap<String, Object>();
			//hmap.put("menu", menu[i]);
			//hmap.put("price", price[i]);
			//hmap.put("origin", origin[i]);
			
			menuList.add(hmap);
			
		}*/
			//System.out.println("menuList : " + menu);
 	   
		int result = new BusinessMenuInfo().menuInsert(loginUser, menuList);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
