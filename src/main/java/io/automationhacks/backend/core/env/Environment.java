package io.automationhacks.backend.core.env;

public class Environment {
    public static String getUsername() {
        return System.getenv("JFROG_USERNAME");
    }

    public static String getPassword() {
        return System.getenv("JFROG_PASSWORD");
    }
}
