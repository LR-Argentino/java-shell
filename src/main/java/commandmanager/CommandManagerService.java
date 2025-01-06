package commandmanager;

import commands.CommandService;

public interface CommandManagerService {
    void registerCommand(String commandName, CommandService commandService);
    CommandService getCommand(String commandName);
}
