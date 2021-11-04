package ru.dvsokolov.cli.utils;

import ru.dvsokolov.lib.numinwords.enums.Currency;
import ru.dvsokolov.lib.numinwords.enums.Language;

public class AppMenuImpl implements AppMenu {

    private final IO io;

    public AppMenuImpl(IO io){
        this.io = io;
    }

    public Language selectLanguage(){

        String locale;

        do {
            io.println("Выберите язык:",IO.FontColor.ANSI_BLUE);
            io.println("1. RU");
            io.println("2. EN");
            locale = io.inputString();
        } while ((!locale.equals("1")) && (!locale.equals("2")));

        return switch (locale) {
            case "2" -> Language.EN;
            default -> Language.RU;
        };
    }

    public Currency selectCurrency() {
        String currency;

        do {
            io.println("Выберите валюту:",IO.FontColor.ANSI_BLUE);
            io.println("1. RUB");
            io.println("2. USD");
            io.println("3. YEN");
            currency = io.inputString();
        } while ((!currency.equals("1")) && (!currency.equals("2")) && (!currency.equals("3")));

        return switch (currency) {
            case "2" -> Currency.USD;
            case "3" -> Currency.YEN;
            default -> Currency.RUB;
        };
    }
}
