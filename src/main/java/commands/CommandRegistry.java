package commands;

import java.util.HashMap;

public class CommandRegistry {
    private final HashMap<String, Command> commands = new HashMap<>();

    public CommandRegistry() {
        commands.put("exit", new ExitCommand());
        commands.put("echo", new EchoCommand());
        commands.put("type", new TypeCommand());
    }

    public Command getCommand(String commandName) {
        return commands.getOrDefault(commandName, null);
    }
}
