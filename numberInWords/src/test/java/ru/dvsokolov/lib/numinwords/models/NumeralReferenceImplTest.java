package ru.dvsokolov.lib.numinwords.models;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Класс NumeralReferenceImpl")
class NumeralReferenceImplTest {

    private final static String[] DOUBLE_DIGITS_M = new String[] {"один", "два", "три", "четыре"};
    private final static String[] DOUBLE_DIGITS_F = new String[] {"одна", "две", "три", "четыре"};
    private final static String[] HUNDREDS = new String[] {"сто", "двести", "триста", "четыреста"};
    private final static String[][] POLY_DIGITS = {
            {"", "", "", ""},
            {"тысяча", "тысячи", "тысяча", "тысяч"},
            {"миллион", "миллионов", "миллион", "миллиона"}
    };

    private NumeralReference numeralReference;

    @BeforeEach
    void setUp() {
        numeralReference = new NumeralReferenceImpl();
        numeralReference.setDoubleDigitsM(DOUBLE_DIGITS_M);
        numeralReference.setDoubleDigitsF(DOUBLE_DIGITS_F);
        numeralReference.setHundreds(HUNDREDS);
        numeralReference.setPolyDigits(POLY_DIGITS);
    }


    @DisplayName("должен возвращать значение поля doubleDigitsM при вызове метода getDoubleDigitsM")
    @Test
    void shouldReturnValueOfDoubleDigitsMFromGetDoubleDigitsMMethod() {

        String[] expectedStringArray = DOUBLE_DIGITS_M;
        String[] actualStringArray = numeralReference.getDoubleDigitsM();

        Assertions.assertThat(actualStringArray).isEqualTo(expectedStringArray);
    }

    @DisplayName("должен возвращать значение поля doubleDigitsF при вызове метода getDoubleDigitsF")
    @Test
    void shouldReturnValueOfDoubleDigitsFFromGetDoubleDigitsFMethod() {

        String[] expectedStringArray = DOUBLE_DIGITS_F;
        String[] actualStringArray = numeralReference.getDoubleDigitsF();

        Assertions.assertThat(actualStringArray).isEqualTo(expectedStringArray);
    }

    @DisplayName("должен возвращать значение поля hundreds при вызове метода getHundreds")
    @Test
    void shouldReturnValueOfHundredsFromGetHundredsMethod() {

        String[] expectedStringArray = HUNDREDS;
        String[] actualStringArray = numeralReference.getHundreds();

        Assertions.assertThat(actualStringArray).isEqualTo(expectedStringArray);
    }

    @DisplayName("должен возвращать значение поля polyDigits при вызове метода getPolyDigits")
    @Test
    void shouldReturnValueOfPolyDigitsFromGetPolyDigitsMethod() {

        String[][] expectedStringArray = POLY_DIGITS;
        String[][] actualStringArray = numeralReference.getPolyDigits();

        Assertions.assertThat(actualStringArray).isEqualTo(expectedStringArray);
    }

}