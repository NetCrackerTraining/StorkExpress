
package utils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.google.gson.Gson;
import crud.CurrencyController;
import entity.Currency;

import javax.validation.constraints.Null;

/**
 * Created by Alexandr on 04.12.2016.
 */
public class CurrencyUpdate {

    public static void main(String[] args) {
        URL url = null;
        try {
            url = new URL("http://www.nbrb.by/API/ExRates/Rates/293");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        InputStreamReader reader = null;
        try {
            if (url != null)
            reader = new InputStreamReader(url.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        Currency newCurrency = new Currency();
        if (reader != null) {
            newCurrency = gson.fromJson(reader, Currency.class);
            System.out.println(reader.toString());
        }
        if (newCurrency != null) {

            CurrencyController currencyController = new CurrencyController();
            Currency currency = currencyController.getCurrency(newCurrency.getCurrencyAbbreviation());
            if (currency != null) {
                currency.setCurrencyRate(newCurrency.getCurrencyRate());
                currency.setDate(newCurrency.getDate());
                System.out.println(currencyController.updateCurrency(currency));
            }
            else currencyController.addCurrency(newCurrency);

        }
    }

}
