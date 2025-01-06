package commands;

public class ExitCommand implements Command {
    @Override
    public void execute(String arguments) {
        System.exit(0);
    }
}
