package commandmanager;

import commands.CommandService;

import java.io.File;

public interface CommandManagerService {
    void registerCommand(String commandName, CommandService commandService);
    CommandService getCommand(String commandName);
    File getCommandFromPath(String command);
}
