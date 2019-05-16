package com.kh.rr.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

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

@WebServlet("/insertBMember.me")
public class InsertBusinessMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public InsertBusinessMemberServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = "사업자";
		String memberType = request.getParameter("memberType");
		String gender = request.getParameter("gender");
		String job = request.getParameter("curjob");
		String phone = request.getParameter("phone");
		
		//service 호출
		Member reqMember = new Member();
		reqMember.setUserId(userId);
		reqMember.setUserPwd(userPwd);
		reqMember.setUserName(userName);
		reqMember.setMemberType(memberType);
		
		UserInfo reqUserInfo = new UserInfo();
		reqUserInfo.setUserId(userId);
		reqUserInfo.setJob(job);
		reqUserInfo.setGender(gender);
		reqUserInfo.setPhone(phone);
		reqUserInfo.setGender("B");
		
		Attachment reqAttachment = new Attachment();
		reqAttachment.setUserId(userId);
		
		int result = new MemberService().insertBusinessMember(reqMember);
		int result2 = new UserInfoService().insertUserInfo(reqUserInfo);
		int result3 = new AttachmentService().insertAttachmentBusiness(reqAttachment);
		
		String page = "";
		if(result > 0 && result2 > 0 && result3 > 0) {
			response.setContentType("text/html; charset=euc-kr"); //한글이 인코딩
			   PrintWriter out = response.getWriter(); //선언
			   
			   String str="";
			   str = "<script language='javascript'>";
			   str += "alert(\"회원가입 완료!\");";
			   str += "self.close();";   // 창닫기
			    str += "</script>";
			   out.print(str);
		}else {
			page = "views/common/errorPage.jsp";	
			request.setAttribute("msg", "회원 가입 실패!");
			request.getRequestDispatcher(page).forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
