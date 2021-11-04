package ru.dvsokolov.lib.numinwords.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Класс UtilityForDoubleDigitsImpl")
class UtilityForDoubleDigitsImplTest {

    private static final String[] STRING_ARRAY = new String[] {"рубль", "рублей", "рубль", "рубля"};

    private UtilityForDoubleDigits utilityForDoubleDigits;

    @BeforeEach
    void setUp() {
        utilityForDoubleDigits = new UtilityForDoubleDigitsImpl();
    }

    @DisplayName("должен возвращать корректный падеж и(или) число существительного при заданном количестве (0)")
    @Test
    void shouldReturnCorrectTextForSetValue_0() {

        String expectedString = "рублей";
        String actualString = utilityForDoubleDigits.getText(0,STRING_ARRAY);

        Assertions.assertThat(actualString).isEqualTo(expectedString);
    }

    @DisplayName("должен возвращать корректный падеж и(или) число существительного при заданном количестве (1)")
    @Test
    void shouldReturnCorrectTextForSetValue_1() {

        String expectedString = "рубль";
        String actualString = utilityForDoubleDigits.getText(1,STRING_ARRAY);

        Assertions.assertThat(actualString).isEqualTo(expectedString);
    }

    @DisplayName("должен возвращать корректный падеж и(или) число существительного при заданном количестве (4)")
    @Test
    void shouldReturnCorrectTextForSetValue_4() {

        String expectedString = "рубля";
        String actualString = utilityForDoubleDigits.getText(4,STRING_ARRAY);

        Assertions.assertThat(actualString).isEqualTo(expectedString);
    }

    @DisplayName("должен возвращать корректный падеж и(или) число существительного при заданном количестве (5)")
    @Test
    void shouldReturnCorrectTextForSetValue_5() {

        String expectedString = "рублей";
        String actualString = utilityForDoubleDigits.getText(5,STRING_ARRAY);

        Assertions.assertThat(actualString).isEqualTo(expectedString);
    }

    @DisplayName("должен возвращать корректный падеж и(или) число существительного при заданном количестве (12)")
    @Test
    void shouldReturnCorrectTextForSetValue_12() {

        String expectedString = "рублей";
        String actualString = utilityForDoubleDigits.getText(12,STRING_ARRAY);

        Assertions.assertThat(actualString).isEqualTo(expectedString);
    }

}