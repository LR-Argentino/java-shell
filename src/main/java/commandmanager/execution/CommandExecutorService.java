package commandmanager.execution;

import java.io.IOException;

public interface CommandExecutorService {
    void execute(String command) throws IOException;
}
