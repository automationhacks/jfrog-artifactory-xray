package io.automationhacks.backend.core.constants;

import io.automationhacks.backend.core.env.Environment;
import io.automationhacks.backend.core.model.BasicAuth;

public class Auth {
    public BasicAuth getCredentials() {
        return new BasicAuth(Environment.getUsername(), Environment.getPassword());
    }
}
