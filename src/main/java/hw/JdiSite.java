package hw;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import hw.pages.JdiHomePage;
import hw.pages.MetalsAndColorsPage;

@JSite("https://epam.github.io/JDI/")
public class JdiSite {

    @Url("index.html")
    @Title("Home Page")
    public static JdiHomePage homePage;

    @Url("metals-color.html")
    @Title("Metal And Colors")
    public static MetalsAndColorsPage metalsAndColorsPage;

    public static void open() {
        homePage.open();
    }
}
