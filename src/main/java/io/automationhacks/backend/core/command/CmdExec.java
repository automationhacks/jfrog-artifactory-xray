package io.automationhacks.backend.core.command;

import org.slf4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CmdExec {
    private final Logger logger = org.slf4j.LoggerFactory.getLogger(CmdExec.class);

    public boolean runCommand(String command) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder();

            // Use "cmd", "/c" for Windows
            processBuilder.command("bash", "-c", command);
            processBuilder.redirectErrorStream(true);

            Process process = processBuilder.start();
            try (BufferedReader reader =
                    new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    logger.info(line);
                }
            }

            int exitCode = process.waitFor();
            return exitCode == 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
