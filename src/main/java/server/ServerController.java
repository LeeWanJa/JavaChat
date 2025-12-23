package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static common.Logger.log;

public class ServerController {

    public void startServer(){


        try(ServerSocket serverSocket = new ServerSocket(8000)){
            log("서버 소켓 생성");


            while(true){
                // 클라의 요청 accept() 후 Socket 반환
                Socket socket = serverSocket.accept();
                log("소켓 연결 완료!");

                // 반환된 소켓 정보를 기반으로 Runnable을 구현한 객체 생성
                ServerSession serverSession = new ServerSession(socket);

                // 스레드 start!
                Thread thread = new Thread(serverSession);
                thread.start();
            }
        } catch(IOException e){
            System.out.println("ServerSocket 생성 중 오류 발생 : " + e.getMessage());
        }
    }
}
