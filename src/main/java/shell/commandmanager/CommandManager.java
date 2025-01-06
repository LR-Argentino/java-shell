package shell.commandmanager;

import shell.commandmanager.services.CommandManagerService;
import shell.commands.CommandService;

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

}
