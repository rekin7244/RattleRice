package com.kh.rr.member.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.rr.common.MyFileRenamePolicy;
import com.kh.rr.member.model.service.AttachmentService;
import com.kh.rr.member.model.service.UserInfoService;
import com.kh.rr.member.model.vo.Attachment;
import com.kh.rr.member.model.vo.Member;
import com.kh.rr.member.model.vo.UserInfo;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/updateUser")
public class UpdateUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateUserInfoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");

		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String job = request.getParameter("job");
		
		java.util.Date utilDate = new java.util.Date();
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		String birthdayStr = request.getParameter("birthday");
		try {
			utilDate = fm.parse(birthdayStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date birthday = new java.sql.Date(utilDate.getTime());
		


		UserInfo ui = new UserInfo();
		ui.setPhone(tel);
		ui.setBirthday(birthday);
		ui.setJob(job);
		ui.setUserId(loginUser.getUserId());
		int result = new UserInfoService().updateUserInfo(ui);

		if (result > 0) {
			response.sendRedirect(request.getContextPath() + "/selectPro");
		} else {
			request.setAttribute("msg", "프로필 수정 실패!");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
