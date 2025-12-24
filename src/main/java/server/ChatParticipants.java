package server;

import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

public class ChatParticipants {
    // 스레드 생성 시 해당 스레드의 이름과 스레드가 맡은 Socket을 value로 저장
    private static final ConcurrentHashMap<String, Socket> participants = new ConcurrentHashMap<>();
    
    // FlyWeight 팩토리 메서드
    // participants에 정보 저장
    public static void from(String ThreadName, Socket socket){
        participants.put(ThreadName, socket);
    }

    // 현재 채팅 참여자 목록 출력
    public static String getParticipants(){
        StringBuilder sb = new StringBuilder();

        sb.append("참여자 목록\n");
        participants.forEach((key, value) -> {
            sb.append(key + "\n");
        });

        return sb.toString();
    }
}
