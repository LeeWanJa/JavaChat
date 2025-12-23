package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static common.Logger.log;

public class ServerSession implements Runnable{
    private final Socket socket;

    public ServerSession(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run(){
        try(socket;
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream())
        ){
            while(true){
                String received = dataInputStream.readUTF();
                log("클라이언트가 보낸 메세지 : " + received);

                if(received.equals("exit")){
                    log("클라이언트가 종료로를 요청했습니다.");
                    break;
                }

                String toSend = "Hello Client!";
                dataOutputStream.writeUTF(toSend);
            }
        } catch (IOException e){
            log("클라이언트와의 연결이 끊겼습니다 : " + e.getMessage());
        }

        log("클라이언트와 연결 종료");
    }
}
