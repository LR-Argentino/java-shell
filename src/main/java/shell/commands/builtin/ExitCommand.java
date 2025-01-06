package shell.commands.builtin;

import shell.commands.CommandService;

public class ExitCommand implements CommandService {
    @Override
    public void execute(String arguments) {
        System.exit(0);
    }
}
