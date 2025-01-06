package commands;

import commandmanager.CommandManagerService;

import java.io.File;

public class TypeCommand implements CommandService {
    private CommandManagerService manager;

    public TypeCommand(CommandManagerService manager) {
        this.manager = manager;
    }
    @Override
    public void execute(String arguments) {
        if (manager.getCommand(arguments) == null) {
            searchCommandInPath(arguments);
        }

         if (manager.getCommand(arguments) != null) {
            System.out.println(arguments + " is a shell builtin");
        }
    }

    private void searchCommandInPath(String commandName) {
        String path = System.getenv("PATH");
        String[] directories = path.split(":");
        Boolean commandExists = false;
        for (String directory : directories) {
            File file = new File(directory, commandName);
            if (file.canExecute()) {
                System.out.println(commandName + " is " + directory + "/" + commandName);
                commandExists = true;
                break;
            }
        }
        if (!commandExists) {
            System.out.print(commandName + ": command not found\n");
        }
    }
}
