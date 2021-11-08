package ru.dvsokolov.lib.numinwords.models;

public interface OriginalNumber {

    CurrencyReference getCurrencyReference();
    NumeralReference getNumeralReference();
    void setNumber(String number);
    String getNumber();
    String getText();

}
