package io.automationhacks.web.domain.page_objects.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;

    private final String userNameTextBoxCss = "input[name='username']";
    private final String passwordTextBoxCss = "input[name='password']";
    private final String loginButtonCss = ".el-p-form-item__content > button";
    private final String welcomeBannerLabelClass = "login-form-title";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(userNameTextBoxCss)));

        var userName = driver.findElement(By.cssSelector(userNameTextBoxCss));
        userName.sendKeys(username);

        var passwordTextBox = driver.findElement(By.cssSelector(passwordTextBoxCss));
        passwordTextBox.sendKeys(password);

        var loginButton = driver.findElement(By.cssSelector(loginButtonCss));
        loginButton.click();
    }

    public void waitForLoginPageToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.className(welcomeBannerLabelClass)));
    }
}
