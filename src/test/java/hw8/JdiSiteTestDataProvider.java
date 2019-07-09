package hw8;

import base.BaseTest;
import com.epam.jdi.light.elements.composite.WebPage;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import hw7.JdiSite;
import hw7.entities.MetalsAndColorsData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;


public class JdiSiteTestDataProvider extends BaseTest {

    @DataProvider
    public Object[][] getJsonDataSet() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader(dataSetPath));
        Map<String, MetalsAndColorsData> testData = new Gson()
                .fromJson(jsonData, new TypeToken<Map<String, MetalsAndColorsData>>(){}.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (String each : testData.keySet()) {
            returnValue[index][0] = testData.get(each);
            index++;
        }
        return returnValue;
    }

    @Test(dataProvider = "getJsonDataSet")
    public void metalsAndColorsDataSetTests(MetalsAndColorsData data) {
        JdiSite.metalsAndColorsPage.fillInFormAndSubmit(data);
        JdiSite.metalsAndColorsPage.assertResultSectionContainsData(data);
        WebPage.refresh();
    }
}
