import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class MyClient {
    private final DataInputStream input;
    private final DataOutputStream output;

    public MyClient(DataInputStream input, DataOutputStream output) {
        this.input = input;
        this.output = output;
    }

    public String sendAndReceive(String message) throws IOException {
        output.writeUTF(message);

        String response = input.readUTF();
        return response;
    }
}
