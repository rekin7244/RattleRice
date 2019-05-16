package com.kh.rr.websocket;

import java.io.IOException;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
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
   private static Set<Session> clients = Collections.synchronizedSet(new LinkedHashSet<Session>());
   //   private static Map<String, Set<Session>> clientsMap = Collections.synchronizedMap(new HashMap<String, Set<Session>>());
   //   private static Set<Session> temp = new HashSet<Session>();
   //   private String msg = "";
   @OnOpen
   public void onOpen(Session session) {
      //서버 연결한 시점에 동작하는 메소드
      //기존 사용자 리스트에 새로 연결 요청이 들어온 사용자를 추가한다

      /*msg = session.getQueryString();
      System.out.println("쿼리스트링" + msg);*/

      clients.add(session);

      /*System.out.println("입장했을때 clients 목록" + clients);
      clientsMap.put(msg, clients);

      Iterator<Session> it = clients.iterator();
      while(it.hasNext()) {
         Session s = it.next();
         if(s.equals(session)) {
            System.out.println("마지막 세션 정보와 일치 할때" + s);

            System.out.println("현재 맵의 길이"+clientsMap.get(msg).size());
            Set<Session> temp = new HashSet<Session>();
           if(clientsMap.get(msg).size() > 1) {
              temp.add(s);
              temp.addAll(clientsMap.get(msg));

              clientsMap.put(msg,temp);
           }else {
              temp.add(s);
           }           
         }        
      }*/

   }

   @OnMessage
   public void onMessage(String msg, Session session) throws IOException {
      //서버로부터 데이터를 전송받을 경우 동작할 메소드
      System.out.println(msg);

      String str2 = "-";
      boolean b = msg.contains(str2);
      String userId = "", message = "", rno = "";


      if(b == true) {
         String[] srr = msg.split("-");
         rno = srr[0];
         userId = srr[1];
         message = srr[2];
      }else {
         String[] srr = msg.split(":");
         userId = "";
         rno = srr[0];
         message = srr[1];
      }

      //하나의 일 처리를 수행하는동안 사용자의 변경이 일어나면 안된다.
      //즉 NullPointer를 방지하기 위해 동기화 처리를 해준다.

      //original
      synchronized(clients) {
         for(Session client : clients) {
            if (!client.equals(session)) {
               client.getBasicRemote().sendText(msg);
            }
         }
      }

      //version1
      //Set<Session> set = clientsMap.get(this.msg);      
      /*synchronized(set) {
      for(Session client : set) {
         if (!client.equals(session)) {
            if(userId.equals("")) {
               client.getBasicRemote().sendText(message);
            }else {
               client.getBasicRemote().sendText(userId + " : " + message);
            }
         }
      }
   }*/

      //version2
      /*synchronized(clientsMap) {
         System.out.println("방 안의 사용자들 세션정보"+clientsMap.get(this.msg));
         Set<Session> set = clientsMap.get(this.msg);
         synchronized(set) {

            for(Session client : set) {
               System.out.println(rno+"rno를 키 값으로 하는 맵의 session 들"+clientsMap.get("rno=" + rno));
               if (!client.equals(session) && clientsMap.get("rno="+rno).contains(client)) {
                  if(userId.equals("")) {
                     client.getBasicRemote().sendText(message);
                  }else {
                     client.getBasicRemote().sendText(userId + " : " + message);
                  }
               }
            }
         }
      }*/

	}

	@OnError
	public void onError(Throwable e) {
		//데이터를 전달하는 과정에서 에러가 발생할 경우 동작하는 메소드
		e.printStackTrace();
	}

	private String closemsg = "님이 채팅방을 나가셨습니다.";
	
	@OnClose
	public void onClose(Session session) throws IOException {
		synchronized(clients) {
			for(Session client : clients) {
				if (!client.equals(session)) {
					
						client.getBasicRemote().sendText(session.getId() + "나감");
						System.out.println(session.getId() + "나감");
				}
			}
		}
		
		
		//지워주지 않으면 Set에 이미 나간 사용자가 남아있기 때문에 메세지 전송시 에러 난다.
		clients.remove(session);
	}


}