package com.kh.rr.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.rr.member.model.service.AttachmentService;
import com.kh.rr.member.model.service.BusinessMenuInfo;
import com.kh.rr.member.model.service.BusinessStoreInfo;
import com.kh.rr.member.model.service.MemberService;
import com.kh.rr.member.model.vo.Attachment;
import com.kh.rr.member.model.vo.Member;
import com.kh.rr.member.model.vo.StoreInfo;
import com.kh.rr.member.model.vo.StoreMenuInfo;



@WebServlet("/insertBMember.me")
public class InsertBusinessMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public InsertBusinessMemberServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		System.out.println("userId : " + userId);
		String userName = "사업자";
		String memberType = request.getParameter("memberType");
		String gender = request.getParameter("gender");
		//String job = request.getParameter("curjob");
		//storeInfo
		String contact = "번호 입력";
		String location = "주소를 입력칸";
		String openhore = "00:00";
		String closehore = "00:00";
		String intro = "소개글";
		String brand = "매장명";
		//menuInfo
		String menu = "메뉴정보";
		String price = "0";
		String origin = "원산지";
		
		Member member = new Member();
		member.setUserId(userId);
		member.setUserPwd(userPwd);
		member.setUserName(userName);
		member.setMemberType(memberType);
		
		
		StoreInfo storeInfo = new StoreInfo();
		storeInfo.setCotact(contact);
		storeInfo.setLocation(location);
		storeInfo.setOpening_hore(openhore);
		storeInfo.setClose_hore(closehore);
		storeInfo.setIntro(intro);
		storeInfo.setBrand(brand);
		
		StoreMenuInfo storeMenuInfo = new StoreMenuInfo();
		storeMenuInfo.setMenu(menu);
		storeMenuInfo.setPrice(price);
		storeMenuInfo.setOrigin(origin);
		
		
		/*//service 호출
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
		reqUserInfo.setGender("B");*/
		
		
		Attachment reqAttachment = new Attachment();
		reqAttachment.setUserId(userId);
		
		int result1 = new MemberService().insertBusinessMember(member);
		//int result2 = new UserInfoService().insertUserInfo(reqUserInfo);
		int result2 = new BusinessStoreInfo().insertStroreInfo(storeInfo, member);
		int result3 = new AttachmentService().insertAttachmentBusiness(reqAttachment);
		int result4 = new BusinessMenuInfo().insertMenuInfo(storeMenuInfo, member);
		
		System.out.println("result 1 : " + result1);
		System.out.println("result 2 : " + result2);
		System.out.println("result 3 : " + result3);
		System.out.println("result 4 : " + result4);
		
		String page = "";
		if(result1 > 0 && result2 > 0 && result3 > 0 && result4 > 0) {
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
