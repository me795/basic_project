package ru.dvsokolov.lib.numinwords.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.dvsokolov.lib.numinwords.enums.Currency;
import ru.dvsokolov.lib.numinwords.enums.Language;


@DisplayName("Класс ReferenceLoaderImpl")
class ReferenceLoaderImplTest {

    private ReferenceLoader referenceLoader;

    @BeforeEach
    void setUp() {
        referenceLoader = new ReferenceLoaderImpl();
    }

    @DisplayName("должен корректно загружать справочник чисел для всех локалей")
    @Test
    void shouldCorrectLoadNumeralReferenceWithAllLanguage() {

        Assertions.assertThatNoException().isThrownBy(() -> referenceLoader.getNumeralReference(Language.RU));
        Assertions.assertThatNoException().isThrownBy(() -> referenceLoader.getNumeralReference(Language.EN));

    }

    @DisplayName("должен корректно загружать справочники валют для всех локалей и значений")
    @Test
    void shouldCorrectLoadCurrencyReferenceWithAllLanguageAndCurrency() {

        Assertions.assertThatNoException().isThrownBy(() -> referenceLoader.getCurrencyReference(Language.RU, Currency.RUB));
        Assertions.assertThatNoException().isThrownBy(() -> referenceLoader.getCurrencyReference(Language.RU, Currency.USD));
        Assertions.assertThatNoException().isThrownBy(() -> referenceLoader.getCurrencyReference(Language.RU, Currency.YEN));
        Assertions.assertThatNoException().isThrownBy(() -> referenceLoader.getCurrencyReference(Language.EN, Currency.RUB));
        Assertions.assertThatNoException().isThrownBy(() -> referenceLoader.getCurrencyReference(Language.EN, Currency.USD));
        Assertions.assertThatNoException().isThrownBy(() -> referenceLoader.getCurrencyReference(Language.EN, Currency.YEN));

    }

}