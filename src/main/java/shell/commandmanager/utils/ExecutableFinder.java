package shell.commandmanager.utils;

import java.io.File;

public class ExecutableFinder implements ExecutableFinderService {
    private final String UNIX_PATH_DIRECTORY_SEPERATOR = ":";
    private final String WINDOWS_PATH_DIRECTORY_SEPERATOR = ";";
    private final String PATH_ENV_VAR = "PATH";

    @Override
    public File findExecutable(String scriptName) {
        String path = System.getenv(PATH_ENV_VAR);
        if (path == null || path.isEmpty()) {
            return null;
        }

        for (String directory : path.split(UNIX_PATH_DIRECTORY_SEPERATOR)) {
            File file = new File(directory, scriptName);
            if (file.canExecute()) {
                return file;
            }
        }
        return null;
    }
}
