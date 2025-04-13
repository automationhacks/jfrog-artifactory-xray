package io.automationhacks.web.domain.page_objects.xray.scans_list;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArtifactsPage {
    private final Logger logger = LoggerFactory.getLogger(ArtifactsPage.class);
    private final WebDriver driver;

    public ArtifactsPage(WebDriver driver) {
        this.driver = driver;
    }

    private final String xRayIssuesBtnCss = "[data-cy='xray-issues-bar']";
    private final String policyViolationsSectionCss =
            "[data-cy='scansListOverviewPolicyViolations']";
    private final String severityLevelCss =
            "[data-cy='scansListOverviewPolicyViolations'] .legend-item .legend-item-label";
    private final String severityCountCss =
            "[data-cy='scansListOverviewPolicyViolations'] .legend-item .legend-item-value";

    public void clickOnVulnerabilities() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(visibilityOfElementLocated(By.cssSelector(xRayIssuesBtnCss)));

        var xrayIssues = driver.findElement(By.cssSelector(xRayIssuesBtnCss));
        xrayIssues.click();
        logger.info("✅ Clicked on Xray issues button");
    }

    public Map<String, Integer> getPolicyViolations() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(visibilityOfElementLocated(By.cssSelector(policyViolationsSectionCss)));
        Thread.sleep(5000);

        List<WebElement> legendItems = driver.findElements(By.cssSelector(severityLevelCss));
        List<WebElement> legendValues = driver.findElements(By.cssSelector(severityCountCss));

        Map<String, Integer> severityCounts = new HashMap<>();

        for (int i = 0; i < legendItems.size(); i++) {
            var severity = legendItems.get(i).getText().trim();
            var count = Integer.parseInt(legendValues.get(i).getText().trim());

            severityCounts.put(severity, count);
        }

        logger.info("✅ Policy violations detected: {}", severityCounts);
        return severityCounts;
    }
}
