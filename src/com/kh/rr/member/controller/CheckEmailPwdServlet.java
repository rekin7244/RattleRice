package com.kh.rr.member.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.rr.member.model.service.UserInfoService;

@WebServlet("/checkEmailPwd.me")
public class CheckEmailPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckEmailPwdServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		String userId = request.getParameter("userId");
    	String email = request.getParameter("email");
    	String newPwd = request.getParameter("userPwd");
    	
    	int result = 0;
    	int result2=0;
    	
    	result = new UserInfoService().selectCheckEmailPwd(userName, userId, email);
    	
    	if(result > 0 ) {
    		System.out.println("서블릿 result1 :"+result);
    		result2 = new UserInfoService().updateCheckEmailPwd(userId,newPwd);
    		
    		if(result2 > 0) {
    			System.out.println("서블릿 result2 :"+result2);
    			response.getWriter().print(result2);
    		}else {
    			System.out.println("서블릿 result2 :"+result2);
    			response.getWriter().print(result2);
    		}
    	}else {
    		System.out.println("서블릿 result1 :"+result);
    		response.getWriter().print(result);
    	}
    	
    	
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
