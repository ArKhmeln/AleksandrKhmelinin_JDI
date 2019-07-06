package hw7;

import com.epam.jdi.light.driver.get.DriverData;
import hw7.entities.Users;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.ui.html.PageFactory.initElements;

public class JdiSiteTest {

    @BeforeClass
    public void beforeClass() {
        DriverData.CHROME_OPTIONS = () -> {
            ChromeOptions cap = new ChromeOptions();
            cap.addArguments("--start-maximized");
            return cap;
        };
        initElements(JdiSite.class);
    }

    @Test
    public void loginTest() {
        JdiSite.open();
        JdiSite.homePage.login(Users.PETER);
        JdiSite.homePage.checkLoggedIn(Users.PETER);
    }

    @AfterClass
    public void afterClass() {
        killAllSeleniumDrivers();
    }
}
