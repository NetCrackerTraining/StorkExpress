package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Андрей on 04.12.2016.
 */
@Entity
@Table(name="currency")
public class Currency extends AbstractEntity{
    @Column(name = "currencyName", nullable = false,  length = 45)
    private String currencyName;
    @Column(name = "currencyAbbreviation", nullable = false,  length = 5)
    private String currencyAbbreviation;
    @Column(name = "currencySymbol", nullable = false,  length = 5)
    private String currencySymbol;
    @Column(name = "currencyRate", nullable = false)
    private Double currencyRate;

    public Currency(String currencyName, String currencyAbbreviation, String currencySymbol, Double currencyRate) {
        this.currencyName = currencyName;
        this.currencyAbbreviation = currencyAbbreviation;
        this.currencySymbol = currencySymbol;
        this.currencyRate = currencyRate;
    }

    public Currency(Double currencyRate) {
        this.currencyRate = currencyRate;
    }


    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public void setCurrencyAbbreviation(String currencyAbbreviation) {
        this.currencyAbbreviation = currencyAbbreviation;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public void setCurrencyRate(Double currencyRate) {
        this.currencyRate = currencyRate;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public String getCurrencyAbbreviation() {
        return currencyAbbreviation;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public Double getCurrencyRate() {
        return currencyRate;
    }
}
