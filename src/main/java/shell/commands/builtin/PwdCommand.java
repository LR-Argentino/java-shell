package shell.commands.builtin;

import shell.commands.CommandService;

public class PwdCommand implements CommandService {
    private final String CURRENT_DIRECTORY = "user.dir";

    @Override
    public void execute(String arguments) {
        if (!arguments.isBlank()) {
            System.out.println("Invalid arguments: " + arguments);
            return;
        }
        String currentDirectory = System.getProperty(CURRENT_DIRECTORY);
        System.out.println(currentDirectory);
    }
}
