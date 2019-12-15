package undoRedoTest;

import command.FileInput;
import command.PrintDisc;
import music.Disc;
import music.MusicTrack;
import org.junit.Test;
import undoRedo.UndoRedoManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class UndoRedoManagerTest {
    private Disc disc = new Disc();
    private Disc newDisc = new Disc();
    private UndoRedoManager urm = new UndoRedoManager();

    @Test
    public void getUndoNameTest() {
        urm.execute(new FileInput(disc));
        String expected = "FileInput";
        assertEquals(expected, urm.getUndoName());
    }

    @Test
    public void getRedoNameTest() {
        urm.execute(new PrintDisc(disc));
        urm.undo();
        String expected = "Print";
        assertEquals(expected, urm.getRedoName());
    }

    @Test
    public void executeTest() {
        urm.execute(new FileInput(disc));
        String expected = "Disc has 8 music tracks now\n";
        assertEquals(expected, urm.lastExecutionResult);
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
    public void undoTest() {
        urm.execute(new FileInput(disc));
        urm.undo();
        String expected = "Disc returned to previous state with number of music tracks - 0\n";
        assertEquals(expected, urm.lastExecutionResult);
    }

    @Test
    public void redoTest() {
        urm.execute(new PrintDisc(disc));
        urm.undo();
        urm.redo();
        assertNull(urm.lastExecutionResult);
    }

    @Test
    public void undoListTest() {
        urm.execute(new FileInput(disc));
        urm.undoList();
        String expected = "Undo list:\n" +
                "\tFileInput\n";
        assertEquals(expected, urm.lastExecutionResult);
    }

    @Test
    public void redoListTest() {
        urm.execute(new PrintDisc(disc));
        urm.undo();
        urm.redoList();
        String expected = "Redo list:\n" +
                "\tPrint\n";
        assertEquals(expected, urm.lastExecutionResult);
    }
}