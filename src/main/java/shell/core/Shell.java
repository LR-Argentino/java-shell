package shell.core;

import shell.commandmanager.execution.ExecutorService;

import java.io.IOException;
import java.util.Scanner;

public class Shell implements ShellService {
    private final ExecutorService cmdExecuter;

    public Shell(ExecutorService cmdExecuter) {
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
