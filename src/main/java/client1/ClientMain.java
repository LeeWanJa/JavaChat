package client1;

import static common.Logger.log;

public class ClientMain {
    public static void main(String[] args) {
        log("클라이언트 프로그램 시작");

        ClientController clientController = new ClientController();
        clientController.startClient();
    }
}
