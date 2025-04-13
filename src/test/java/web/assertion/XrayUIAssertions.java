package web.assertion;

import static com.google.common.truth.Truth.assertWithMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class XrayUIAssertions {
    private final Logger logger = LoggerFactory.getLogger(XrayUIAssertions.class);

    public void verifyPolicyViolationsBelowHighAreNotReported(Map<String, Integer> severityCounts) {
        assertWithMessage("Policy violations are not as per defined severity")
                .that(severityCounts.get("Medium"))
                .isEqualTo(0);
        assertWithMessage("Policy violations are not as per defined severity")
                .that(severityCounts.get("Low"))
                .isEqualTo(0);
        assertWithMessage("Policy violations are not as per defined severity")
                .that(severityCounts.get("Unknown"))
                .isEqualTo(0);
        logger.info("✅ Policy violations are as per defined severity");
    }
}
