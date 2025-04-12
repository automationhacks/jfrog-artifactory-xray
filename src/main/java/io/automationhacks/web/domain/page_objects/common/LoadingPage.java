package io.automationhacks.web.domain.page_objects.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoadingPage {
    private final WebDriver driver;

    public LoadingPage(WebDriver driver) {
        this.driver = driver;
    }

    By poundingHeartContainer = By.className("pounding-heart-container");

    public void waitForAnimationToFinish() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(poundingHeartContainer));
    }
}
