package commandTest;

import command.FileInput;
import music.Disc;
import music.MusicTrack;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileInputTest {
    Disc disc = new Disc();
    Disc newDisc = new Disc();
    FileInput fi = new FileInput(disc);

    @Test
    public void executeTest() {
        fi.execute();
        String expected = "Disc has 8 music tracks now\n";
        assertEquals(expected, fi.getLastExecutionResult());
        newDisc.addMusicTrack(new MusicTrack("Poor_Little_Fool", 152, "rock-n-roll"));
        newDisc.addMusicTrack(new MusicTrack("Venus", 134, "pop"));
        newDisc.addMusicTrack(new MusicTrack("The_Chipmunk_Song", 141, "pop"));
        newDisc.addMusicTrack(new MusicTrack("Stuck_on_You", 138, "pop"));
        newDisc.addMusicTrack(new MusicTrack("The_Twist", 162, "rock-n-roll"));
        newDisc.addMusicTrack(new MusicTrack("Sleep_Walk", 140, "rock"));
        newDisc.addMusicTrack(new MusicTrack("The_Message", 430, "hip-hop"));
        newDisc.addMusicTrack(new MusicTrack("It's_Now_or_Never", 195, "pop"));
        assertEquals(newDisc, disc);
    }

    @Test
    public void unExecuteTest() {
        fi.unExecute();
        String expected = "Disc returned to previous state with number of music tracks - 0\n";
        assertEquals(expected, fi.getLastExecutionResult());
    }

    @Test
    public void getNameTest() {
        assertEquals("FileInput", fi.getName());
    }
}
