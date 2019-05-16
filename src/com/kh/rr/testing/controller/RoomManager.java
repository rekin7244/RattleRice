package com.kh.rr.testing.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.kh.rr.testing.model.vo.Chatter;

public class RoomManager {
	private static List<ChattingRoom> roomList;
	private static AtomicInteger atomicInteger;
	
	static {
		roomList = new ArrayList();
		atomicInteger = new AtomicInteger();
	}
	
	//cons
	public RoomManager() {}
	
	/**
     * 빈 룸을 생성
     * @return ChattingRoom
     */
	public static ChattingRoom createRoom() {	//룸을 새로 생성(빈 방)
		int roomId = atomicInteger.incrementAndGet();	//room id 채번
		ChattingRoom room = new ChattingRoom(roomId);
		roomList.add(room);
		System.out.println("Room Created!");
		return room;
	}
	
	/**
     * 방을 생성함과 동시에 방장을 만들어줌
     * @param owner 방장
     * @return ChattingRoom
     */
	//유저가 방을 생성할 때 사용(유저가 방장으로 들어감)
	public static ChattingRoom createRoom(Chatter owner) {
		int roomId = atomicInteger.incrementAndGet();	//room id 채번
		
		ChattingRoom room = new ChattingRoom(roomId);
		room.enterUser(owner);
		room.setOwner(owner);
		
		roomList.add(room);
		System.out.println("Room Created! and owner is "+owner.getUserName());
		return room;
	}
	
	  /**
     * 유저 리스트로 방을 생성
     * @param users 입장시킬 유저 리스트
     * @return ChattingRoom
     */
    public static ChattingRoom createRoom(List<Chatter> users) {
    	int roomId = atomicInteger.incrementAndGet();	//room id 채번
    	
    	ChattingRoom room = new ChattingRoom(roomId);
    	room.enterUser(users);
    	
    	roomList.add(room);
    	System.out.println("Room Created by userList!");
    	return room;
    }
    
    public static ChattingRoom getRoom(ChattingRoom chattingRoom) {
    	int idx = roomList.indexOf(chattingRoom);
    	
    	if(idx > 0) {
    		return roomList.get(idx);
    	}else {
    		return null;
    	}
    }
    
    /**
     * 전달받은 룸을 제거
     * @param room 제거할 룸
     */
    public static void removeRoom(ChattingRoom room) {
        room.close();
        roomList.remove(room); // 전달받은 룸을 제거한다.
        System.out.println("Room Deleted!");
    }
    
    /**
     * 방의 현재 크기를 리턴
     * @return 현재 size
     */
    public static int roomCount() {
    	return roomList.size();
    }
}
