package ru.dvsokolov.lib.numinwords.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import ru.dvsokolov.lib.numinwords.models.CurrencyReference;
import ru.dvsokolov.lib.numinwords.models.Hundred;
import ru.dvsokolov.lib.numinwords.models.NumeralReference;
import ru.dvsokolov.lib.numinwords.models.OriginalNumber;

import java.util.List;

@DisplayName("Класс NumberSlicerImpl")
class NumberSlicerImplTest {

    private CurrencyReference currencyReference;
    private NumeralReference numeralReference;
    private OriginalNumber originalNumber;
    private NumberSlicer numberSlicer;

    @BeforeEach
    void setUp() {
        originalNumber = Mockito.mock(OriginalNumber.class);
        currencyReference = Mockito.mock(CurrencyReference.class);
        numeralReference = Mockito.mock(NumeralReference.class);
        numberSlicer = new NumberSlicerImpl(originalNumber);
    }

    @DisplayName("должен возвращать одну сотню для числа 100")
    @Test
    void shouldReturnOneHundredForNumber100() {

        BDDMockito.given(originalNumber.getCurrencyReference()).willReturn(currencyReference);
        BDDMockito.given(originalNumber.getNumeralReference()).willReturn(numeralReference);
        BDDMockito.given(originalNumber.getNumber()).willReturn("100");
        List<Hundred> hundredList = numberSlicer.getHundredList();
        int expectedInt = 1;
        int actualInt = hundredList.size();

        Assertions.assertThat(actualInt).isEqualTo(expectedInt);
    }

    @DisplayName("должен возвращать две сотни для числа 10000")
    @Test
    void shouldReturnTwoHundredsForNumber10000() {

        BDDMockito.given(originalNumber.getCurrencyReference()).willReturn(currencyReference);
        BDDMockito.given(originalNumber.getNumeralReference()).willReturn(numeralReference);
        BDDMockito.given(originalNumber.getNumber()).willReturn("10000");
        List<Hundred> hundredList = numberSlicer.getHundredList();
        int expectedInt = 2;
        int actualInt = hundredList.size();

        Assertions.assertThat(actualInt).isEqualTo(expectedInt);
    }

    @DisplayName("должен возвращать пять сотен для числа 123123123123123")
    @Test
    void shouldReturnFiveHundredsForNumber123123123123123() {

        BDDMockito.given(originalNumber.getCurrencyReference()).willReturn(currencyReference);
        BDDMockito.given(originalNumber.getNumeralReference()).willReturn(numeralReference);
        BDDMockito.given(originalNumber.getNumber()).willReturn("123123123123123");
        List<Hundred> hundredList = numberSlicer.getHundredList();
        int expectedInt = 5;
        int actualInt = hundredList.size();

        Assertions.assertThat(actualInt).isEqualTo(expectedInt);
    }

    @DisplayName("должен правильно делить на сотни число 12345678")
    @Test
    void shouldCorrectSliceToHundredsForNumber12345678() {

        BDDMockito.given(originalNumber.getCurrencyReference()).willReturn(currencyReference);
        BDDMockito.given(originalNumber.getNumeralReference()).willReturn(numeralReference);
        BDDMockito.given(originalNumber.getNumber()).willReturn("12345678");
        List<Hundred> hundredList = numberSlicer.getHundredList();
        int[] expectedArray = {12,345,678};
        int i = 0;
        for (Hundred hundred : hundredList){
            int expectedInt = expectedArray[i];
            int actualInt = hundred.getInt();
            Assertions.assertThat(actualInt).isEqualTo(expectedInt);
            i++;
        }


    }


}