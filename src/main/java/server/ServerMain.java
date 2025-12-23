package server;

import static common.Logger.log;

// 서버 프로그램 진입점
public class ServerMain {
    public static void main(String[] args) {
        log("서버 프로그램 실행");

        ServerController serverController = new ServerController();
        serverController.startServer();
    }
}
