package web.assertion;

import static com.google.common.truth.Truth.assertWithMessage;

import java.util.Map;

public class XrayUIAssertions {
    public void verifyLoginPageBanner(String loginPageText) {
        assertWithMessage("Login page not displayed")
                .that(loginPageText.toLowerCase())
                .isEqualTo("Welcome to JFrog".toLowerCase());
    }

    public void verifyPolicyViolationsBelowHighAreNotReported(
            Map<String, Integer> severityCounts) {
        assertWithMessage("Policy violations are not as per defined severity")
                .that(severityCounts.get("Medium"))
                .isEqualTo(0);
        assertWithMessage("Policy violations are not as per defined severity")
                .that(severityCounts.get("Low"))
                .isEqualTo(0);
        assertWithMessage("Policy violations are not as per defined severity")
                .that(severityCounts.get("Unknown"))
                .isEqualTo(0);
    }
}
