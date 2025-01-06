package commands;

public class ExitCommand implements CommandService {
    @Override
    public void execute(String arguments) {
        System.exit(0);
    }
}
