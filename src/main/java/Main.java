import commands.CommandRegistry;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
            Shell shell = new Shell(new CommandRegistry());

            shell.run();
    }

}
