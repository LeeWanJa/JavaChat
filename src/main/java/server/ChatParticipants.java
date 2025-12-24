package server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

public class ChatParticipants {
    // 스레드 생성 시 해당 스레드의 이름과 스레드가 맡은 Socket을 value로 저장
    private static final ConcurrentHashMap<String, Socket> participants = new ConcurrentHashMap<>();

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

    // 모든 채팅 참여자에게 채팅 보내기
    public static void sendToAll(String threadName, String received){
        participants.forEach((key, value) -> {
            try {
                DataOutputStream output = new DataOutputStream(value.getOutputStream());

                if(key.equals(threadName))
                    output.writeUTF("");
                else
                    output.writeUTF(received);

                output.flush(); // 버퍼에 남은게 있으면 싹다 밀어버림
            } catch (IOException e) {
                System.out.println("[" + key + "] 에게 전송 실패!");
            }
        });
    }
}
