package ru.dvsokolov.lib.numinwords.models;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Класс CurrencyReferenceImpl")
class CurrencyReferenceImplTest {

    private final static String[] NAMES = new String[] {"доллар", "долларов", "доллар", "доллара"};
    private final static String GENDER = "m";

    private CurrencyReference currencyReference;

    @BeforeEach
    void setUp() {
        currencyReference = new CurrencyReferenceImpl();
        currencyReference.setGender(GENDER);
        currencyReference.setNames(NAMES);
    }

    @DisplayName("должен возвращать значение поля gender при вызове метода getGender")
    @Test
    void shouldReturnValueOfGenderFromGetGenderMethod() {

        String expectedString = GENDER;
        String actualString = currencyReference.getGender();

        Assertions.assertThat(actualString).isEqualTo(expectedString);
    }

    @DisplayName("должен возвращать значение поля names при вызове метода getNames")
    @Test
    void shouldReturnValueOfNamesFromGetNamesMethod() {

        String[] expectedStringArray = NAMES;
        String[] actualStringArray = currencyReference.getNames();

        Assertions.assertThat(actualStringArray).isEqualTo(expectedStringArray);
    }

}