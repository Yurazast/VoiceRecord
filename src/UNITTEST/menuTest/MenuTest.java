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
                " 1 |        Poor_Little_Fool        |   00:02:32   |      152      |   rock-n-roll\n" +
                " 2 |             Venus              |   00:02:14   |      134      |       pop\n" +
                " 3 |       The_Chipmunk_Song        |   00:02:21   |      141      |       pop\n" +
                " 4 |          Stuck_on_You          |   00:02:18   |      138      |       pop\n" +
                " 5 |           The_Twist            |   00:02:42   |      162      |   rock-n-roll\n" +
                " 6 |           Sleep_Walk           |   00:02:20   |      140      |       rock\n" +
                " 7 |          The_Message           |   00:07:10   |      430      |     hip-hop\n" +
                " 8 |       It's_Now_or_Never        |   00:03:15   |      195      |       pop\n" +
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