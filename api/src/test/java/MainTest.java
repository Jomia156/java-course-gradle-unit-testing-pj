import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MainTest {

    @Test
    public void testMain_outputContainsExpectedStrings_success() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        
        Main.main(new String[]{});
        
        String output = outputStream.toString();
        System.setOut(originalOut);
        
        Assertions.assertTrue(output.contains("MyEntity{"));
        Assertions.assertTrue(output.contains("name='first'"));
        Assertions.assertTrue(output.contains("name='second'"));
        
        
        String[] lines = output.trim().split("\\r?\\n");
        Assertions.assertEquals(3, lines.length);
    }

    @Test
    public void testMain_noExceptions_thrown() {
        Assertions.assertDoesNotThrow(() -> Main.main(new String[]{}));
    }

    @Test
    public void testMain_withArguments_noExceptions_thrown() {
        String[] args = {"arg1", "arg2"};
        Assertions.assertDoesNotThrow(() -> Main.main(args));
    }
}