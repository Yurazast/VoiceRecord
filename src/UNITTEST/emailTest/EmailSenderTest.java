package emailTest;

import static email.EmailSender.sendError;
import static org.junit.Assert.assertTrue;

public class EmailSenderTest {
    @org.junit.Test
    public void sendEmail() {
        assertTrue(sendError("Just a Unit Test"));
    }
}