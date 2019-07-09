package base;

import com.epam.jdi.light.driver.get.DriverData;
import hw.JdiSite;
import hw.entities.Users;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.ui.html.PageFactory.initElements;

public class BaseTest {

    protected static final String dataSetPath = "src/test/resources/JDI_ex8_metalsColorsDataSet.json";

    @BeforeClass
    public void beforeClass() {
        DriverData.CHROME_OPTIONS = () -> {
            ChromeOptions cap = new ChromeOptions();
            cap.addArguments("--start-maximized");
            return cap;
        };
        initElements(JdiSite.class);
        JdiSite.open();
        JdiSite.homePage.shouldBeOpened();
        JdiSite.homePage.login(Users.PETER);
        JdiSite.homePage.checkLoggedIn(Users.PETER);
        JdiSite.homePage.goToMetalsAndColorsPage();
    }

    @AfterClass
    public void afterClass() {
        killAllSeleniumDrivers();
    }
}
