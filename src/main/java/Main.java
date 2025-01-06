import commandmanager.CommandManager;
import commandmanager.CommandManagerService;
import commands.*;

public class Main {
    public static void main(String[] args) throws Exception {
        CommandManagerService commandManager = new CommandManager();
        CommandService echoCommand = new EchoCommand();
        CommandService typeCommand = new TypeCommand(commandManager);
        CommandService exitCommand = new ExitCommand();
        commandManager.registerCommand("echo", echoCommand);
        commandManager.registerCommand("type", typeCommand);
        commandManager.registerCommand("exit", exitCommand);
        Shell shell = new Shell(commandManager);

        shell.run();
    }

}
