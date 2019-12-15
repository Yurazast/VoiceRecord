import org.junit.Test;

public class MainTest extends Main {

    @org.junit.Test(timeout = 7500, expected = Test.None.class)
    public void mainTest() throws InterruptedException {
        main(new String[]{"skip", "2", "4", "8", "0"});
    }
}