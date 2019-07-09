package hw.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class MetalsAndColorsData {

    //for hw7 test replace class with enum, uncomment next line and comment hw8 test
    //DATA(Arrays.asList(3, 8), Arrays.asList("Water", "Fire"), "Red", "Selen", Arrays.asList("Cucumber", "Tomato"));

    private final List<Integer> summary;
    private final List<String> elements;
    private final String color;
    private final String metals;
    private final List<String> vegetables;

    public int calculateSummary() {
        return getSummary().stream()
                .mapToInt(Integer::intValue)
                .sum();
//        int sum = 0;
//        for(Integer number: getSummary()) {
//            sum += number;
//        }
//        return sum;
    }

    public String getElementsString() {
//      TODO Take a look on String::join method     -fixed
        return String.join(", ", getElements());
    }

    public String getVegetablesString() {
        return String.join(", ", getVegetables());
    }
}
