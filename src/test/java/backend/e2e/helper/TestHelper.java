package backend.e2e.helper;

import io.automationhacks.backend.core.command.CmdExec;

import org.slf4j.Logger;

public class TestHelper {
    private final Logger logger = org.slf4j.LoggerFactory.getLogger(TestHelper.class);

    public void pushImageToRepository(String repoKey, String imageName) {
        String[] commands = {
            "docker pull %s".formatted(imageName),
            "docker login https://automationhacks.jfrog.io",
            "docker tag alpine:3.9 automationhacks.jfrog.io/%s/%s".formatted(repoKey, imageName),
            "docker push automationhacks.jfrog.io/%s/%s".formatted(repoKey, imageName)
        };

        var commandExec = new CmdExec();
        for (String command : commands) {
            logger.info("Running: %s".formatted(command));
            boolean success = commandExec.runCommand(command);

            if (success) {
                logger.info("Command succeeded: %s".formatted(command));
            } else {
                logger.info("Command failed: %s".formatted(command));
            }
        }
    }
}
