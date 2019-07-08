package hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Text;
import hw7.entities.MetalsAndColorsData;
import hw7.enums.Result;
import hw7.forms.MetalsAndColorsForm;
import org.hamcrest.Matchers;

public class MetalsAndColorsPage extends WebPage {

    MetalsAndColorsForm metalsAndColorsForm;

    @Css("#submit-button")
    private Button submit;

    @XPath("//ul[@class='panel-body-list results']")
    private static Text result;

    // TODO You have a mismatch between method's name and what it does  -fixed
    public void fillInFormAndSubmit(MetalsAndColorsData data) {
        metalsAndColorsForm.fillInForm(data);
        submit.click();
    }

    public void assertResultSectionContainsData(MetalsAndColorsData data) {
        result.shouldBe().text(Matchers.containsString(Result.SUMMARY.getText() + data.calculateSummary()));
        result.shouldBe().text(Matchers.containsString(Result.ELEMENTS.getText() + data.getElementsString()));
        result.shouldBe().text(Matchers.containsString(Result.COLOR.getText() + data.getColors()));
        result.shouldBe().text(Matchers.containsString(Result.METAL.getText() + data.getMetals()));
        result.shouldBe().text(Matchers.containsString(Result.VEGETABLES.getText() + data.getVegetablesString()));
    }
}
