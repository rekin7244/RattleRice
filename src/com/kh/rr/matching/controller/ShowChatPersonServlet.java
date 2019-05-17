package com.kh.rr.matching.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.kh.rr.matching.model.service.ChattingRoomService;
import com.kh.rr.member.model.service.AttachmentService;
import com.kh.rr.member.model.vo.Member;

/**
 * Servlet implementation class ShowChatPersonServlet
 */
@WebServlet("/chatPerson.cr")
public class ShowChatPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowChatPersonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		int rno = Integer.parseInt(request.getParameter("rno"));
		
		ArrayList<Member> list = new ChattingRoomService().getUserList(rno);
		System.out.println("list : "+ list);
		ArrayList<HashMap<String, Object>> userlist = new AttachmentService().selectAttachmentlList(list);
		
		System.out.println("userList : " + userlist);
		
		JSONArray result = new JSONArray();
		JSONObject userInfo = null;
		
		for (int i = 0; i < userlist.size(); i++) {
			userInfo = new JSONObject();
			userInfo.put("userId", userlist.get(i).get("userId"));
			userInfo.put("nickName", userlist.get(i).get("nickName"));
			userInfo.put("msg", userlist.get(i).get("msg"));
			userInfo.put("changeName", userlist.get(i).get("changeName"));
			userInfo.put("job", userlist.get(i).get("job"));
			userInfo.put("birthday", userlist.get(i).get("birthday"));
			
			result.add(userInfo);
		}
		
		System.out.println("result : " + result);
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(result.toJSONString());
		
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
