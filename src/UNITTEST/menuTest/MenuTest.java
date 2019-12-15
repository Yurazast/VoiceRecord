package menuTest;

import menu.Menu;
import org.junit.Before;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class MenuTest {
    String input;
    Scanner scanner;
    Menu m;

    @Before
    public void setup() {
        input = "2\n4\n8\n0\n";
        scanner = new Scanner(input);
        m = new Menu();
    }

    @org.junit.Test
    public void runTest() throws InterruptedException {
        m.run(scanner);
        String expected = "\n1 - Enter music tracks from keyboard\n" +
                "2 - Get music tracks from file\n" +
                "3 - Find track in range\n" +
                "4 - Print music tracks on disc\n" +
                "5 - Sort disc\n" +
                "6 - Undo()\n" +
                "7 - Redo()\n" +
                "8 - Print undo list\n" +
                "9 - Print redo list\n" +
                "0 - Exit\n\n" +
                "Enter your choice: 2\n" +
                "Disc has 8 music tracks now\n" +
                "\n1 - Enter music tracks from keyboard\n" +
                "2 - Get music tracks from file\n" +
                "3 - Find track in range\n" +
                "4 - Print music tracks on disc\n" +
                "5 - Sort disc\n" +
                "6 - Undo(FileInput)\n" +
                "7 - Redo()\n" +
                "8 - Print undo list\n" +
                "9 - Print redo list\n" +
                "0 - Exit\n\n" +
                "Enter your choice: 4\n" +
                "1:\tname='Poor_Little_Fool', trackLength='00:02:32', durationInSeconds=152, style='rock-n-roll'\n" +
                "2:\tname='Venus', trackLength='00:02:14', durationInSeconds=134, style='pop'\n" +
                "3:\tname='The_Chipmunk_Song', trackLength='00:02:21', durationInSeconds=141, style='pop'\n" +
                "4:\tname='Stuck_on_You', trackLength='00:02:18', durationInSeconds=138, style='pop'\n" +
                "5:\tname='The_Twist', trackLength='00:02:42', durationInSeconds=162, style='rock-n-roll'\n" +
                "6:\tname='Sleep_Walk', trackLength='00:02:20', durationInSeconds=140, style='rock'\n" +
                "7:\tname='The_Message', trackLength='00:07:10', durationInSeconds=430, style='hip-hop'\n" +
                "8:\tname='It's_Now_or_Never', trackLength='00:03:15', durationInSeconds=195, style='pop'\n" +
                "\n1 - Enter music tracks from keyboard\n" +
                "2 - Get music tracks from file\n" +
                "3 - Find track in range\n" +
                "4 - Print music tracks on disc\n" +
                "5 - Sort disc\n" +
                "6 - Undo(Print)\n" +
                "7 - Redo()\n" +
                "8 - Print undo list\n" +
                "9 - Print redo list\n" +
                "0 - Exit\n\n" +
                "Enter your choice: 8\n" +
                "Undo list:\n" +
                "\tFileInput\n" +
                "\tPrint\n" +
                "\n1 - Enter music tracks from keyboard\n" +
                "2 - Get music tracks from file\n" +
                "3 - Find track in range\n" +
                "4 - Print music tracks on disc\n" +
                "5 - Sort disc\n" +
                "6 - Undo(Print)\n" +
                "7 - Redo()\n" +
                "8 - Print undo list\n" +
                "9 - Print redo list\n" +
                "0 - Exit\n\n" +
                "Enter your choice: 0";
        assertEquals(expected, m.lastExecutionResult);
    }
}