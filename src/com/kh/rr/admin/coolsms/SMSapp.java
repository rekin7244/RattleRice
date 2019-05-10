package com.kh.rr.admin.coolsms;

import java.util.HashMap;

import org.json.simple.JSONObject;

public class SMSapp {

	public static void main(String[] args) {    
		/*
		 * 서버에서 받은 API_KEY, API_SECRET를 입력해주세요.
		 */
		String api_key = "NCSZ4MM65FVKSVIC";
		String api_secret = "Q4LYRVIP2JOYJDDDAIHB8M4EGTTMD6EF";
		Coolsms coolsms = new Coolsms(api_key, api_secret);

		/*
		 * Parameters
		 * 관련정보 : http://www.coolsms.co.kr/SDK_Java_API_Reference_ko#toc-0
		 */
		HashMap<String, String> set = new HashMap<String, String>();
		set.put("to", "01032324439"); // 수신번호    
		set.put("from", "01029933144"); // 발신번호 
		set.put("text", "노고에 감사드립니다. 헤헷"); // 문자내용
		set.put("type", "sms"); // 문자 타입
		//set.put("datetime", "201401151230"); // 예약전송시 날짜 설정	
		set.put("mode", "test"); // test모드 수신번호를 반드시 01000000000 으로 테스트하세요. 예약필드 datetime는 무시됨. 결과값은 60. 잔액에서 실제 차감되며 다음날 새벽에 재충전됨
		set.put("datetime", "201701151230"); // 예약전송시 날짜 설정	
		
		JSONObject result = coolsms.send(set); // 보내기&전송결과받기
		if ((Boolean) result.get("status") == true) {
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
		}        
	}    
}

