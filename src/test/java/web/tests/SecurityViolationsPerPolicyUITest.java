package web.tests;

import io.automationhacks.backend.core.env.Environment;
import io.automationhacks.backend.core.utils.StringUtils;
import io.automationhacks.common.testing.TestSuites;
import io.automationhacks.web.core.constant.Browser;
import io.automationhacks.web.core.driver.DriverFactory;
import io.automationhacks.web.domain.constants.PageUrls;
import io.automationhacks.web.domain.page_objects.common.LoadingPage;
import io.automationhacks.web.domain.page_objects.xray.scans_list.ArtifactsPage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import web.assertion.XrayUIAssertions;
import web.helper.JFrogWebHelper;

public class SecurityViolationsPerPolicyUITest {
    private final WebDriver driver = new DriverFactory(Browser.CHROME).getDriver();
    private final String jFrogUI = Environment.getJFrogUI();
    private final JFrogWebHelper jFrogWebHelper = new JFrogWebHelper();
    private String repoKey;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver.get(jFrogUI);

        var loadingPage = new LoadingPage(driver);
        loadingPage.waitForAnimationToFinish();

        repoKey = "docker-local-%s".formatted(StringUtils.getRandomString());
        new JFrogWebHelper().setUpRepoPolicyAndWatches(repoKey);
    }

    @Test(
            groups = {TestSuites.WEB_UI, TestSuites.REGRESSION},
            description =
                    """
                GIVEN watch and policy is created
                WHEN scan is opened
                THEN policy violations should only have critical and high severity
                """)
    public void
            givenWatchAndPolicyIsCreated_WhenScanIsOpened_ThenPolicyViolationsShouldOnlyHaveCriticalAndHigh()
                    throws InterruptedException {
        jFrogWebHelper.loginToJFrog(driver);

        String url = PageUrls.XRAY_SCAN_LIST.formatted(jFrogUI, repoKey);
        driver.get(url);

        var artifactsPage = new ArtifactsPage(driver);
        artifactsPage.clickOnVulnerabilities();

        var severityCounts = artifactsPage.getPolicyViolations();
        XrayUIAssertions xrayUIAssertions = new XrayUIAssertions();
        xrayUIAssertions.verifyPolicyViolationsBelowHighAreNotReported(severityCounts);
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        driver.close();
        driver.quit();
    }
}
