import commandmanager.execution.CommandExecutorService;

import java.io.IOException;
import java.util.Scanner;

public class Shell implements ShellService {
    private final CommandExecutorService cmdExecuter;

    public Shell(CommandExecutorService cmdExecuter) {
        this.cmdExecuter = cmdExecuter;
    }

    @Override
    public void run() throws IOException {
        System.out.print("$ ");
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            this.cmdExecuter.execute(input);
        }
    }
}
