package ru.dvsokolov.lib.numinwords.models;

public interface CurrencyReference {

    void setNames(String[] name);
    void setGender(String gender);
    String[] getNames();
    String getGender();
}
