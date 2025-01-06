package shell.commandmanager.services;

import java.io.File;

public interface ExternalCommandManagerService {
    File getShellScript(String scriptName);
}
