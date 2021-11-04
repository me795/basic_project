package ru.dvsokolov.cli.service;

import ru.dvsokolov.cli.utils.IO;
import ru.dvsokolov.cli.utils.AppMenu;
import ru.dvsokolov.lib.numinwords.NumberInWords;
import ru.dvsokolov.lib.numinwords.NumberInWordsImpl;
import ru.dvsokolov.lib.numinwords.enums.Currency;
import ru.dvsokolov.lib.numinwords.enums.Language;

public class Application {
    private final IO io;
    private final AppMenu menu;

    public Application(IO io, AppMenu menu) {
        this.io = io;
        this.menu = menu;
    }

    public void run() {

        Language language = menu.selectLanguage();
        Currency currency = menu.selectCurrency();
        NumberInWords numberInWords = new NumberInWordsImpl(language, currency);

        while (true) {
            io.print("Введите", IO.FontColor.ANSI_BLUE);
            io.print(" число", IO.FontColor.ANSI_RED);
            io.print(" или команду", IO.FontColor.ANSI_BLUE);
            io.println(" exit", IO.FontColor.ANSI_RED);
            String number = io.inputString();
            if (number.equals("exit")) {
                break;
            } else {
                try {
                    numberInWords.setNumber(number);
                    io.println(numberInWords.getText());
                } catch (IllegalArgumentException e) {
                    io.println(e.getMessage(), IO.FontColor.ANSI_RED);
                }
            }
        }
    }


}
