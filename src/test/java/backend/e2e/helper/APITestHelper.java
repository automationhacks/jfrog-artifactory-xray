package backend.e2e.helper;

import static io.automationhacks.backend.core.object.Serialization.deserialize;

import io.automationhacks.backend.core.command.CmdExec;
import io.automationhacks.backend.domain.xray.client.XrayClient;
import io.automationhacks.backend.domain.xray.model.scan_status.response.ScanStatusResponse;

import org.awaitility.Awaitility;
import org.slf4j.Logger;

import java.util.concurrent.TimeUnit;

public class APITestHelper {
    private final Logger logger = org.slf4j.LoggerFactory.getLogger(APITestHelper.class);

    public void pushImageToRepository(
            String repoKey, String imageName, String tagName, String uri) {
        logger.info("Pushing image to repository: {}", repoKey);

        var protocolHostname = uri.split("://");
        var hostname = protocolHostname[1];

        var path = "%s/%s/%s".formatted(hostname, repoKey, imageName);
        logger.info("Image path: {}", path);

        String[] commands = {
            "docker pull %s".formatted(imageName),
            "docker login %s".formatted(uri),
            "docker tag %s %s".formatted(tagName, path),
            "docker push %s".formatted(path)
        };

        var commandExec = new CmdExec();
        for (String command : commands) {
            logger.info("Running command: {}", command);
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
