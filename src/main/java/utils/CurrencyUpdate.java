
package utils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.google.gson.Gson;
import crud.CurrencyController;
import entity.Currency;

/**
 * Created by Alexandr on 04.12.2016.
 */
public class CurrencyUpdate {

    public static void main(String[] args) {
        URL url = null;
        Boolean update=false;
        try {
            url = new URL("http://www.nbrb.by/API/ExRates/Rates/145");
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
        Currency currency = new Currency();
        if (reader != null) {
            currency = gson.fromJson(reader, Currency.class);
            System.out.println(reader.toString());
        }
        if (currency != null) {
            System.out.println(currency.getCurrencyName());
            System.out.println(currency.getCurrencyRate());
            System.out.println(currency.getCurrencyAbbreviation());
            System.out.println(currency.getDate());
            System.out.println(currency.toString());


            CurrencyController currencyController = new CurrencyController();
            List<Currency> currencyList=currencyController.getAllCurrency();
            for (int i=0; i < currencyList.size();i++) {
                if (currency.getCur_ID() == currencyList.get(i).getCur_ID()) {
                    currencyList.get(i).setCurrencyRate(currency.getCurrencyRate());
                    update=currencyController.updateCurrency(currencyList.get(i));
                }
            }
            if (!update) currencyController.addCurrency(currency);

        }
    }

}
