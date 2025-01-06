package commandmanager.execution;

import commandmanager.CommandManagerService;
import commands.CommandService;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class CommandExecutor implements CommandExecutorService{
    private final CommandManagerService commandManagerService;

    public CommandExecutor(CommandManagerService commandManagerService) {
        this.commandManagerService = commandManagerService;
    }

    @Override
    public void execute(String input) throws IOException {
        String[] parts = input.split(" ");
        String command = parts[0];
        String arguments = input.substring(input.indexOf(" ") + 1);
        CommandService cmd = commandManagerService.getCommand(command);

        if (cmd == null) {
            executeShellScript(command, arguments);
//           System.out.print(command + ": command not found\n");
        } else {
            cmd.execute(arguments);
        }

        System.out.print("$ ");
    }

    private void executeShellScript(String scriptName, String args) throws IOException {
        try {
            File shellScript = this.commandManagerService.getCommandFromPath(scriptName);

            if (shellScript == null) {
                System.out.print(scriptName + ": command not found\n");
                return;
            }

            List<String> command = Arrays.asList(shellScript.getAbsolutePath(), args);

            // Prozess starten
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.directory(shellScript.getParentFile());
            processBuilder.redirectErrorStream(true);

            Process process = processBuilder.start();

            // Ausgabe lesen
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
            process.waitFor();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
