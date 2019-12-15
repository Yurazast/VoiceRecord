package musicTest;

import music.MusicTrack;
import org.junit.Test;

import static music.MusicTrack.checkTrackLength;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MusicTrackTest {
    private MusicTrack mt = new MusicTrack("testTrack", "0:52:1", "jazz");

    @Test
    public void getNameTest() {
        String expected = "testTrack";
        String actual = mt.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void getStyleTest() {
        String expected = "jazz";
        String actual = mt.getStyle();
        assertEquals(expected, actual);
    }

    @Test
    public void getTrackLengthTest() {
        String expected = "00:52:01";
        String actual = mt.getTrackLength();
        assertEquals(expected, actual);
    }

    @Test
    public void setTrackLengthTest() {
        String expected = "00:23:48";
        mt.setTrackLength("00:23:48");
        String actual = mt.getTrackLength();
        assertEquals(expected, actual);
    }

    @Test
    public void getDurationInSecondsTest() {
        int expected = 3121;
        int actual = mt.getDurationInSeconds();
        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void setDurationInSecondsTest() {
        int expected = 5207;
        mt.setDurationInSeconds(5207);
        int actual = mt.getDurationInSeconds();
        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void checkTrackLengthTest() {
        String expected = "00:07:33";
        String actual = checkTrackLength("0000:7:033");
        assertEquals(expected, actual);
    }

    @Test
    public void isInRange() {
        assertTrue(mt.isInRange(3000, 4000));
    }

    @Test
    public void toStringTest() {
        String expected = "name='testTrack', trackLength='00:52:01', durationInSeconds=3121, style='jazz'";
        assertEquals(expected, mt.toString());
    }
}
