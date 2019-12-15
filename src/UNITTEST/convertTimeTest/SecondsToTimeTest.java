package convertTimeTest;

import convertTime.SecondsToTime;

import static org.junit.Assert.assertEquals;

public class SecondsToTimeTest {
    @org.junit.Test
    public void convertTest() {
        String expected = "01:35:42";
        String actual = SecondsToTime.parseTime(5742);
        assertEquals(expected, actual);
    }
}
