package command;

import email.EmailSender;
import executor.Executor;
import log.Logger;
import music.Disc;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FileInput implements Command {
    private Disc disc;
    private Disc previousDisc = new Disc();
    private Executor executor;
    private String lastExecutionResult;

    public FileInput(Disc disc) {
        this.disc = disc;
        this.previousDisc.setDisc(disc.getDisc());
        this.executor = new Executor(disc);
    }

    @Override
    public void execute() {
        executor.getMusicTracksFromFile();
        System.out.println("Disc has " + disc.getDisc().size() + " music tracks now");
        lastExecutionResult = "Disc has " + disc.getDisc().size() + " music tracks now\n";
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Logger.log("ERROR: " + e.getMessage() + "\n" + Arrays.stream(e.getStackTrace()).map(i -> i + "\n").collect(Collectors.joining()));
            EmailSender.sendError("ERROR: " + e.getMessage() + "\n" + Arrays.stream(e.getStackTrace()).map(i -> i + "\n").collect(Collectors.joining()));
            e.printStackTrace();
        }
    }

    @Override
    public void unExecute() {
        disc.setDisc(previousDisc.getDisc());
        System.out.println("Disc returned to previous state with number of music tracks - " + disc.getDisc().size());
        lastExecutionResult = "Disc returned to previous state with number of music tracks - " + disc.getDisc().size() + '\n';
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

    @Override
    public String getName() {
        return "FileInput";
    }
}
