package hw.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.TextField;
import hw.entities.Users;
import org.openqa.selenium.support.FindBy;

public class JdiLoginForm extends Form<Users> {

    @FindBy(css = "#name")
    private TextField login;

    @FindBy(css = "#password")
    private TextField password;

    @FindBy(css = "#login-button")
    private Button sumbit;

    @Override
    public void login(Users user) {
        login.input(user.getLogin());
        password.input(user.getPassword());
        sumbit.click();
    }
}
