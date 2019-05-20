
package com.kh.rr.websocket;

import java.io.IOException;


import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
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
   private static HashMap<String,Object> hmap = new HashMap<String,Object>();
   
   @OnOpen
   public void onOpen(Session session) {
      //서버 연결한 시점에 동작하는 메소드
      //기존 사용자 리스트에 새로 연결 요청이 들어온 사용자를 추가한다

      /*msg = session.getQueryString();
      System.out.println("쿼리스트링" + msg);*/

      clients.add(session);

      System.out.println("입장했을때 clients 목록" + clients);

   }

   @OnMessage
   public void onMessage(String msg, Session session) throws IOException {
      //서버로부터 데이터를 전송받을 경우 동작할 메소드
      System.out.println(msg);

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
	}

	@OnError
	public void onError(Throwable e) {
		//데이터를 전달하는 과정에서 에러가 발생할 경우 동작하는 메소드
		e.printStackTrace();
	}

	
	@OnClose
	public void onClose(Session session) {
		/*synchronized(clients) {
			for(Session client : clients) {
				if (!client.equals(session)) {
						try {
							client.getBasicRemote().sendText("님이 채팅방을 나가셨습니다.");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
				}
			}
		}*/
		//-> 나가기는 client를 저장할 Map을 만들어서 대화명을 저장한뒤 key값으로 불러온다...
		
		//지워주지 않으면 Set에 이미 나간 사용자가 남아있기 때문에 메세지 전송시 에러 난다.
		clients.remove(session);
	}


}