package shell.commandmanager.services;

import shell.commands.CommandService;

public interface CommandManagerService {
    void registerCommand(String commandName, CommandService commandService);
    CommandService getCommand(String commandName);
}
