import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
//         Uncomment this block to pass the first stage
        System.out.print("$ ");

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
           String input = scanner.nextLine();
           System.out.print(input + ": command not found\n");
           System.out.print("$ ");
        }

    }
}
