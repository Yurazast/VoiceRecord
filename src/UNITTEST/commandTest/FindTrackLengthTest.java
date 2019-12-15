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
        String expected = "1:\tname='Poor_Little_Fool', trackLength='00:02:32', durationInSeconds=152, style='rock-n-roll'\n" +
                "2:\tname='Venus', trackLength='00:02:14', durationInSeconds=134, style='pop'\n" +
                "3:\tname='The_Chipmunk_Song', trackLength='00:02:21', durationInSeconds=141, style='pop'\n" +
                "4:\tname='Stuck_on_You', trackLength='00:02:18', durationInSeconds=138, style='pop'\n" +
                "5:\tname='The_Twist', trackLength='00:02:42', durationInSeconds=162, style='rock-n-roll'\n" +
                "6:\tname='Sleep_Walk', trackLength='00:02:20', durationInSeconds=140, style='rock'\n";
        assertEquals(expected, ftl.getLastExecutionResult());
    }

    @Test
    public void getNameTest() {
        assertEquals("FindTrackLength", ftl.getName());
    }
}
