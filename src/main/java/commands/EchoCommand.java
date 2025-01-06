package commands;

public class EchoCommand implements CommandService {
    @Override
    public void execute(String arguments) {
        System.out.println(arguments);
    }
}
