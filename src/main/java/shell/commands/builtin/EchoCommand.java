package shell.commands.builtin;

import shell.commands.CommandService;

public class EchoCommand implements CommandService {
    @Override
    public void execute(String arguments) {
        System.out.println(arguments);
    }
}
