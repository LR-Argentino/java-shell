package shell.commandmanager.execution;

import shell.commandmanager.services.CommandManagerService;
import shell.commandmanager.services.ExternalCommandManagerService;
import shell.commands.CommandService;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Executor implements ExecutorService {
    private final CommandManagerService commandManagerService;
    private final ExternalCommandManagerService externalCommandManagerService;

    public Executor(CommandManagerService commandManagerService, ExternalCommandManagerService externalCommandManagerService) {
        this.commandManagerService = commandManagerService;
        this.externalCommandManagerService = externalCommandManagerService;
    }

    @Override
    public void execute(String input) throws IOException {
        String[] parts = input.trim().split(" ");
        String command = parts[0];
        String arguments = parts.length > 1 ? input.substring(input.indexOf(" ") + 1) : "";
        CommandService cmd = commandManagerService.getCommand(command);

        if (cmd == null) {
            executeShellScript(command, arguments);
        } else {
            cmd.execute(arguments);
        }

        System.out.print("$ ");
    }

    private void executeShellScript(String scriptName, String args) throws IOException {
        try {
            File shellScript = this.externalCommandManagerService.getShellScript(scriptName);

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
