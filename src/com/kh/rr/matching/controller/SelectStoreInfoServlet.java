package com.kh.rr.matching.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.rr.matching.model.service.ChattingRoomService;

@WebServlet("/selectInfo.st")
public class SelectStoreInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectStoreInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rno = Integer.parseInt(request.getParameter("dtRno"));
		
		//방 번호를 받아와서 식당 메뉴정보, 상호명, 위치 가져오는 메소드
//		ArrayList<ArrayList> resList = new ChattingRoomService().selectStoreInfo(rno);
		ArrayList<ArrayList> resList = new ChattingRoomService().reservation(rno);
		if(resList != null) {
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			new Gson().toJson(resList, response.getWriter());
		}else {
			System.out.println("정보 조회 실패!");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
