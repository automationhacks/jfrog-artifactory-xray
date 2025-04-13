package io.automationhacks.web.core.driver;

import io.automationhacks.web.core.constant.Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    private final Browser browser;

    public DriverFactory(Browser browser) {
        this.browser = browser;
    }

    public WebDriver getDriver() {
        return switch (browser) {
            case CHROME:
                WebDriver driver = new ChromeDriver();
                driver.manage().window().maximize();
                yield driver;
        };
    }
}
