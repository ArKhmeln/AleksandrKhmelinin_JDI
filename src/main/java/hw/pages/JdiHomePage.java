package hw.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Label;
import hw.entities.Users;
import hw.forms.JdiLoginForm;
import org.hamcrest.Matchers;

public class JdiHomePage extends WebPage {

    private JdiLoginForm loginForm;

    @Css("#user-name")
    private Label userName;

    @Css(".profile-photo")
    private Button profilePhoto;

    @XPath("//header//a[contains (., 'Metals & Colors')]")
    private Button metalsAndColors;

    public void login(Users user) {
        profilePhoto.click();
        loginForm.login(user);
    }

    public void checkLoggedIn(Users user) {
        userName.shouldBe().text(Matchers.equalTo(user.getFullName()));
    }

    public void goToMetalsAndColorsPage() {
        metalsAndColors.click();
    }
}
