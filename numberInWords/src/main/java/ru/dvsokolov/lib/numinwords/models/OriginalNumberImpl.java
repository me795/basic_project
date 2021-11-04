package ru.dvsokolov.lib.numinwords.models;

import ru.dvsokolov.lib.numinwords.utils.NumberSlicer;
import ru.dvsokolov.lib.numinwords.utils.NumberSlicerImpl;
import ru.dvsokolov.lib.numinwords.utils.UtilityForDoubleDigits;
import ru.dvsokolov.lib.numinwords.utils.UtilityForDoubleDigitsImpl;

import java.util.ArrayList;
import java.util.List;

public class OriginalNumberImpl implements OriginalNumber {

    protected CurrencyReference currencyReference;
    protected NumeralReference numeralReference;
    private String number;
    private List<Hundred> hundredList = new ArrayList<>();

    public OriginalNumberImpl(CurrencyReference currencyReference, NumeralReference numeralReference){
        this.currencyReference = currencyReference;
        this.numeralReference = numeralReference;
    }

    @Override
    public CurrencyReference getCurrencyReference() {
        return currencyReference;
    }

    @Override
    public NumeralReference getNumeralReference() {
        return numeralReference;
    }

    @Override
    public void setNumber(String number) throws IllegalArgumentException {

        if (! number.matches("\\d+")) throw new IllegalArgumentException("Введенная строка не является положительным числом или нулём");
        if (number.length() > 42) throw new IllegalArgumentException("Введено слишком длинное число");

        this.number = number;
        NumberSlicer numberSlicer = new NumberSlicerImpl(this);
        this.hundredList = numberSlicer.getHundredList();
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public String getText() {

        StringBuilder numberInWords = new StringBuilder();
        Hundred hundredNumber = this.hundredList.get(this.hundredList.size() - 1);
        int doubleDigitsIndex = hundredNumber.getInt() % 100;

        for (Hundred hundredItem : this.hundredList){
            numberInWords.append(hundredItem.getText());
        }

        UtilityForDoubleDigits utilityForDoubleDigits = new UtilityForDoubleDigitsImpl();
        String currencyName = utilityForDoubleDigits.getText(doubleDigitsIndex, this.currencyReference.getNames());

        return numberInWords + currencyName;
    }


}
