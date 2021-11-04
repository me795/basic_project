package ru.dvsokolov.lib.numinwords.models;

public interface NumeralReference {

    void setDoubleDigitsM(String[] doubleDigitsM);
    void setDoubleDigitsF(String[] doubleDigitsF);
    void setHundreds(String[] hundreds);
    void setPolyDigits(String[][] polyDigits);
    String[] getDoubleDigitsM();
    String[] getDoubleDigitsF();
    String[] getHundreds();
    String[][] getPolyDigits();

}
