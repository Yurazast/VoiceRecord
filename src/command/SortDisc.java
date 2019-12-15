package command;

import email.EmailSender;
import executor.Executor;
import log.Logger;
import music.Disc;
import music.MusicTrack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortDisc implements Command {
    private Disc disc;
    private Disc previousDisc = new Disc();
    private Executor executor;
    private String lastExecutionResult;

    public SortDisc(Disc disc) {
        this.disc = disc;
        this.previousDisc.setDisc(disc.getDisc());
        executor = new Executor(disc);
    }

    @Override
    public void execute() {
        showSortItems();
        int choice = getChoice();
        perform(choice);
    }

    @Override
    public void unExecute() {
        disc.setDisc(previousDisc.getDisc());
        System.out.println("Disc returned to previous state.");
        lastExecutionResult = "Disc returned to previous state.";
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Logger.log("ERROR: " + e.getMessage() + "\n" + Arrays.stream(e.getStackTrace()).map(i -> i + "\n").collect(Collectors.joining()));
            EmailSender.sendError("ERROR: " + e.getMessage() + "\n" + Arrays.stream(e.getStackTrace()).map(i -> i + "\n").collect(Collectors.joining()));
            e.printStackTrace();
        }
    }

    @Override
    public String getLastExecutionResult() {
        return lastExecutionResult;
    }

    public void setLastExecutionResult(String lastExecutionResult) {
        this.lastExecutionResult = lastExecutionResult;
    }

    @Override
    public String getName() {
        return "Sort";
    }

    protected void showSortItems() {
        System.out.println("\nSort music tracks:\n" +
                "1 - by name\n" +
                "2 - by duration\n" +
                "3 - by style\n" +
                "4 - by name, then by duration\n" +
                "5 - by name, then by style\n" +
                "6 - by duration, then by name\n" +
                "7 - by duration, then by style\n" +
                "8 - by style, then by name\n" +
                "9 - by style, then by duration\n" +
                "0 - Don't sort\n");
        lastExecutionResult += "\nSort music tracks:\n" +
                "1 - by name\n" +
                "2 - by duration\n" +
                "3 - by style\n" +
                "4 - by name, then by duration\n" +
                "5 - by name, then by style\n" +
                "6 - by duration, then by name\n" +
                "7 - by duration, then by style\n" +
                "8 - by style, then by name\n" +
                "9 - by style, then by duration\n" +
                "0 - Don't sort\n\n";
    }

    private int getChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.print("NaN. Enter again: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    static String[] choices = new String[]{
            "by name",
            "by duration",
            "by style",
            "by name, then by duration",
            "by name, then by style",
            "by duration, then by name",
            "by duration, then by style",
            "by style, then by name",
            "by style, then by duration"
    };

    protected void perform(int userChoice) {
        Function<MusicTrack, String> name = MusicTrack::getName;
        Function<MusicTrack, Integer> duration = MusicTrack::getDurationInSeconds;
        Function<MusicTrack, String> style = MusicTrack::getStyle;
        if (userChoice >= 1 && userChoice <= 9)
            Logger.log("Sorting " + choices[userChoice - 1] + "...");
        switch (userChoice) {
            case 1:
                executor.sortDisc(name);
                break;
            case 2:
                executor.sortDisc(duration);
                break;
            case 3:
                executor.sortDisc(style);
                break;
            case 4:
                executor.sortDisc(name, duration);
                break;
            case 5:
                executor.sortDisc(name, style);
                break;
            case 6:
                executor.sortDisc(duration, name);
                break;
            case 7:
                executor.sortDisc(duration, style);
                break;
            case 8:
                executor.sortDisc(style, name);
                break;
            case 9:
                executor.sortDisc(style, duration);
                break;
            case 0:
                break;
            default:
                System.out.println("Wrong choice\nAuto choice: 0 - Don't sort");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Logger.log("ERROR: " + e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
                    EmailSender.sendError("ERROR: " + e.getMessage() + "\n" + Arrays.stream(e.getStackTrace()).map(i -> i + "\n").collect(Collectors.joining()));
                    e.printStackTrace();
                }
        }
        if (userChoice >= 1 && userChoice <= 9)
            lastExecutionResult += "Enter your choice: " + userChoice + '\n';
        if (userChoice != 0)
            Logger.log("Sorted.");
    }
}