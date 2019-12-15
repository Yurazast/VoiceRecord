package commandTest;

import command.PrintDisc;
import executor.Executor;
import music.Disc;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrintDiscTest {
    Disc disc = new Disc();
    Executor executor= new Executor(disc);
    PrintDisc pd = new PrintDisc(disc);

    @Test
    public void executeTest() {
        executor.getMusicTracksFromFile();
        pd.execute();
        String expected = "1:\tname='Poor_Little_Fool', trackLength='00:02:32', durationInSeconds=152, style='rock-n-roll'\n" +
                "2:\tname='Venus', trackLength='00:02:14', durationInSeconds=134, style='pop'\n" +
                "3:\tname='The_Chipmunk_Song', trackLength='00:02:21', durationInSeconds=141, style='pop'\n" +
                "4:\tname='Stuck_on_You', trackLength='00:02:18', durationInSeconds=138, style='pop'\n" +
                "5:\tname='The_Twist', trackLength='00:02:42', durationInSeconds=162, style='rock-n-roll'\n" +
                "6:\tname='Sleep_Walk', trackLength='00:02:20', durationInSeconds=140, style='rock'\n" +
                "7:\tname='The_Message', trackLength='00:07:10', durationInSeconds=430, style='hip-hop'\n" +
                "8:\tname='It's_Now_or_Never', trackLength='00:03:15', durationInSeconds=195, style='pop'\n";
        assertEquals(expected, pd.getLastExecutionResult());
    }

    @Test
    public void getNameTest() {
        assertEquals("Print", pd.getName());
    }
}
