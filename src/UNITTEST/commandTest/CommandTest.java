package commandTest;

import command.Command;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(Parameterized.class)
public class CommandTest {
    public Command command;

    public CommandTest(Command command) {
        this.command = command;
    }

    @Test
    public void getName() {
        assertNotNull(command.getName());
        assertNull(Command.name);
    }

    @Test(timeout = 2500)
    public void execute() {
        command.execute();
    }

    @Test(timeout = 2500)
    public void unExecute() {
        command.unExecute();
    }

    @Test
    public void getLastExecutionResult() {
        assertNull(Command.lastExecutionResult);
    }

    @Parameterized.Parameters
    public static List<Command> instancesToTest() {
        return Arrays.asList(
                new FileInputTest().fi,
                new FindTrackLengthTest().ftl,
                new KeyboardInputTest().ki,
                new PrintDiscTest().pd,
                new SortDiscTest().sd
        );
    }
}