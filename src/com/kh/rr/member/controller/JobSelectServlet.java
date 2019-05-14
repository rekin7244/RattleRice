package com.kh.rr.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/jobSelect")
public class JobSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public JobSelectServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] jobList = new String[20];
		
		jobList[0] = "학생";
		jobList[1] = "IT";
		jobList[2] = "언론";
		jobList[3] = "공무원";
		jobList[4] = "군인";
		jobList[5] = "서비스업";
		jobList[6] = "교육";
		jobList[7] = "금육/증권/보험업";
		jobList[8] = "유통업";
		jobList[9] = "예술";
		jobList[10] = "의료";
		jobList[11] = "법률";
		jobList[12] = "건설업";
		jobList[13] = "제조업";
		jobList[14] = "부동산업";
		jobList[15] = "운송업";
		jobList[16] = "농/수/임/광산업";
		jobList[17] = "가사";
		jobList[18] = "기타";
		jobList[19] = "무직";
		
		

		JSONArray result = new JSONArray();
		JSONObject jobObj = null;
		
		for(String job : jobList) {
			jobObj = new JSONObject();
			jobObj.put("job", job);
			
			result.add(jobObj);
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
