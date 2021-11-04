package ru.dvsokolov.lib.numinwords.models;

import ru.dvsokolov.lib.numinwords.utils.UtilityForDoubleDigits;
import ru.dvsokolov.lib.numinwords.utils.UtilityForDoubleDigitsImpl;

public class HundredOriginalNumberImpl extends OriginalNumberImpl implements Hundred{

    private String number;
    private int index;

    public HundredOriginalNumberImpl(CurrencyReference currencyReference, NumeralReference numeralReference){
        super(currencyReference, numeralReference);
    }

    @Override
    public void setNumber(String number) {

        if (! number.matches("\\d+")) throw new IllegalArgumentException("Переданная строка не является положительным числом или нулём");
        if (number.length() > 3) throw new IllegalArgumentException("Передано слишком длинное число");
        if (number.length() < 3) throw new IllegalArgumentException("Передано слишком корткое число");

        this.number = number;
    }

    @Override
    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public int getInt() {
        return Integer.parseInt(this.number);
    }

    @Override
    public String getText() {

        String gender = this.currencyReference.getGender();
        String[] polyDigits = this.numeralReference.getPolyDigits()[this.index];
        String[] hundreds = this.numeralReference.getHundreds();
        String[] doubleDigits;
        if (((gender.equals("f")) && (this.index == 0)) || (this.index == 1)){
            doubleDigits = this.numeralReference.getDoubleDigitsF();
        }else{
            doubleDigits = this.numeralReference.getDoubleDigitsM();
        }

        int hundredIndex = this.getInt() / 100;
        int doubleDigitsIndex = this.getInt() % 100;

        UtilityForDoubleDigits utilityForDoubleDigits = new UtilityForDoubleDigitsImpl();

        return hundreds[hundredIndex] + doubleDigits[doubleDigitsIndex] + utilityForDoubleDigits.getText(doubleDigitsIndex, polyDigits);
    }

}
