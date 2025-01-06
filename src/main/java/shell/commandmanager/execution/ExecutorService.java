package shell.commandmanager.execution;

import java.io.IOException;

public interface ExecutorService {
    void execute(String command) throws IOException;
}
