package com.kh.rr.websocket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/serverStart")
public class ServerStart {
   private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
   private static Map<String, Set> clientsMap = Collections.synchronizedMap(new HashMap<String, Set>());
   private String msg = "";
   @OnOpen
   public void onOpen(Session session) {
      //서버 연결한 시점에 동작하는 메소드
      //기존 사용자 리스트에 새로 연결 요청이 들어온 사용자를 추가한다
	   msg = session.getQueryString();
	   System.out.println("쿼리스트링"+msg);
	   
	   clients.add(session);
	   clientsMap.put(msg, clients);
	   
      
      
   }

   @OnMessage
   public void onMessage(String msg, Session session) throws IOException {
      //서버로부터 데이터를 전송받을 경우 동작할 메소드
      System.out.println(msg);
      
      String[] srr = msg.split(":");
      String str2 = ":";
      boolean b = msg.contains(str2);
      String userId=null, message=null, rno=null;
      
      
      if(b==true) {
         rno = srr[0];
         userId = srr[1];
         message = srr[2];
      }else {
    	 rno = srr[0];
         userId = "";
         message = msg;
      }
      
      Set<Session> set = clientsMap.get(rno);
      
      //하나의 일 처리를 수행하는동안 사용자의 변경이 일어나면 안된다.
      //즉 NullPointer를 방지하기 위해 동기화 처리를 해준다.
      synchronized(set) {
         for(Session client : set) {
            if (!client.equals(session)) {
               if(userId.equals("")) {
                  client.getBasicRemote().sendText(message);
               }else {
                  client.getBasicRemote().sendText(userId + " : " + message);
               }
            }
         }
      }
   }
   
   @OnError
   public void onError(Throwable e) {
      //데이터를 전달하는 과정에서 에러가 발생할 경우 동작하는 메소드
      e.printStackTrace();
   }
   
   @OnClose
   public void onClose(Session session) {
      //지워주지 않으면 Set에 이미 나간 사용자가 남아있기 때문에 메세지 전송시 에러 난다.
      clients.remove(session);
   }

}