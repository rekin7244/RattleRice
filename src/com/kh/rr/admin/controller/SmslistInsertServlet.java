package com.kh.rr.admin.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.kh.rr.admin.model.service.AdminService;
import com.kh.rr.admin.model.vo.Coolsms;
import com.kh.rr.admin.model.vo.SMS;



@WebServlet("/smslistInsert.ad")
public class SmslistInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SmslistInsertServlet() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("sms servlet");
		
		String api_key = "NCSXE6TMZXOSNUXS";
		String api_secret = "0GLHGAT4DSF68BUBPLJ3GW9KNSOCYTWF";
		
		Coolsms coolsms = new Coolsms(api_key, api_secret);
		
		String to = request.getParameter("to");
		String text = request.getParameter("content");
		
		HashMap<String, String> set = new HashMap<String, String>();
		set.put("to", to); // 수신번호    
		set.put("from", "01071299363"); // 발신번호 
		set.put("text", text); // 문자내용
		set.put("type", "sms"); // 문자 타입
		//set.put("datetime", "201401151230"); // 예약전송시 날짜 설정	
		//set.put("mode", "test"); // test모드 수신번호를 반드시 01000000000 으로 테스트하세요. 예약필드 datetime는 무시됨. 결과값은 60. 잔액에서 실제 차감되며 다음날 새벽에 재충전됨
		
		System.out.println(to);
		
		System.out.println(text);
		
		
		JSONObject result = coolsms.send(set); // 보내기&전송결과받기
	/*	if ((Boolean) result.get("status") == true) {
			// 메시지 보내기 성공 및 전송결과 출력
			System.out.println("성공");            
			System.out.println(result.get("group_id")); // 그룹아이디
			System.out.println(result.get("result_code")); // 결과코드
			System.out.println(result.get("result_message"));  // 결과 메시지
			System.out.println(result.get("success_count")); // 성공갯수
			System.out.println(result.get("error_count"));  // 발송실패 메시지수
		} else {
			// 메시지 보내기 실패
			System.out.println("실패");
			System.out.println(result.get("code")); // REST API 에러코드
			System.out.println(result.get("message")); // 에러메시지
		}    */
		
		
		SMS smslist = new SMS();
		
		smslist.setPhone(to);
		smslist.setContent(text);
		
		
		int content = new AdminService().insertSmslist(smslist);
		
		String Page = "";
		if(content >0) {
			response.sendRedirect("/rr/smslist.ad");
		}else {
			
			System.out.println("추가 실패");
		}
	}    
	
		
	
	
	
		
		
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
