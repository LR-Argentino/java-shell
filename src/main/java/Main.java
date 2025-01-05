import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.print("$ ");

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
           String input = scanner.nextLine();
           String command = input.split(" ")[0];

           if (input.equals(Commands.EXIT.getCommand()) || input.equals(Commands.EXIT_ZERO.getCommand())) {
                break;
           } else if (command.equals(Commands.ECHO.getCommand())) {
               echo(input);
           } else if (command.equals(Commands.TYPE.getCommand())) {
               type(input);
           } else {
               System.out.print(input + ": command not found\n");
           }

           System.out.print("$ ");
        }
    }

    private static void echo(String input) {
        System.out.println(getRemainingWords(input));
    }

    private static void type(String input) {
        String remainingWords = getRemainingWords(input);
        Commands command = Commands.fromCommand(remainingWords);

        if (command != null) {
            System.out.println(command.getCommand() + " is a shell builtin");
        } else {
            System.out.print(remainingWords + ": command not found\n");
        }
    }

    private static String getRemainingWords(String input) {
        int firstSpaceIndex = input.indexOf(' ');

        if (firstSpaceIndex != 1) {
            String remainingWords = input.substring(firstSpaceIndex + 1);
            return remainingWords;
        }
        return "";
    }
}
