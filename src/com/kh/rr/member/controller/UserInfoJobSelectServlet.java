package com.kh.rr.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/jobSelect")
public class UserInfoJobSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserInfoJobSelectServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String[] job = new String[20];
		
		job[0] = "무직";
		job[1] = "학생";
		job[2] = "IT";
		job[3] = "언론";
		job[4] = "공무원";
		job[5] = "군인";
		job[6] = "서비스업";
		job[7] = "교육";
		job[8] = "금융/증권/보험업";
		job[9] = "유통업";
		job[10] = "예술";
		job[11] = "의료";
		job[12] = "법률";
		job[13] = "건설업";
		job[14] = "제조업";
		job[15] = "부동산업";
		job[16] = "운송업";
		job[17] = "농/수/임/광산업";
		job[18] = "가사";
		job[19] = "기타";
		
		JSONArray result = new JSONArray();
		JSONObject jobSelect = null;
		
		for(String jarr : job) {
			jobSelect = new JSONObject();
			jobSelect.put("job", jarr) ;
			
			result.add(jobSelect);
		}
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(result.toJSONString());
		out.flush();
		out.close();
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
