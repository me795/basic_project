package ru.dvsokolov.lib.numinwords;

import ru.dvsokolov.lib.numinwords.enums.Currency;
import ru.dvsokolov.lib.numinwords.enums.Language;
import ru.dvsokolov.lib.numinwords.models.*;
import ru.dvsokolov.lib.numinwords.utils.ReferenceLoader;
import ru.dvsokolov.lib.numinwords.utils.ReferenceLoaderImpl;

public class NumberInWordsImpl implements NumberInWords {

    protected final Language language;
    protected final Currency currency;
    protected OriginalNumber number;

    public NumberInWordsImpl(Language language, Currency currency){
        this.language = language;
        this.currency = currency;
    }

    @Override
    public void setNumber(String number) throws IllegalArgumentException {

        ReferenceLoader referenceLoader = new ReferenceLoaderImpl();
        NumeralReference numeralReference = referenceLoader.getNumeralReference(language);
        CurrencyReference currencyReference = referenceLoader.getCurrencyReference(language,currency);

        this.number = new OriginalNumberImpl(currencyReference,numeralReference);
        this.number.setNumber(number);

    }

    @Override
    public String getText() {
        return this.number.getText();
    }
}
