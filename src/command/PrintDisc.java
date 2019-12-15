package command;

import email.EmailSender;
import executor.Executor;
import log.Logger;
import music.Disc;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PrintDisc implements Command {
    private Executor executor;
    private String lastExecutionResult;

    public PrintDisc(Disc disc) {
        executor = new Executor(disc);
    }

    @Override
    public void execute() {
        executor.printDisk();
        lastExecutionResult = executor.lastExecutionResult;
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

    @Override
    public String getName() {
        return "Print";
    }
}
