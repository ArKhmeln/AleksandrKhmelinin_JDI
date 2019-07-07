package hw7.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Result {

    SUMMARY("Summary: "),
    ELEMENTS("Elements: "),
    COLOR("Color: "),
    METAL("Metal: "),
    VEGETABLES("Vegetables: ");

    final String text;
}
