package commandTest;

import command.KeyboardInput;
import executor.Executor;
import music.Disc;
import music.MusicTrack;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class KeyboardInputTest {
    Disc disc = new Disc();
    Disc newDisc = new Disc();
    Executor executor = new Executor(disc);
    KeyboardInput ki = new KeyboardInput(disc) {
        @Override
        public void execute() {
            String input = "testTrack\nhip-hop\n36464\nn\n";
            executor.getMusicTracksFromInput(new Scanner(input));
            executor.lastExecutionResult = "Disc has " + disc.getDiscSize() + " music tracks now\n";
            setLastExecutionResult(executor.lastExecutionResult);
        }
    };

    @Test
    public void executeTest() {
        ki.execute();
        String expected = "Disc has 1 music tracks now\n";
        assertEquals(expected, ki.getLastExecutionResult());
        newDisc.addMusicTrack(new MusicTrack("testTrack", 36464, "hip-hop"));
        assertEquals(newDisc, disc);
    }

    @Test
    public void unExecuteTest() {
        ki.unExecute();
        String expected = "Disc returned to previous state with number of music tracks - 0\n";
        assertEquals(expected, ki.getLastExecutionResult());
    }

    @Test
    public void getNameTest() {
        assertEquals("KeyboardInput", ki.getName());
    }
}
