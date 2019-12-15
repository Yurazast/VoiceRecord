package command;

import email.EmailSender;
import executor.Executor;
import log.Logger;
import music.Disc;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FindTrackLength implements Command {
    private Executor executor;
    private String lastExecutionResult;

    public FindTrackLength(Disc disc) {
        executor = new Executor(disc);
    }

    @Override
    public void execute() {
        executor.print(executor.findTrackLengthInRange(new Scanner(System.in)));
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
        return "FindTrackLength";
    }
}
