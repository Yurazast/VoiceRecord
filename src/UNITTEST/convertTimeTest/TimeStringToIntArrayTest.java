package convertTimeTest;

import convertTime.TimeStringToIntArray;

import static org.junit.Assert.assertArrayEquals;

public class TimeStringToIntArrayTest {
    @org.junit.Test
    public void convertTest() {
        Integer[] expected = {2, 23, 18};
        Integer[] actual = TimeStringToIntArray.convertTime("02:23:18");
        assertArrayEquals(expected, actual);
    }
}
