import commandmanager.CommandManager;
import commandmanager.CommandManagerService;
import commandmanager.execution.CommandExecutor;
import commandmanager.execution.CommandExecutorService;
import commands.*;
import commands.builtin.EchoCommand;
import commands.builtin.ExitCommand;
import commands.builtin.TypeCommand;

public class Main {
    public static void main(String[] args) throws Exception {
        CommandManagerService commandManager = new CommandManager();
        CommandExecutorService commandExecutor = new CommandExecutor(commandManager);
        CommandService echoCommand = new EchoCommand();
        CommandService typeCommand = new TypeCommand(commandManager);
        CommandService exitCommand = new ExitCommand();
        commandManager.registerCommand("echo", echoCommand);
        commandManager.registerCommand("type", typeCommand);
        commandManager.registerCommand("exit", exitCommand);
        Shell shell = new Shell(commandExecutor);

        shell.run();
    }

}
