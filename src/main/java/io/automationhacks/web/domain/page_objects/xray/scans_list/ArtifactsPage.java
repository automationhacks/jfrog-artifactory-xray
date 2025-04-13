package io.automationhacks.web.domain.page_objects.xray.scans_list;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    private final String vulnerabilityLabelCss = ".legend-item-label";
    private final String vulnerabilityValueCss = ".legend-item-value";

    public void clickOnVulnerabilities(String path) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(xRayIssuesBtnCss)));

        var xrayIssues = driver.findElement(By.cssSelector(xRayIssuesBtnCss));
        xrayIssues.click();
    }

    public Map<String, Integer> getPolicyViolations() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String vulnerabilityContainerClass = "[data-cy='scansListOverviewPolicyViolations']";
        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector(vulnerabilityContainerClass)));

        List<WebElement> legendItems =
                driver.findElements(By.cssSelector(vulnerabilityContainerClass));

        Map<String, Integer> severityCounts = new HashMap<>();

        for (WebElement item : legendItems) {
            WebElement labelElement = item.findElement(By.cssSelector(vulnerabilityLabelCss));
            WebElement valueElement = item.findElement(By.cssSelector(vulnerabilityValueCss));

            String severity = labelElement.getText().trim();
            int count = Integer.parseInt(valueElement.getText().trim());

            severityCounts.put(severity, count);
        }
        logger.info("Policy violations: {}", severityCounts);
        return severityCounts;
    }
}
