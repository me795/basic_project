package ru.dvsokolov.lib.numinwords.models;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.dvsokolov.lib.numinwords.enums.Currency;
import ru.dvsokolov.lib.numinwords.enums.Language;
import ru.dvsokolov.lib.numinwords.utils.ReferenceLoader;
import ru.dvsokolov.lib.numinwords.utils.ReferenceLoaderImpl;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Класс HundredOriginalNumberImpl")
class HundredOriginalNumberImplTest {

    private static final String TOO_SMALL_NUMBER = "1234";
    private static final String TOO_BIG_NUMBER = "1234";
    private static final String INCORRECT_NUMBER = "3f3";
    private static final String NEGATIVE_NUMBER = "-23";
    private static final String ONE_DIGIT_NUMBER = "003";
    private static final String TWO_DIGIT_NUMBER = "023";
    private static final String THREE_DIGIT_NUMBER = "122";


    private ReferenceLoader referenceLoader;
    private NumeralReference numeralReference;
    private CurrencyReference currencyReference;
    private Hundred hundred;

    @BeforeEach
    void setUp() {
        referenceLoader = new ReferenceLoaderImpl();
    }

    @DisplayName("должен возвращать целочисленное значение поля number при вызове метода getInt")
    @Test
    void shouldReturnIntValueOfNumberFromGetIntMethod() {

        numeralReference = Mockito.mock(NumeralReference.class);
        currencyReference = Mockito.mock(CurrencyReference.class);
        hundred = new HundredOriginalNumberImpl(currencyReference,numeralReference);
        hundred.setNumber(ONE_DIGIT_NUMBER);

        int expectedInt = 3;
        int actualInt = hundred.getInt();

        Assertions.assertThat(actualInt).isEqualTo(expectedInt);
    }

    @DisplayName("должен возвращать значение поля numeralReference при вызове метода getNumeralReference")
    @Test
    void shouldReturnValueOfNumeralReferenceFromGetNumeralReferenceMethod() {

        numeralReference = referenceLoader.getNumeralReference(Language.RU);
        currencyReference = Mockito.mock(CurrencyReference.class);
        hundred = new HundredOriginalNumberImpl(currencyReference,numeralReference);

        NumeralReference expectedObject = numeralReference;
        NumeralReference actualObject = hundred.getNumeralReference();

        Assertions.assertThat(actualObject).isEqualTo(expectedObject);
    }

    @DisplayName("должен возвращать значение поля currencyReference при вызове метода getCurrencyReference")
    @Test
    void shouldReturnValueOfCurrencyReferenceFromGetCurrencyReferenceMethod() {

        numeralReference = Mockito.mock(NumeralReference.class);
        currencyReference = referenceLoader.getCurrencyReference(Language.RU, Currency.RUB);
        hundred = new HundredOriginalNumberImpl(currencyReference,numeralReference);

        CurrencyReference expectedObject = currencyReference;
        CurrencyReference actualObject = hundred.getCurrencyReference();

        Assertions.assertThat(actualObject).isEqualTo(expectedObject);
    }


    @DisplayName("должен возвращать корректный текст для выбранныых значений (RU RUB 122 i=0)")
    @Test
    void shouldReturnCorrectTextForSelectedOptions_Ru_Rub_122_0() {

        numeralReference = referenceLoader.getNumeralReference(Language.RU);
        currencyReference = referenceLoader.getCurrencyReference(Language.RU,Currency.RUB);
        hundred = new HundredOriginalNumberImpl(currencyReference,numeralReference);
        hundred.setNumber(THREE_DIGIT_NUMBER);
        hundred.setIndex(0);
        String expectedString = "сто двадцать два ";
        String actualString = hundred.getText();

        Assertions.assertThat(actualString).isEqualTo(expectedString);
    }

    @DisplayName("должен возвращать корректный текст для выбранныых значений (RU RUB 122 i=1)")
    @Test
    void shouldReturnCorrectTextForSelectedOptions_Ru_Rub_122_1() {

        numeralReference = referenceLoader.getNumeralReference(Language.RU);
        currencyReference = referenceLoader.getCurrencyReference(Language.RU,Currency.RUB);
        hundred = new HundredOriginalNumberImpl(currencyReference,numeralReference);
        hundred.setNumber(THREE_DIGIT_NUMBER);
        hundred.setIndex(1);
        String expectedString = "сто двадцать две тысячи ";
        String actualString = hundred.getText();

        Assertions.assertThat(actualString).isEqualTo(expectedString);
    }

    @DisplayName("должен возвращать корректный текст для выбранныых значений (RU RUB 122 i=2)")
    @Test
    void shouldReturnCorrectTextForSelectedOptions_Ru_Rub_122_2() {

        numeralReference = referenceLoader.getNumeralReference(Language.RU);
        currencyReference = referenceLoader.getCurrencyReference(Language.RU,Currency.RUB);
        hundred = new HundredOriginalNumberImpl(currencyReference,numeralReference);
        hundred.setNumber(THREE_DIGIT_NUMBER);
        hundred.setIndex(2);
        String expectedString = "сто двадцать два миллиона ";
        String actualString = hundred.getText();

        Assertions.assertThat(actualString).isEqualTo(expectedString);
    }

    @DisplayName("должен возвращать корректный текст для выбранныых значений (RU RUB 23 i=2)")
    @Test
    void shouldReturnCorrectTextForSelectedOptions_Ru_Rub_23_2() {

        numeralReference = referenceLoader.getNumeralReference(Language.RU);
        currencyReference = referenceLoader.getCurrencyReference(Language.RU,Currency.RUB);
        hundred = new HundredOriginalNumberImpl(currencyReference,numeralReference);
        hundred.setNumber(TWO_DIGIT_NUMBER);
        hundred.setIndex(2);
        String expectedString = "двадцать три миллиона ";
        String actualString = hundred.getText();

        Assertions.assertThat(actualString).isEqualTo(expectedString);
    }

    @DisplayName("должен возвращать корректный текст для выбранныых значений (RU YEN 122 i=0)")
    @Test
    void shouldReturnCorrectTextForSelectedOptions_Ru_Yen_122_0() {

        numeralReference = referenceLoader.getNumeralReference(Language.RU);
        currencyReference = referenceLoader.getCurrencyReference(Language.RU,Currency.YEN);
        hundred = new HundredOriginalNumberImpl(currencyReference,numeralReference);
        hundred.setNumber(THREE_DIGIT_NUMBER);
        hundred.setIndex(0);
        String expectedString = "сто двадцать две ";
        String actualString = hundred.getText();

        Assertions.assertThat(actualString).isEqualTo(expectedString);
    }

    @DisplayName("должен возвращать корректный текст для выбранныых значений (EN RUB 122 i=2)")
    @Test
    void shouldReturnCorrectTextForSelectedOptions_En_Rub_122_2() {

        numeralReference = referenceLoader.getNumeralReference(Language.EN);
        currencyReference = referenceLoader.getCurrencyReference(Language.EN,Currency.RUB);
        hundred = new HundredOriginalNumberImpl(currencyReference,numeralReference);
        hundred.setNumber(THREE_DIGIT_NUMBER);
        hundred.setIndex(2);
        String expectedString = "one hundred twenty-two million ";
        String actualString = hundred.getText();

        Assertions.assertThat(actualString).isEqualTo(expectedString);
    }

    @DisplayName("должен возвращать корректный текст для выбранныых значений (EN RUB 23 i=2)")
    @Test
    void shouldReturnCorrectTextForSelectedOptions_En_Rub_23_2() {

        numeralReference = referenceLoader.getNumeralReference(Language.EN);
        currencyReference = referenceLoader.getCurrencyReference(Language.EN,Currency.RUB);
        hundred = new HundredOriginalNumberImpl(currencyReference,numeralReference);
        hundred.setNumber(TWO_DIGIT_NUMBER);
        hundred.setIndex(2);
        String expectedString = "twenty-three million ";
        String actualString = hundred.getText();

        Assertions.assertThat(actualString).isEqualTo(expectedString);
    }



    @DisplayName("должен кидать исключение, когда число больше 3 знаков")
    @Test
    void shouldThrowExpectedExceptionWhenNumberIsTooBig() {

        currencyReference = Mockito.mock(CurrencyReference.class);
        numeralReference = Mockito.mock(NumeralReference.class);
        hundred = new HundredOriginalNumberImpl(currencyReference,numeralReference);

        Assertions.assertThatThrownBy(() -> hundred.setNumber(TOO_BIG_NUMBER))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("должен кидать исключение, когда число меньше 3 знаков")
    @Test
    void shouldThrowExpectedExceptionWhenNumberIsTooSmall() {

        currencyReference = Mockito.mock(CurrencyReference.class);
        numeralReference = Mockito.mock(NumeralReference.class);
        hundred = new HundredOriginalNumberImpl(currencyReference,numeralReference);

        Assertions.assertThatThrownBy(() -> hundred.setNumber(TOO_SMALL_NUMBER))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("должен кидать исключение, когда строка не является числом")
    @Test
    void shouldThrowExpectedExceptionWhenNumberIsIncorrect() {

        currencyReference = Mockito.mock(CurrencyReference.class);
        numeralReference = Mockito.mock(NumeralReference.class);
        hundred = new HundredOriginalNumberImpl(currencyReference,numeralReference);

        Assertions.assertThatThrownBy(() -> hundred.setNumber(INCORRECT_NUMBER))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("должен кидать исключение, когда строка не является положительным числом")
    @Test
    void shouldThrowExpectedExceptionWhenNumberIsNegative() {

        currencyReference = Mockito.mock(CurrencyReference.class);
        numeralReference = Mockito.mock(NumeralReference.class);
        hundred = new HundredOriginalNumberImpl(currencyReference,numeralReference);

        Assertions.assertThatThrownBy(() -> hundred.setNumber(NEGATIVE_NUMBER))
                .isInstanceOf(IllegalArgumentException.class);

    }

}