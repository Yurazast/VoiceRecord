package commandTest;

import command.SortDisc;
import executor.Executor;
import music.Disc;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SortDiscTest {
    Disc disc = new Disc();
    Disc newDisc = new Disc();
    Executor executor = new Executor(disc);
    SortDisc sd = new SortDisc(disc) {
        @Override
        public void execute() {
            setLastExecutionResult("");
            showSortItems();
            int choice = 3;
            perform(choice);
        }
    };

    @Test
    public void executeTest() {
        executor.getMusicTracksFromFile();
        newDisc.addMusicTrack(disc.getDisc().get(6));
        newDisc.addMusicTrack(disc.getDisc().get(1));
        newDisc.addMusicTrack(disc.getDisc().get(2));
        newDisc.addMusicTrack(disc.getDisc().get(3));
        newDisc.addMusicTrack(disc.getDisc().get(7));
        newDisc.addMusicTrack(disc.getDisc().get(5));
        newDisc.addMusicTrack(disc.getDisc().get(0));
        newDisc.addMusicTrack(disc.getDisc().get(4));
        sd.execute();
        String expected = "\nSort music tracks:\n" +
                "1 - by name\n" +
                "2 - by duration\n" +
                "3 - by style\n" +
                "4 - by name, then by duration\n" +
                "5 - by name, then by style\n" +
                "6 - by duration, then by name\n" +
                "7 - by duration, then by style\n" +
                "8 - by style, then by name\n" +
                "9 - by style, then by duration\n" +
                "0 - Don't sort\n\n" +
                "Enter your choice: 3\n";
        assertEquals(expected, sd.getLastExecutionResult());
        assertEquals(newDisc.getDisc(), disc.getDisc());
    }

    @Test
    public void unExecuteTest() {
        sd.unExecute();
        String expected = "Disc returned to previous state.";
        assertEquals(expected, sd.getLastExecutionResult());
    }

    @Test
    public void getNameTest() {
        assertEquals("Sort", sd.getName());
    }
}