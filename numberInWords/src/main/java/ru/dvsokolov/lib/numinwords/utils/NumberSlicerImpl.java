package ru.dvsokolov.lib.numinwords.utils;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import ru.dvsokolov.lib.numinwords.models.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberSlicerImpl implements NumberSlicer{

    private OriginalNumber originalNumber;

    public NumberSlicerImpl(OriginalNumber originalNumber){
        this.originalNumber = originalNumber;
    }

    @Override
    public List<Hundred> getHundredList() {

        String number = originalNumber.getNumber();

        int numberLength = number.length();
        number = switch (numberLength % 3) {
            case 1 -> "00" + number;
            case 2 -> "0" + number;
            default -> number;
        };
        Iterable<String> slices = Splitter.fixedLength(3).split(number);
        String[] parts = Iterables.toArray(slices, String.class);

        List<Hundred> hundredList = new ArrayList<>();

        int index = 0;
        for (int i = parts.length - 1; i >= 0; i--) {
            Hundred hundred = new HundredOriginalNumberImpl(originalNumber.getCurrencyReference(),originalNumber.getNumeralReference());
            hundred.setIndex(index);
            hundred.setNumber(parts[i]);
            hundredList.add(hundred);
            index++;
        }
        Collections.reverse(hundredList);

        return hundredList;
    }
}
