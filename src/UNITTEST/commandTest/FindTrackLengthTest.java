package commandTest;

import command.FindTrackLength;
import executor.Executor;
import music.Disc;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class FindTrackLengthTest {
    Disc disc = new Disc();
    Executor executor = new Executor(disc);
    FindTrackLength ftl = new FindTrackLength(disc) {
        @Override
        public void execute() {
            String input = "0:2:0 3:0";
            executor.getMusicTracksFromFile();
            executor.print(executor.findTrackLengthInRange(new Scanner(input)));
            setLastExecutionResult(executor.lastExecutionResult);
        }
    };

    @Test
    public void executeTest() {
        ftl.execute();
        String expected = " 1 |        Poor_Little_Fool        |   00:02:32   |      152      |   rock-n-roll\n" +
                " 2 |             Venus              |   00:02:14   |      134      |       pop\n" +
                " 3 |       The_Chipmunk_Song        |   00:02:21   |      141      |       pop\n" +
                " 4 |          Stuck_on_You          |   00:02:18   |      138      |       pop\n" +
                " 5 |           The_Twist            |   00:02:42   |      162      |   rock-n-roll\n" +
                " 6 |           Sleep_Walk           |   00:02:20   |      140      |       rock\n";
        assertEquals(expected, ftl.getLastExecutionResult());
    }

    @Test
    public void getNameTest() {
        assertEquals("FindTrackLength", ftl.getName());
    }
}
