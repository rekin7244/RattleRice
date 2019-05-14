package com.kh.rr.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.security.auth.login.LoginException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.rr.member.model.service.MemberService;
import com.kh.rr.member.model.vo.Member;

@WebServlet("/loginMember.me")
public class LoginMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginMemberServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		
		/*System.out.println(userId);
		System.out.println(password);*/
		Member loginUser = new MemberService().loginCheck(userId, userPwd);

		String page ="";


		if(loginUser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			
			if(loginUser.getUserId().equals("admin")) {
				page = request.getContextPath()+"/memberlist.ad";
				/*page = request.getContextPath() + "/views/admin/adminForm.jsp";	*/
			}else if(loginUser.getMemberType().equals("2")){
				//page=request.getContextPath()+"/views/business/reservationForm.jsp";
				//서블릿을 부름
				ArrayList<HashMap<String, Object>> list = new MemberService().logincheckBusiness(userId);
				
				if(list != null) {
					page= "/views/business/businessFormUpdate.jsp";
					request.setAttribute("loginUser", loginUser);
					request.setAttribute("list", list);
				}else {
					page = "views/common/errorPage.jsp";
				}
				
			}else {
				page = "index.jsp";
			}
//			response.sendRedirect(page);
			request.getRequestDispatcher(page).forward(request, response);
		}else{

			page="views/common/errorPage.jsp";
			request.setAttribute("msg", "로그인에러!");
			try {
				throw new LoginException("로그인에러!");
			} catch (LoginException e) {
				RequestDispatcher view = 
						request.getRequestDispatcher(page);
				view.forward(request, response);
			}


		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
