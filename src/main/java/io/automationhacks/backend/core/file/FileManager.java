package io.automationhacks.backend.core.file;

import java.io.IOException;

public class FileManager {
    public static String readFile(String filePath) {
        try (var inputStream =
                Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath)) {

            if (inputStream == null) {
                throw new IllegalArgumentException("File not found: %s".formatted(filePath));
            }
            return new String(inputStream.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: %s".formatted(filePath), e);
        }
    }
}
