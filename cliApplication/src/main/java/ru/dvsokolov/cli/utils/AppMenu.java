package ru.dvsokolov.cli.utils;

import ru.dvsokolov.lib.numinwords.enums.Currency;
import ru.dvsokolov.lib.numinwords.enums.Language;

public interface AppMenu {
    Language selectLanguage();
    Currency selectCurrency();
}
