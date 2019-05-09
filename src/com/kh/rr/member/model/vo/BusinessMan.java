package com.kh.rr.member.model.vo;

import java.sql.Date;

public class BusinessMan implements java.io.Serializable{
	//buisness_info
	private String account; //계좌번호
	private String bankcode; //은행코드
	private String holder; //예금주
	//store
	private String cotact; //연락처
	private String location; //위치
	private String opening_hore; //영업시작 시간 영업 종료 시간도 있어 야 하나
	private String intro; //간단한 소개
	private String brand; //상호명
	private String sCode; //매장코드
	//transaction
	private String tid;//내역코드;
	private Date tDate;//거래일시
	private int tPrice;//거래금액
	private String type;//거래구분
	//store_update
	private Date uDate;//업데이트한 일시
	private String uId;//수정 이력 코드 이름이 s_id로 되어 있음 바꿔야 되나 불어 보기
	//menu
	private String menu; //메뉴명
	private int price; //메뉴가격
	private String origin; //원산지
	private String mId; //메뉴코드
	private String fId; //이미지 키
	//acount_change
	private int aId;
	private Date cDate;
	//private 
	
	
}































