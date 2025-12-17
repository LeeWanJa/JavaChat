import org.junit.jupiter.api.Test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MyServerTest {

    @Test
    void testServerAcceptMessage() throws IOException {
        DataInputStream inputMock = mock(DataInputStream.class);
        DataOutputStream outputMock = mock(DataOutputStream.class);

        when(inputMock.readUTF()).thenReturn("Hello");

        MyServer myServer = new MyServer(inputMock, outputMock);

        myServer.receiveAndSend();

        verify(outputMock).writeUTF("Hello World");
        verify(inputMock).readUTF();
    }
}
