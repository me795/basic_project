package ru.dvsokolov.lib.numinwords.utils;


import com.google.gson.Gson;
import ru.dvsokolov.lib.numinwords.enums.Currency;
import ru.dvsokolov.lib.numinwords.enums.Language;
import ru.dvsokolov.lib.numinwords.models.CurrencyReference;
import ru.dvsokolov.lib.numinwords.models.CurrencyReferenceImpl;
import ru.dvsokolov.lib.numinwords.models.NumeralReference;
import ru.dvsokolov.lib.numinwords.models.NumeralReferenceImpl;

import java.io.IOException;
import java.io.InputStream;


public class ReferenceLoaderImpl implements ReferenceLoader {

    @Override
    public NumeralReference getNumeralReference(Language language) {

        String fileName = language.getTitle() + "_numbers.json";
        NumeralReference numeralReference = null;
        
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classloader.getResourceAsStream(fileName);
            FileReader fileReader = new FileReaderImpl(inputStream,"UTF-8");
            String jsonString = fileReader.getFileContent();
            Gson g = new Gson();
            numeralReference = g.fromJson(jsonString, NumeralReferenceImpl.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return numeralReference;
    }

    @Override
    public CurrencyReference getCurrencyReference(Language language, Currency currency) {

        String fileName = language.getTitle() + "_" + currency.getTitle() + "_currency.json";
        CurrencyReference currencyReference = null;

        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classloader.getResourceAsStream(fileName);
            FileReader fileReader = new FileReaderImpl(inputStream,"UTF-8");
            String jsonString = fileReader.getFileContent();
            Gson g = new Gson();
            currencyReference = g.fromJson(jsonString, CurrencyReferenceImpl.class);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return currencyReference;
    }

}
