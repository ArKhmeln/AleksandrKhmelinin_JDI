package hw.forms;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import hw.entities.MetalsAndColorsData;

public class MetalsAndColorsForm extends Form<MetalsAndColorsData> {

    @XPath("//p[contains(.//label, '%s')]")
    private RadioButtons summary;

    @XPath("//p[@class='checkbox'][contains(., '%s')]//label")
    private UIElement elements;

    @JDropdown(root = "div[ui=dropdown]",
            list = "li",
            expand = ".caret")
    private Droplist colors;

    @JDropdown(root = "div[ui=combobox]",
            list = "li",
            expand = ".caret")
    private Droplist metals;

    @JDropdown(root = "div[ui=droplist]",
            list = "li",
            expand = ".caret")
    private Droplist vegetables;

    public void fillInForm(MetalsAndColorsData data) {
        for (Integer number: data.getSummary()) {
            summary.select(String.valueOf(number));
        }
        for (String element: data.getElements()) {
            elements.select(element);
        }
        colors.select(data.getColor());
        metals.select(data.getMetals());
        selectVegetables(data);
    }

    private void selectVegetables(MetalsAndColorsData data) {
        if(!data.getVegetables().contains("Vegetables")) {
            vegetables.select("Vegetables");
        }
        for(String vegetable: data.getVegetables()) {
            if(!vegetable.equals("Vegetables")) {
                vegetables.select(vegetable);
            }
        }
    }
}
