package com.kh.rr.matching.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.rr.matching.model.service.ChattingRoomService;

@WebServlet("/insert.res")
public class InsertReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertReservationServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String users = request.getParameter("users");
		String menus = request.getParameter("menus");
		String qtts = request.getParameter("qtts");
		int rno = Integer.parseInt(request.getParameter("rno"));
		
		String userArr[] = users.split(",");
		
		for(int i = 0; i < userArr.length; i++) {
			System.out.println("userArr : " + userArr[i]);
		}
		String menuArr [] = menus.split(",");
		for(int i = 0; i < menuArr.length; i++) {
			System.out.println("menuArr : " + menuArr[i]);
		}
		String qttArr [] = qtts.split(",");
		for(int i = 0; i < qttArr.length; i++) {
			System.out.println("qttArr : " + qttArr[i]);
		}
		
		int result = new ChattingRoomService().insertReservation(rno);
		
		if(result > 0) {
			System.out.println("예약 성공");
			int currval = new ChattingRoomService().getReservationCurrval(rno);
			
			if(currval > 0) {
				System.out.println("currval : " + currval);
				for(int i = 0; i < userArr.length; i ++) {
					HashMap<String, Object> hmap = new HashMap<String, Object>();
					hmap.put("rid",currval);
					hmap.put("user", userArr[i]);
					hmap.put("price", (Integer.parseInt(menuArr[i]) * Integer.parseInt(qttArr[i])));
					
					//reservation_member 테이블에 맴버 수 만큼 컬럼 추가
					int result2 = new ChattingRoomService().insertReservationMember(hmap);
					
					if(result2 > 0) {
						System.out.println("reservation_member 삽입 성공!");
					}else {
						System.out.println("reservation_member 삽입 실패!");
					}
				}
			}
			
		}else {
			System.out.println("예약 실패!");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
