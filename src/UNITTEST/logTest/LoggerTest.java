package logTest;

import static log.Logger.log;
import static org.junit.Assert.assertTrue;

public class LoggerTest {
    @org.junit.Test
    public void logTest() {
        boolean success = true;
        try {
            log("Just a Unit Test");
        } catch (Exception e) {
            success = false;
        }finally {
            assertTrue(success);
        }
    }
}
