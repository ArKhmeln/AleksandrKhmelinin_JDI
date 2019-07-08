package hw7.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public enum MetalsAndColorsData {

    DATA(Arrays.asList(3, 8), Arrays.asList("Water", "Fire"), "Red", "Selen", Arrays.asList("Cucumber", "Tomato"));

    private final List<Integer> summary;
    private final List<String> elements;
    private final String colors;
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
