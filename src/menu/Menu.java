package menu;

import command.*;
import log.Logger;
import music.Disc;
import undoRedo.UndoRedoManager;

import java.util.Scanner;

public class Menu {
    private UndoRedoManager manager;
    protected boolean exit;
    private Disc disc;
    public String lastExecutionResult;

    public Menu() {
        manager = new UndoRedoManager();
        disc = new Disc();
    }

    public void run(Scanner scanner) throws InterruptedException {
        lastExecutionResult = "";
        while (!this.exit) {
            showMenuItems();
            int choice = getChoice(scanner);
            lastExecutionResult += choice;
            perform(choice);
        }
    }

    private void showMenuItems() {
        System.out.println("\n1 - Enter music tracks from keyboard\n" +
                "2 - Get music tracks from file\n" +
                "3 - Find track in range\n" +
                "4 - Print music tracks on disc\n" +
                "5 - Sort disc\n" +
                "6 - Undo(" + manager.getUndoName() + ")\n" +
                "7 - Redo(" + manager.getRedoName() + ")\n" +
                "8 - Print undo list\n" +
                "9 - Print redo list\n" +
                "0 - Exit\n");
        lastExecutionResult += ("\n1 - Enter music tracks from keyboard\n" +
                "2 - Get music tracks from file\n" +
                "3 - Find track in range\n" +
                "4 - Print music tracks on disc\n" +
                "5 - Sort disc\n" +
                "6 - Undo(" + manager.getUndoName() + ")\n" +
                "7 - Redo(" + manager.getRedoName() + ")\n" +
                "8 - Print undo list\n" +
                "9 - Print redo list\n" +
                "0 - Exit\n\n");
    }

    private int getChoice(Scanner scanner) {
        System.out.print("Enter your choice: ");
        lastExecutionResult += "Enter your choice: ";
        while (!scanner.hasNextInt()) {
            System.out.print("NaN. Enter again: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void perform(int userChoice) throws InterruptedException {
        switch (userChoice) {
            case 1:
                manager.execute(new KeyboardInput(disc));
                break;
            case 2:
                manager.execute(new FileInput(disc));
                break;
            case 3:
                manager.execute(new FindTrackLength(disc));
                break;
            case 4:
                manager.execute(new PrintDisc(disc));
                break;
            case 5:
                manager.execute(new SortDisc(disc));
                break;
            case 6:
                manager.undo();
                break;
            case 7:
                manager.redo();
                break;
            case 8:
                manager.undoList();
                break;
            case 9:
                manager.redoList();
                break;
            case 0:
                exit = true;
                System.out.println("\nThanks for using this program.\nGoodbye " + System.getProperty("user.name") + "...");
                Logger.log("Exit...\n-----------------------------------------------------------------------------------------------------------------------------");
                break;
            default:
                System.out.println("Wrong choice");
                Thread.sleep(3000);
        }
        if (manager.lastExecutionResult != null && userChoice != 0)
            lastExecutionResult += '\n' + manager.lastExecutionResult;
    }
}
