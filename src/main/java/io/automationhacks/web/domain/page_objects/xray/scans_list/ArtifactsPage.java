package io.automationhacks.web.domain.page_objects.xray.scans_list;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArtifactsPage {
    private final WebDriver driver;

    public ArtifactsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnVulnerabilities(String path) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("div[row-id='%s']".formatted(path))));
        var row = driver.findElements(By.cssSelector("div[row-id='%s']".formatted(path))).get(0);
        row.click();
    }

    public Map<String, Integer> getPolicyViolations() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> legendItems =
                wait.until(
                        ExpectedConditions.presenceOfAllElementsLocatedBy(
                                By.cssSelector(".legend-item")));

        Map<String, Integer> severityCounts = new HashMap<>();

        for (WebElement item : legendItems) {
            WebElement labelElement = item.findElement(By.cssSelector(".legend-item-label"));
            WebElement valueElement = item.findElement(By.cssSelector(".legend-item-value"));

            String severity = labelElement.getText().trim();
            int count = Integer.parseInt(valueElement.getText().trim());

            severityCounts.put(severity, count);
        }
        return severityCounts;
    }
}
