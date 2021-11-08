package ru.dvsokolov.lib.numinwords.models;

public class CurrencyReferenceImpl implements CurrencyReference {

    private String gender;
    private String[] name;

    @Override
    public void setNames(String[] name) {
        this.name = name;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String[] getNames() {
        return name;
    }

    @Override
    public String getGender() {
        return gender;
    }
}
