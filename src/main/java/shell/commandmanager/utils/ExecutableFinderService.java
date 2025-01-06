package shell.commandmanager.utils;

import java.io.File;

public interface ExecutableFinderService {
    File findExecutable(String scriptName);
}
