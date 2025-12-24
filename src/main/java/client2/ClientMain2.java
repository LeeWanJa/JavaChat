package client2;

import static common.Logger.log;

public class ClientMain2 {
    public static void main(String[] args) {
        log("클라이언트 프로그램 시작");

        ClientController2 clientController = new ClientController2();
        clientController.startClient();
    }
}
