package ru.dvsokolov.lib.numinwords;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.dvsokolov.lib.numinwords.enums.Currency;
import ru.dvsokolov.lib.numinwords.enums.Language;

@DisplayName("Класс NumberInWordsImpl")
class NumberInWordsImplTest {

    private static final String TOO_BIG_NUMBER = "1234567890123456789012345678901234567890123";
    private static final String INCORRECT_NUMBER = "2343ff133";
    private static final String NEGATIVE_NUMBER = "-234522";
    private static final String MAX_NUMBER = "123456789012345678901234567890123456789012";

    private NumberInWords numberInWords;

    @DisplayName("должен возвращать корректный текст для выбранныых значений (RU RUB MAX_NUMBER)")
    @Test
    void shouldReturnCorrectTextForSelectedOptions_Ru_Rub_MAX_NUMBER() {

        numberInWords = new NumberInWordsImpl(Language.RU, Currency.RUB);
        numberInWords.setNumber(MAX_NUMBER);
        String expectedString = "сто двадцать три додекальлона четыреста пятьдесят шесть эндекальонов " +
                "семьсот восемьдесят девять декальонов двеннадцать нональонов триста сорок пять октильонов " +
                "шестьсот семьдесят восемь септильонов девятьсот один секстильон двести тридцать четыре квинтильона " +
                "пятьсот шестьдесят семь квадрильонов восемьсот девяносто триллионов сто двадцать три миллиарда " +
                "четыреста пятьдесят шесть миллионов семьсот восемьдесят девять тысяч двеннадцать рублей";
        String actualString = numberInWords.getText();

        Assertions.assertThat(actualString).isEqualTo(expectedString);
    }

    @DisplayName("должен возвращать корректный текст для выбранныых значений (EN USD MAX_NUMBER)")
    @Test
    void shouldReturnCorrectTextForSelectedOptions_En_Usd_MAX_NUMBER() {

        numberInWords = new NumberInWordsImpl(Language.EN, Currency.USD);
        numberInWords.setNumber(MAX_NUMBER);
        String expectedString = "one hundred twenty-three dodecallon four hundred fifty-six endekallon " +
                "seven hundred eighty-nine decal twelve nonalon three hundred forty-five octillon " +
                "six hundred seventy-eight septilon nine hundred one sextilon two hundred thirty-four quintile " +
                "five hundred sixty-seven quadrillion eight hundred ninety trillion one hundred twenty-three billion " +
                "four hundred fifty-six million seven hundred eighty-nine thousand twelve dollars";
        String actualString = numberInWords.getText();

        Assertions.assertThat(actualString).isEqualTo(expectedString);
    }

    @DisplayName("должен возвращать корректный текст для выбранныых значений (RU RUB 34321)")
    @Test
    void shouldReturnCorrectTextForSelectedOptions_Ru_Rub_34321() {

        numberInWords = new NumberInWordsImpl(Language.RU, Currency.RUB);
        numberInWords.setNumber("34321");
        String expectedString = "тридцать четыре тысячи триста двадцать один рубль";
        String actualString = numberInWords.getText();

        Assertions.assertThat(actualString).isEqualTo(expectedString);
    }

    @DisplayName("должен возвращать корректный текст для выбранныых значений (RU USD 31321)")
    @Test
    void shouldReturnCorrectTextForSelectedOptions_Ru_Usd_31321() {

        numberInWords = new NumberInWordsImpl(Language.RU, Currency.USD);
        numberInWords.setNumber("31321");
        String expectedString = "тридцать одна тысяча триста двадцать один доллар";
        String actualString = numberInWords.getText();

        Assertions.assertThat(actualString).isEqualTo(expectedString);
    }

    @DisplayName("должен возвращать корректный текст для выбранныых значений (RU YEN 35321)")
    @Test
    void shouldReturnCorrectTextForSelectedOptions_Ru_Yen_35321() {

        numberInWords = new NumberInWordsImpl(Language.RU, Currency.YEN);
        numberInWords.setNumber("35321");
        String expectedString = "тридцать пять тысяч триста двадцать одна йена";
        String actualString = numberInWords.getText();

        Assertions.assertThat(actualString).isEqualTo(expectedString);
    }

    @DisplayName("должен кидать исключение, когда число больше 42 знаков")
    @Test
    void shouldThrowExpectedExceptionWhenNumberIsTooBig() {

        numberInWords = new NumberInWordsImpl(Language.RU, Currency.RUB);

        Assertions.assertThatThrownBy(() -> numberInWords.setNumber(TOO_BIG_NUMBER))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("должен кидать исключение, когда строка не является числом")
    @Test
    void shouldThrowExpectedExceptionWhenNumberIsIncorrect() {

        numberInWords = new NumberInWordsImpl(Language.RU, Currency.RUB);

        Assertions.assertThatThrownBy(() -> numberInWords.setNumber(INCORRECT_NUMBER))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("должен кидать исключение, когда строка не является положительным числом")
    @Test
    void shouldThrowExpectedExceptionWhenNumberIsNegative() {

        numberInWords = new NumberInWordsImpl(Language.RU, Currency.RUB);

        Assertions.assertThatThrownBy(() -> numberInWords.setNumber(NEGATIVE_NUMBER))
                .isInstanceOf(IllegalArgumentException.class);

    }
}