import org.junit.jupiter.api.Test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MyClientTest {

    @Test
    void testSocketCommunication() throws IOException {
        DataInputStream mockInput = mock(DataInputStream.class);
        DataOutputStream mockOutput = mock(DataOutputStream.class);

        when(mockInput.readUTF()).thenReturn("World");

        MyClient client = new MyClient(mockInput, mockOutput);

        String result = client.sendAndReceive("Hello");

        verify(mockOutput).writeUTF("Hello");

        assertEquals("World", result);
    }
}
