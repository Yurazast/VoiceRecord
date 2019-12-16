package commandTest;

import command.PrintDisc;
import executor.Executor;
import music.Disc;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrintDiscTest {
    Disc disc = new Disc();
    Executor executor = new Executor(disc);
    PrintDisc pd = new PrintDisc(disc);

    @Test
    public void executeTest() {
        executor.getMusicTracksFromFile();
        pd.execute();
        String expected = " 1 |        Poor_Little_Fool        |   00:02:32   |      152      |   rock-n-roll\n" +
                " 2 |             Venus              |   00:02:14   |      134      |       pop\n" +
                " 3 |       The_Chipmunk_Song        |   00:02:21   |      141      |       pop\n" +
                " 4 |          Stuck_on_You          |   00:02:18   |      138      |       pop\n" +
                " 5 |           The_Twist            |   00:02:42   |      162      |   rock-n-roll\n" +
                " 6 |           Sleep_Walk           |   00:02:20   |      140      |       rock\n" +
                " 7 |          The_Message           |   00:07:10   |      430      |     hip-hop\n" +
                " 8 |       It's_Now_or_Never        |   00:03:15   |      195      |       pop\n";
        assertEquals(expected, pd.getLastExecutionResult());
    }

    @Test
    public void getNameTest() {
        assertEquals("Print", pd.getName());
    }
}
