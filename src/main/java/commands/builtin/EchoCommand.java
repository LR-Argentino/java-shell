package commands.builtin;

import commands.CommandService;

public class EchoCommand implements CommandService {
    @Override
    public void execute(String arguments) {
        System.out.println(arguments);
    }
}
