package musicTest;

import executor.Executor;
import music.Disc;
import music.MusicTrack;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DiscTest {
    Disc disc;
    Disc newDisc;
    Executor executor1;
    Executor executor2;

    @Before
    public void setup() {
        disc = new Disc();
        newDisc = new Disc();
        executor1 = new Executor(disc);
        executor2 = new Executor(newDisc);
    }

    @Test
    public void getDiskTest() {
        executor1.getMusicTracksFromFile();
        Disc newDisc = disc;
        assertEquals(newDisc.getDisc(), disc.getDisc());
    }

    @Test
    public void setDiskTest() {
        executor2.getMusicTracksFromFile();
        disc.setDisc(newDisc.getDisc());
        assertEquals(newDisc.getDisc(), disc.getDisc());
    }

    @Test
    public void addMusicTrack() {
        MusicTrack mt = new MusicTrack("testName", "23:59:59", "testStyle");
        disc.addMusicTrack(mt);
        assertEquals(disc.getDisc().get(disc.getDiscSize() - 1), mt);
    }

    @Test
    public void getDiscSize() {
        executor1.getMusicTracksFromFile();
        assertEquals(8, disc.getDiscSize());
    }

    @Test
    public void isDiskEmpty() {
        assertTrue(disc.isDiskEmpty());
    }
}
