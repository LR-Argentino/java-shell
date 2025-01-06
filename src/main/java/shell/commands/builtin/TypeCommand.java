package shell.commands.builtin;

import shell.commandmanager.services.CommandManagerService;
import shell.commandmanager.services.ExternalCommandManagerService;
import shell.commands.CommandService;

import java.io.File;

public class TypeCommand implements CommandService {
    private CommandManagerService manager;
    private ExternalCommandManagerService externalManager;

    public TypeCommand(CommandManagerService manager, ExternalCommandManagerService externalManager) {
        this.manager = manager;
        this.externalManager = externalManager;
    }
    @Override
    public void execute(String arguments) {
        if (manager.getCommand(arguments) == null) {
            File commandFromPath = this.externalManager.getShellScript(arguments);

            if (commandFromPath != null) {
                System.out.println(arguments + " is " + commandFromPath.getAbsolutePath());
            } else {
                System.out.print(arguments + ": not found\n");
            }
        }

         if (manager.getCommand(arguments) != null) {
            System.out.println(arguments + " is a shell builtin");
        }
    }
}
