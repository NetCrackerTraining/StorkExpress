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
    private String Cur_Name;
    @Column(name = "currencyAbbreviation", nullable = false,  length = 5)
    private String Cur_Abbreviation;
    @Column(name = "currencySymbol",  length = 5)
    private String currencySymbol;
    @Column(name = "currencyRate", nullable = false)
    private Double Cur_OfficialRate;

    public Currency(String currencyName, String currencyAbbreviation, String currencySymbol, Double currencyRate) {
        this.Cur_Name = currencyName;
        this.Cur_Abbreviation = currencyAbbreviation;
        this.currencySymbol = currencySymbol;
        this.Cur_OfficialRate = currencyRate;
    }

    public Currency(Double currencyRate) {
        this.Cur_OfficialRate = currencyRate;
    }


    public void setCurrencyName(String currencyName) {
        this.Cur_Name = currencyName;
    }

    public void setCurrencyAbbreviation(String currencyAbbreviation) {
        this.Cur_Abbreviation = currencyAbbreviation;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public void setCurrencyRate(Double currencyRate) {
        this.Cur_OfficialRate = currencyRate;
    }

    public String getCurrencyName() {
        return Cur_Name;
    }

    public String getCurrencyAbbreviation() {
        return Cur_Abbreviation;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public Double getCurrencyRate() {
        return Cur_OfficialRate;
    }
}
