package shell.commandmanager;

import shell.commandmanager.services.ExternalCommandManagerService;
import shell.commandmanager.utils.ExecutableFinderService;

import java.io.File;

public class ExternalCommandManager implements ExternalCommandManagerService {
    private final ExecutableFinderService finderService;

    public ExternalCommandManager(ExecutableFinderService finderService) {
        this.finderService = finderService;
    }

    @Override
    public File getShellScript(String scriptName) {
        return this.finderService.findExecutable(scriptName);
   }
}
