package client;

import java.io.IOException;
import java.net.Socket;

import static common.Logger.log;

public class ClientMain {
    public static void main(String[] args) {
        log("클라이언트 프로그램 시작");

        try (Socket socket = new Socket("localhost", 8000);) {

        } catch(IOException e){
            log("서버와의 연결이 끊겼습니다! : " + e.getMessage());
        }

    }
}
