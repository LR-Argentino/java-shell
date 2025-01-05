import java.util.Scanner;

enum Commands {
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
           }

           System.out.print(input + ": command not found\n");
           System.out.print("$ ");
        }

    }
}
