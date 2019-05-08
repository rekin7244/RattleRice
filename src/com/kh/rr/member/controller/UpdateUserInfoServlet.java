package com.kh.rr.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.rr.member.model.service.UserInfoService;
import com.kh.rr.member.model.vo.UserInfo;

@WebServlet("/update.ui")
public class UpdateUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateUserInfoServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String msg = request.getParameter("msg");
    	String nickName = request.getParameter("nickName");
    	System.out.println(msg);
    	System.out.println(nickName);
    	
    	UserInfo reqUi = new UserInfo();
    	reqUi.setMsg(msg);
    	reqUi.setNickName(nickName);
    	int result = new UserInfoService().updateUserInfo(reqUi);
    	
    	String page = "";
    	if(result > 0) {
    		response.sendRedirect("/rr/selectInfo.ui");
    	}else {
    		page="views/common/errorPage.jsp";
    		request.setAttribute("msg", "회원정보 변경 실패!");
    		request.getRequestDispatcher(page).forward(request, response);
    	}
    	
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
