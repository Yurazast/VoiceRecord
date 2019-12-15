package convertTimeTest;

import convertTime.TimeToSeconds;

import static org.junit.Assert.assertEquals;

public class TimeToSecondsTest {
    @org.junit.Test
    public void convertTest() {
        int expected = 26459;
        int actual = TimeToSeconds.parseTime("07:20:59");
        assertEquals(expected, actual);
    }
}
