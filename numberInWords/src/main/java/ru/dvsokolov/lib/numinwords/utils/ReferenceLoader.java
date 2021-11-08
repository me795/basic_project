package ru.dvsokolov.lib.numinwords.utils;


import ru.dvsokolov.lib.numinwords.enums.Language;
import ru.dvsokolov.lib.numinwords.enums.Currency;
import ru.dvsokolov.lib.numinwords.models.CurrencyReference;
import ru.dvsokolov.lib.numinwords.models.NumeralReference;

public interface ReferenceLoader {

    NumeralReference getNumeralReference(Language language);
    CurrencyReference getCurrencyReference(Language language, Currency currency);
}
