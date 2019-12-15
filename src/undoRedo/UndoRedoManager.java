package undoRedo;

import command.Command;
import email.EmailSender;
import log.Logger;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class UndoRedoManager {
    private static Stack<Command> undoStack;
    private static Stack<Command> redoStack;
    public String lastExecutionResult;

    public UndoRedoManager() {
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    public String getUndoName() {
        if (undoStack.empty())
            return "";
        return undoStack.peek().getName();
    }

    public String getRedoName() {
        if (redoStack.empty())
            return "";
        return redoStack.peek().getName();
    }

    public void execute(Command command) {
        undoStack.push(command);
        command.execute();
        redoStack.clear();
        lastExecutionResult = command.getLastExecutionResult();
    }

    public void undo() {
        if (!undoStack.empty()) {
            Command command = undoStack.pop();
            command.unExecute();
            redoStack.push(command);
            Logger.log("Undo: " + command.getName());
            lastExecutionResult = command.getLastExecutionResult();
        }
    }

    public void redo() {
        if (!redoStack.empty()) {
            Command command = redoStack.pop();
            command.execute();
            undoStack.push(command);
            Logger.log("Redo: " + command.getName());
            lastExecutionResult = command.getLastExecutionResult();
        }
    }

    public void undoList() {
        if (undoStack.empty())
            System.out.println("empty");
        else {
            lastExecutionResult = "";
            System.out.println("Undo list:");
            lastExecutionResult += "Undo list:\n";
            Logger.log("Printing undo list...");
            undoStack.forEach(us -> System.out.println('\t' + us.getName()));
            undoStack.forEach(us -> lastExecutionResult += '\t' + us.getName() + '\n');
            Logger.log("Printed.");
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Logger.log("ERROR: " + e.getMessage() + "\n" + Arrays.stream(e.getStackTrace()).map(i -> i + "\n").collect(Collectors.joining()));
            EmailSender.sendError("ERROR: " + e.getMessage() + "\n" + Arrays.stream(e.getStackTrace()).map(i -> i + "\n").collect(Collectors.joining()));
            e.printStackTrace();
        }
    }

    public void redoList() {
        if (redoStack.empty())
            System.out.println("empty");
        else{
            lastExecutionResult = "";
            System.out.println("Redo list:");
            lastExecutionResult += "Redo list:\n";
            Logger.log("Printing redo list...");
            redoStack.forEach(rs -> System.out.println('\t' + rs.getName()));
            redoStack.forEach(rs -> lastExecutionResult += '\t' + rs.getName() + '\n');
            Logger.log("Printed.");
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Logger.log("ERROR: " + e.getMessage() + "\n" + Arrays.stream(e.getStackTrace()).map(i -> i + "\n").collect(Collectors.joining()));
            EmailSender.sendError("ERROR: " + e.getMessage() + "\n" + Arrays.stream(e.getStackTrace()).map(i -> i + "\n").collect(Collectors.joining()));
            e.printStackTrace();
        }
    }
}