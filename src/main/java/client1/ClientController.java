package client1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static common.Logger.log;

public class ClientController {

    public void startClient(){
        try (
                Socket socket = new Socket("localhost", 8000);
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                DataInputStream input = new DataInputStream(socket.getInputStream());
        ) {
            log("서버와의 연결 성공!");

            Scanner scanner = new Scanner(System.in);

            while(true) {
                System.out.print(">>> ");
                String toSend = scanner.nextLine();

                output.writeUTF(toSend);
                log("클라이언트 -> 서버 : " + toSend);

                String received = input.readUTF();
                log("서버 -> 클라이언트 : " + received);
            }

        } catch(IOException e){
            log("서버와의 연결이 끊겼습니다! : " + e.getMessage());
        }
    }
}
