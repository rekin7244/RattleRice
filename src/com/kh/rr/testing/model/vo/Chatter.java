package com.kh.rr.testing.model.vo;

import java.net.Socket;

import com.kh.rr.testing.controller.ChattingRoom;

public class Chatter {
	private String userName;
	private ChattingRoom room;
	private Socket socket;	//소켓 object
	
	//cons
	public Chatter() {}
	/**
     * 유저 생성
     * @param userName 유저이름
     */
	public Chatter(String userName) {
		super();
		this.userName = userName;
	}
	/*
     * 소켓 설정
     * @param sock 소켓
     */
    public Chatter(Socket sock) {
    	this.socket = sock;
    }
    
	/*방에 입장시킴
	 * @param room 입장할 방
	*/
	public void enterRoom(ChattingRoom room) {
		room.enterUser(this);
		this.room = room;
	}
	/**
     * 방에서 퇴장
     * @param room 퇴장할 방
     */
    public void exitRoom(ChattingRoom room){
        this.room = null;
        // 퇴장처리(화면에 메세지를 준다는 등)
        // ...
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o ==null || getClass() != o.getClass()) return false;
		
		Chatter chatter = (Chatter) o;
		return userName == chatter.userName;
	}
	
	@Override
	public String toString() {
		return "Chatter [userName=" + userName + ", room=" + room + ", socket=" + socket + "]";
	}
}
