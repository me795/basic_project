package ru.dvsokolov.lib.numinwords.models;

public class NumeralReferenceImpl implements NumeralReference {

    private String[] doubleDigitsM;
    private String[] doubleDigitsF;
    private String[] hundreds;
    private String[][] polyDigits;

    @Override
    public void setDoubleDigitsM(String[] doubleDigitsM) {
        this.doubleDigitsM = doubleDigitsM;
    }

    @Override
    public void setDoubleDigitsF(String[] doubleDigitsF) {
        this.doubleDigitsF = doubleDigitsF;
    }

    @Override
    public void setHundreds(String[] hundreds) {
        this.hundreds = hundreds;
    }

    @Override
    public void setPolyDigits(String[][] polyDigits) {
        this.polyDigits = polyDigits;
    }

    @Override
    public String[] getDoubleDigitsM() {
        return doubleDigitsM;
    }

    @Override
    public String[] getDoubleDigitsF() {
        return doubleDigitsF;
    }

    @Override
    public String[] getHundreds() {
        return hundreds;
    }

    @Override
    public String[][] getPolyDigits() {
        return polyDigits;
    }


}
