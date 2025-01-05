public enum Commands {
    EXIT("exit 0", "Beendet die Shell"),
    TYPE("type", "Ueberprueft ob der Wert ein builtin Befehl ist"),
    ECHO("echo", "Gibt eine Nachricht aus");


    private final String command;
    private final String description;

    Commands(String command, String description) {
        this.command = command;
        this.description = description;
    }

    public String getCommand() {
        return command;
    }

    public String getDescription() {
        return description;
    }

    public static Commands fromCommand(String input) {
        for (Commands cmd : Commands.values()) {
            if (cmd.command.equalsIgnoreCase(input)) {
                return cmd;
            }
        }
        return null;
    }
}
