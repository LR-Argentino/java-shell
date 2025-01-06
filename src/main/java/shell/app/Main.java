package shell.app;

import shell.commandmanager.CommandManager;
import shell.commandmanager.services.CommandManagerService;
import shell.commandmanager.ExternalCommandManager;
import shell.commandmanager.services.ExternalCommandManagerService;
import shell.commandmanager.execution.Executor;
import shell.commandmanager.execution.ExecutorService;
import shell.commands.*;
import shell.commands.builtin.EchoCommand;
import shell.commands.builtin.ExitCommand;
import shell.commands.builtin.PwdCommand;
import shell.commands.builtin.TypeCommand;
import shell.core.Shell;
import shell.commandmanager.utils.ExecutableFinder;
import shell.commandmanager.utils.ExecutableFinderService;

public class Main {
    public static void main(String[] args) throws Exception {
        CommandManagerService commandManager = new CommandManager();
        ExecutableFinderService executableFinder = new ExecutableFinder();
        ExternalCommandManagerService externalCommandManager = new ExternalCommandManager(executableFinder);
        ExecutorService commandExecutor = new Executor(commandManager, externalCommandManager);

        CommandService echoCommand = new EchoCommand();
        CommandService typeCommand = new TypeCommand(commandManager, externalCommandManager);
        CommandService exitCommand = new ExitCommand();
        CommandService pwdCommand = new PwdCommand();

        commandManager.registerCommand("echo", echoCommand);
        commandManager.registerCommand("type", typeCommand);
        commandManager.registerCommand("exit", exitCommand);
        commandManager.registerCommand("pwd", pwdCommand);

        Shell shell = new Shell(commandExecutor);

        shell.run();
    }

}
