package com.kh.rr.member.controller;

import java.io.IOException;

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


@WebServlet("/insertMember.me")
public class InsertMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public InsertMemberServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String memberType = request.getParameter("memberType");
		String gender = request.getParameter("gender");
		
		
		/*if(irr != null) {
			for (int i = 0; i < irr.length; i++) {
				if(i == 0) {
					interest += irr[i];
				}else {
					interest += ", " + irr[i];
				}
			}
		}*/
		
		//service 호출
		Member reqMember = new Member();
		reqMember.setUserId(userId);
		reqMember.setUserPwd(userPwd);
		reqMember.setUserName(userName);
		reqMember.setMemberType(memberType);
		
		UserInfo reqUserInfo = new UserInfo();
		reqUserInfo.setGender(gender);
		reqUserInfo.setUserId(userId);
		
		Attachment reqAttachment = new Attachment();
		reqAttachment.setUserId(userId);
		
		
		int result = new MemberService().insertMember(reqMember);
		int result2 = new UserInfoService().insertUserInfo(reqUserInfo);
		int result3 = new AttachmentService().insertAttachment(reqAttachment);
		
		String page = "";
		if(result > 0 && result2 > 0 && result3>0) {
			page = "index.jsp";
			response.sendRedirect(page);
		}else {
			page = "views/common/errorPage.jsp";	
			request.setAttribute("msg", "회원 가입 실패!");
			request.getRequestDispatcher(page).forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
