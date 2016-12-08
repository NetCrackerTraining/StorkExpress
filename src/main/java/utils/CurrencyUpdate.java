
package utils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import crud.CurrencyController;
import entity.Currency;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.validation.constraints.Null;

/**
 * Created by Alexandr on 04.12.2016.
 */
public class CurrencyUpdate implements Job{

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String USD = "145";
        String AUD = "170";
        String BGN = "191";
        String EUR = "292";
        String RUB = "298";
        String PLN = "293";
        ArrayList<String> currencies = new ArrayList<>();
        currencies.add(USD);
        currencies.add(AUD);
        currencies.add(BGN);
        currencies.add(EUR);
        currencies.add(RUB);
        currencies.add(PLN);
        URL url = null;
        Gson gson = new Gson();
        for (String curr: currencies) {
            try {
                url = new URL("http://www.nbrb.by/API/ExRates/Rates/"+curr);
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
            Currency newCurrency = new Currency();
            if (reader != null) {
                newCurrency = gson.fromJson(reader, Currency.class);
            }
            if (newCurrency != null) {
                CurrencyController currencyController = new CurrencyController();
                Currency currency = currencyController.getCurrency(newCurrency.getCurrencyAbbreviation());
                if (currency != null) {
                    currency.setCurrencyRate(newCurrency.getCurrencyRate());
                    currency.setDate(newCurrency.getDate());
                    currencyController.updateCurrency(currency);
                } else currencyController.addCurrency(newCurrency);

            }
        }
    }
}


