package ru.dvsokolov.lib.numinwords.utils;

public class UtilityForDoubleDigitsImpl implements UtilityForDoubleDigits {
    @Override
    public String getText(int doubleDigitsIndex, String[] text) {
        return switch (doubleDigitsIndex) {
            case 1 -> text[0];
            case 21,31,41,51,61,71,81,91 -> text[2];
            case 2,3,4,22,23,24,32,33,34,42,43,44,52,53,54,62,63,64,72,73,74,82,83,84,92,93,94 -> text[3];
            default -> text[1];
        };
    }
}
