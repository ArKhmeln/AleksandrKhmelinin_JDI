package hw7;

import base.BaseTest;
import hw7.entities.MetalsAndColorsData;
import hw7.entities.Users;
import org.testng.annotations.Test;

public class JdiSiteTest extends BaseTest {

    @Test
    public void metalsAndColorsTest() {
        JdiSite.open();
        JdiSite.homePage.shouldBeOpened();
        JdiSite.homePage.login(Users.PETER);
        JdiSite.homePage.checkLoggedIn(Users.PETER);
        JdiSite.homePage.goToMetalsAndColorsPage();
        JdiSite.metalsAndColorsPage.fillInFormAndSubmit(MetalsAndColorsData.DATA);
        JdiSite.metalsAndColorsPage.assertResultSectionContainsData(MetalsAndColorsData.DATA);
    }
}
