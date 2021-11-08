package ru.dvsokolov.lib.numinwords.enums;

public enum Language {
    RU ("ru"),
    EN ("en");

    private final String title;

    Language(String title) {
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
