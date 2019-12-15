package command;

public interface Command {
    String name = null;
    String lastExecutionResult = null;

    String getName();

    void execute();

    void unExecute();

    String getLastExecutionResult();
}
