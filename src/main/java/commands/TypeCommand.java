package commands;

public class TypeCommand implements Command {

    @Override
    public void execute(String arguments) {
        System.out.println(arguments + " is a shell builtin");
    }
}
