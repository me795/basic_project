package ru.dvsokolov.lib.numinwords.enums;

public enum Currency {
    RUB ("rub"),
    USD ("usd"),
    YEN ("yen");

    private final String title;

    Currency(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }

}
