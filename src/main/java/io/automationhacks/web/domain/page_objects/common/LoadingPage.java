package io.automationhacks.web.domain.page_objects.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class LoadingPage {
    private final WebDriver driver;
    private final Logger logger = LoggerFactory.getLogger(LoadingPage.class);

    public LoadingPage(WebDriver driver) {
        this.driver = driver;
    }

    private final String poundingHeartContainerClass = "pounding-heart-container";

    public void waitForAnimationToFinish() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(
                ExpectedConditions.invisibilityOfElementLocated(
                        By.className(poundingHeartContainerClass)));
        logger.info("✅ Animation finished");
    }
}
