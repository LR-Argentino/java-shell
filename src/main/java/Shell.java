import commands.CommandService;
import commandmanager.CommandManagerService;

import java.util.Scanner;

public class Shell {
    private final CommandManagerService commandManagerService;

    public Shell(CommandManagerService commandManagerService) {
        this.commandManagerService = commandManagerService;
    }

    public void run() {
        System.out.print("$ ");
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            String command = parts[0];
            String arguments = input.substring(input.indexOf(" ") + 1);
            CommandService cmd = commandManagerService.getCommand(command);

            if (cmd == null) {
                System.out.print(command + ": command not found\n");
            } else {
                cmd.execute(arguments);
            }

            System.out.print("$ ");
        }
    }
}
