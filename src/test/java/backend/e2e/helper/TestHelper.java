package backend.e2e.helper;

import static io.automationhacks.backend.core.object.Serialization.deserialize;

import io.automationhacks.backend.core.command.CmdExec;
import io.automationhacks.backend.domain.xray.client.XrayClient;
import io.automationhacks.backend.domain.xray.model.scan_status.response.ScanStatusResponse;

import org.awaitility.Awaitility;
import org.slf4j.Logger;

import java.util.concurrent.TimeUnit;

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
            logger.info("Running: {}", command);
            boolean success = commandExec.runCommand(command);

            if (success) {
                logger.info("✅ Command succeeded: {}", command);
            } else {
                logger.info("❌ Command failed: {}", command);
            }
        }
    }

    public void waitForXRayScanToBeDone(String body) {
        var client = new XrayClient();

        Awaitility.await()
                .pollInterval(10, TimeUnit.SECONDS)
                .atMost(45, TimeUnit.MINUTES)
                .until(
                        () -> {
                            var response = client.getScanStatus(body);
                            var scanStatusResponseBody =
                                    deserialize(response.getBody(), ScanStatusResponse.class);
                            var status = scanStatusResponseBody.getOverall().getStatus();
                            return status.equals("DONE");
                        });
    }
}
