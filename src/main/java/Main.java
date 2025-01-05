import java.util.Scanner;

enum Commands {
    ECHO("echo"),
    EXIT("exit 0");

    public final String label;

    private Commands(String label) {
        this.label = label;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
//         Uncomment this block to pass the first stage
        System.out.print("$ ");

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
           String input = scanner.nextLine();

           if (input.equals(Commands.EXIT.label)) {
                break;
           } else if (input.contains(Commands.ECHO.label)) {
               echo(input);
           } else {
               System.out.print(input + ": command not found\n");
           }

           System.out.print("$ ");
        }
    }

    private static void echo(String input) {
        int firstSpaceIndex = input.indexOf(' ');

        if (firstSpaceIndex != 1) {
            String remainingWords = input.substring(firstSpaceIndex + 1);
            System.out.println(remainingWords);
        } else {
            System.out.print(input + ": command not found\n");
        }
    }
}
