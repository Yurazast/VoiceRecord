package executorTest;

import executor.Executor;
import music.Disc;
import music.MusicTrack;
import org.junit.Test;

import java.util.Scanner;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class ExecutorTest {
    Disc disc = new Disc();
    Disc newDisc = new Disc();
    Executor executor = new Executor(disc);

    @Test
    public void getMusicTracksFromInputTest() {
        String input = "testTrack1\njazz\n0:52:1\n" + "testTrack2\nrock\n5327\nn\n";
        Scanner scanner = new Scanner(input);
        executor.getMusicTracksFromInput(scanner);
        newDisc.addMusicTrack(new MusicTrack("testTrack1", "00:52:01", "jazz"));
        newDisc.addMusicTrack(new MusicTrack("testTrack2", "01:28:47", "rock"));
        assertEquals(newDisc, disc);
    }

    @Test
    public void getMusicTracksFromFileTest() {
        executor.getMusicTracksFromFile();
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
    public void findTrackLengthInRangeTest() {
        String input = "190 140";
        executor.getMusicTracksFromFile();
        newDisc.addMusicTrack(new MusicTrack("Poor_Little_Fool", 152, "rock-n-roll"));
        newDisc.addMusicTrack(new MusicTrack("The_Chipmunk_Song", 141, "pop"));
        newDisc.addMusicTrack(new MusicTrack("The_Twist", 162, "rock-n-roll"));
        newDisc.addMusicTrack(new MusicTrack("Sleep_Walk", 140, "rock"));
        assertEquals(newDisc.getDisc(), executor.findTrackLengthInRange(new Scanner(input)));
    }

    @Test
    public void sortDiskTest() {
        Function<MusicTrack, String> style = MusicTrack::getStyle;
        executor.getMusicTracksFromFile();
        newDisc.addMusicTrack(disc.getDisc().get(6));
        newDisc.addMusicTrack(disc.getDisc().get(1));
        newDisc.addMusicTrack(disc.getDisc().get(2));
        newDisc.addMusicTrack(disc.getDisc().get(3));
        newDisc.addMusicTrack(disc.getDisc().get(7));
        newDisc.addMusicTrack(disc.getDisc().get(5));
        newDisc.addMusicTrack(disc.getDisc().get(0));
        newDisc.addMusicTrack(disc.getDisc().get(4));
        executor.sortDisc(style);
        assertEquals(newDisc.getDisc(), disc.getDisc());
    }

    @Test
    public void printTest() {
        executor.getMusicTracksFromFile();
        executor.print(disc.getDisc());
        String expected = " 1 |        Poor_Little_Fool        |   00:02:32   |      152      |   rock-n-roll\n" +
                " 2 |             Venus              |   00:02:14   |      134      |       pop\n" +
                " 3 |       The_Chipmunk_Song        |   00:02:21   |      141      |       pop\n" +
                " 4 |          Stuck_on_You          |   00:02:18   |      138      |       pop\n" +
                " 5 |           The_Twist            |   00:02:42   |      162      |   rock-n-roll\n" +
                " 6 |           Sleep_Walk           |   00:02:20   |      140      |       rock\n" +
                " 7 |          The_Message           |   00:07:10   |      430      |     hip-hop\n" +
                " 8 |       It's_Now_or_Never        |   00:03:15   |      195      |       pop\n";
        assertEquals(expected, executor.lastExecutionResult);
    }
}