import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class MyServer {
    private final DataInputStream input;
    private final DataOutputStream output;

    public MyServer(DataInputStream input, DataOutputStream output) throws IOException {
        this.input = input;
        this.output = output;
    }

    public void receiveAndSend() throws IOException {
        String toSend = input.readUTF() + " World";

        output.writeUTF(toSend);
    }
}
