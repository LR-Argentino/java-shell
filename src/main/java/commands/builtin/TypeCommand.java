package commands.builtin;

import commandmanager.CommandManagerService;
import commands.CommandService;

import java.io.File;

public class TypeCommand implements CommandService {
    private CommandManagerService manager;

    public TypeCommand(CommandManagerService manager) {
        this.manager = manager;
    }
    @Override
    public void execute(String arguments) {
        if (manager.getCommand(arguments) == null) {
            File commandFromPath = manager.getCommandFromPath(arguments);

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
