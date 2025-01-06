package commandmanager;

import commands.CommandService;

import java.io.File;
import java.util.HashMap;

public class CommandManager implements CommandManagerService {
    private final HashMap<String, CommandService> commands = new HashMap<>();


    @Override
    public void registerCommand(String commandName, CommandService commandService) {
        commands.put(commandName, commandService);
    }

    @Override
    public CommandService getCommand(String commandName) {
        return commands.getOrDefault(commandName, null);
    }

    @Override
    public File getCommandFromPath(String command) {
        String path = System.getenv("PATH");
        String[] directories = path.split(":");

        if (path == null || path.isEmpty()) {
            return null;
        }

        for (String directory : directories) {
            File file = new File(directory, command);
            if (file.canExecute()) {
                return file;
            }
        }
        return null;
    }
}
