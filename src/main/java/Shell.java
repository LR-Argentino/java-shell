import commands.Command;
import commands.CommandRegistry;

import java.util.Scanner;

public class Shell {
    private final CommandRegistry commandRegistry;

    public Shell(CommandRegistry commandRegistry) {
        this.commandRegistry = commandRegistry;
    }

    public void run() {
        System.out.print("$ ");
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            String command = parts[0];
            String arguments = input.substring(input.indexOf(" ") + 1);
            Command cmd = commandRegistry.getCommand(command);

            if (cmd == null) {
                System.out.print(cmd + ": command not found\n");
            } else if (command.equals("type")) {
                if (commandRegistry.getCommand(arguments) != null) {
                    cmd.execute(arguments);
                } else {
                    System.out.print(arguments + ": command not found\n");
                }
            }else {
                cmd.execute(arguments);
            }

            System.out.print("$ ");
        }
    }
}
