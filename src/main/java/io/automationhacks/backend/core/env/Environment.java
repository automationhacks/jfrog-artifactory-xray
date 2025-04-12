package io.automationhacks.backend.core.env;

import java.util.Properties;

public class Environment {
    public static final Properties properties = new Properties();

    static {
        try {
            properties.load(
                    Environment.class.getClassLoader().getResourceAsStream("stage.properties"));
        } catch (Exception e) {
            throw new RuntimeException("Failed to load application.properties", e);
        }
    }

    public static String getUsername() {
        return System.getenv("JFROG_USERNAME");
    }

    public static String getPassword() {
        return System.getenv("JFROG_PASSWORD");
    }

    public static String getHostName() {
        return properties.getProperty("ARTIFACTORY_HOSTNAME");
    }

    public static String getJFrogUI() {
        return properties.getProperty("JFROG_UI");
    }
}
