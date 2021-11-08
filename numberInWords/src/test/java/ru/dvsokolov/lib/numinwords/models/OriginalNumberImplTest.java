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

@DisplayName("Класс OriginalNumberImpl")
class OriginalNumberImplTest {

    private static final String TOO_BIG_NUMBER = "1234567890123456789012345678901234567890123";
    private static final String INCORRECT_NUMBER = "2343ff133";
    private static final String NEGATIVE_NUMBER = "-234522";
    private static final String MAX_NUMBER = "123456789012345678901234567890123456789012";

    private ReferenceLoader referenceLoader;
    private NumeralReference numeralReference;
    private CurrencyReference currencyReference;
    private OriginalNumber originalNumber;

    @BeforeEach
    void setUp() {
        referenceLoader = new ReferenceLoaderImpl();
    }


    @DisplayName("должен возвращать значение поля number при вызове метода getNumber")
    @Test
    void shouldReturnValueOfNumberFromGetNumberMethod() {

        numeralReference = Mockito.mock(NumeralReference.class);
        currencyReference = Mockito.mock(CurrencyReference.class);
        originalNumber = new OriginalNumberImpl(currencyReference,numeralReference);
        originalNumber.setNumber(MAX_NUMBER);

        String expectedString = MAX_NUMBER;
        String actualString = originalNumber.getNumber();

        Assertions.assertThat(actualString).isEqualTo(expectedString);
    }

    @DisplayName("должен возвращать значение поля numeralReference при вызове метода getNumeralReference")
    @Test
    void shouldReturnValueOfNumeralReferenceFromGetNumeralReferenceMethod() {

        numeralReference = referenceLoader.getNumeralReference(Language.RU);
        currencyReference = Mockito.mock(CurrencyReference.class);
        originalNumber = new OriginalNumberImpl(currencyReference,numeralReference);

        NumeralReference expectedObject = numeralReference;
        NumeralReference actualObject = originalNumber.getNumeralReference();

        Assertions.assertThat(actualObject).isEqualTo(expectedObject);
    }

    @DisplayName("должен возвращать значение поля currencyReference при вызове метода getCurrencyReference")
    @Test
    void shouldReturnValueOfCurrencyReferenceFromGetCurrencyReferenceMethod() {

        numeralReference = Mockito.mock(NumeralReference.class);
        currencyReference = referenceLoader.getCurrencyReference(Language.RU,Currency.RUB);
        originalNumber = new OriginalNumberImpl(currencyReference,numeralReference);

        CurrencyReference expectedObject = currencyReference;
        CurrencyReference actualObject = originalNumber.getCurrencyReference();

        Assertions.assertThat(actualObject).isEqualTo(expectedObject);
    }

    @DisplayName("должен возвращать корректный текст для выбранныых значений (RU RUB MAX_NUMBER)")
    @Test
    void shouldReturnCorrectTextForSelectedOptions_Ru_Rub_MAX_NUMBER() {

        numeralReference = referenceLoader.getNumeralReference(Language.RU);
        currencyReference = referenceLoader.getCurrencyReference(Language.RU,Currency.RUB);
        originalNumber = new OriginalNumberImpl(currencyReference,numeralReference);
        originalNumber.setNumber(MAX_NUMBER);
        String expectedString = "сто двадцать три додекальлона четыреста пятьдесят шесть эндекальонов " +
                "семьсот восемьдесят девять декальонов двеннадцать нональонов триста сорок пять октильонов " +
                "шестьсот семьдесят восемь септильонов девятьсот один секстильон двести тридцать четыре квинтильона " +
                "пятьсот шестьдесят семь квадрильонов восемьсот девяносто триллионов сто двадцать три миллиарда " +
                "четыреста пятьдесят шесть миллионов семьсот восемьдесят девять тысяч двеннадцать рублей";
        String actualString = originalNumber.getText();

        Assertions.assertThat(actualString).isEqualTo(expectedString);
    }

    @DisplayName("должен возвращать корректный текст для выбранныых значений (EN USD MAX_NUMBER)")
    @Test
    void shouldReturnCorrectTextForSelectedOptions_En_Usd_MAX_NUMBER() {

        numeralReference = referenceLoader.getNumeralReference(Language.EN);
        currencyReference = referenceLoader.getCurrencyReference(Language.EN,Currency.USD);
        originalNumber = new OriginalNumberImpl(currencyReference,numeralReference);
        originalNumber.setNumber(MAX_NUMBER);
        String expectedString = "one hundred twenty-three dodecallon four hundred fifty-six endekallon " +
                "seven hundred eighty-nine decal twelve nonalon three hundred forty-five octillon " +
                "six hundred seventy-eight septilon nine hundred one sextilon two hundred thirty-four quintile " +
                "five hundred sixty-seven quadrillion eight hundred ninety trillion one hundred twenty-three billion " +
                "four hundred fifty-six million seven hundred eighty-nine thousand twelve dollars";
        String actualString = originalNumber.getText();

        Assertions.assertThat(actualString).isEqualTo(expectedString);
    }

    @DisplayName("должен возвращать корректный текст для выбранныых значений (RU RUB 34321)")
    @Test
    void shouldReturnCorrectTextForSelectedOptions_Ru_Rub_34321() {

        numeralReference = referenceLoader.getNumeralReference(Language.RU);
        currencyReference = referenceLoader.getCurrencyReference(Language.RU,Currency.RUB);
        originalNumber = new OriginalNumberImpl(currencyReference,numeralReference);
        originalNumber.setNumber("34321");
        String expectedString = "тридцать четыре тысячи триста двадцать один рубль";
        String actualString = originalNumber.getText();

        Assertions.assertThat(actualString).isEqualTo(expectedString);
    }

    @DisplayName("должен возвращать корректный текст для выбранныых значений (RU USD 31321)")
    @Test
    void shouldReturnCorrectTextForSelectedOptions_Ru_Usd_31321() {

        numeralReference = referenceLoader.getNumeralReference(Language.RU);
        currencyReference = referenceLoader.getCurrencyReference(Language.RU,Currency.USD);
        originalNumber = new OriginalNumberImpl(currencyReference,numeralReference);
        originalNumber.setNumber("31321");
        String expectedString = "тридцать одна тысяча триста двадцать один доллар";
        String actualString = originalNumber.getText();

        Assertions.assertThat(actualString).isEqualTo(expectedString);
    }

    @DisplayName("должен возвращать корректный текст для выбранныых значений (RU YEN 35321)")
    @Test
    void shouldReturnCorrectTextForSelectedOptions_Ru_Yen_35321() {

        numeralReference = referenceLoader.getNumeralReference(Language.RU);
        currencyReference = referenceLoader.getCurrencyReference(Language.RU,Currency.YEN);
        originalNumber = new OriginalNumberImpl(currencyReference,numeralReference);
        originalNumber.setNumber("35321");
        String expectedString = "тридцать пять тысяч триста двадцать одна йена";
        String actualString = originalNumber.getText();

        Assertions.assertThat(actualString).isEqualTo(expectedString);
    }


    @DisplayName("должен кидать исключение, когда число больше 42 знаков")
    @Test
    void shouldThrowExpectedExceptionWhenNumberIsTooBig() {

        currencyReference = Mockito.mock(CurrencyReference.class);
        numeralReference = Mockito.mock(NumeralReference.class);
        originalNumber = new OriginalNumberImpl(currencyReference,numeralReference);

        Assertions.assertThatThrownBy(() -> originalNumber.setNumber(TOO_BIG_NUMBER))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("должен кидать исключение, когда строка не является числом")
    @Test
    void shouldThrowExpectedExceptionWhenNumberIsIncorrect() {

        currencyReference = Mockito.mock(CurrencyReference.class);
        numeralReference = Mockito.mock(NumeralReference.class);
        originalNumber = new OriginalNumberImpl(currencyReference,numeralReference);

        Assertions.assertThatThrownBy(() -> originalNumber.setNumber(INCORRECT_NUMBER))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("должен кидать исключение, когда строка не является положительным числом")
    @Test
    void shouldThrowExpectedExceptionWhenNumberIsNegative() {

        currencyReference = Mockito.mock(CurrencyReference.class);
        numeralReference = Mockito.mock(NumeralReference.class);
        originalNumber = new OriginalNumberImpl(currencyReference,numeralReference);

        Assertions.assertThatThrownBy(() -> originalNumber.setNumber(NEGATIVE_NUMBER))
                .isInstanceOf(IllegalArgumentException.class);

    }

}