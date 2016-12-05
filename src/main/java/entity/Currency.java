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
    @Column(name = "currencyId")
    private int Cur_ID;
    @Column(name = "currencyName", nullable = false,  length = 45)
    private String Cur_Name;
    @Column(name = "currencyAbbreviation", nullable = false,  length = 5)
    private String Cur_Abbreviation;
    @Column(name = "currencySymbol", length = 5)
    private String currencySymbol;
    @Column(name = "currencyRate", nullable = false)
    private String Cur_OfficialRate;
    @Column(name = "date")
    private String Date;

    public Currency(String currencyName, String currencyAbbreviation, String currencyRate, int currencyId) {
        this.Cur_ID = currencyId;
        this.Cur_Name = currencyName;
        this.Cur_Abbreviation = currencyAbbreviation;
        this.Cur_OfficialRate = currencyRate;
    }

    public Currency(String currencyRate) {
        this.Cur_OfficialRate = currencyRate;
    }

    public Currency() {
    }

    public Currency(int cur_ID, String cur_Name, String cur_Abbreviation, String currencySymbol, String cur_OfficialRate, String date) {
        Cur_ID = cur_ID;
        Cur_Name = cur_Name;
        Cur_Abbreviation = cur_Abbreviation;
        this.currencySymbol = currencySymbol;
        Cur_OfficialRate = cur_OfficialRate;
        Date = date;
    }


    public void setCurrencyName(String currencyName) {
        this.Cur_Name = currencyName;
    }

    public void setCurrencyAbbreviation(String currencyAbbreviation) {
        this.Cur_Abbreviation = currencyAbbreviation;
    }

    public int getCur_ID() {
        return Cur_ID;
    }

    public void setCur_ID(int cur_ID) {
        Cur_ID = cur_ID;
    }


    public void setCurrencyRate(String currencyRate) {
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

    public String getCurrencyRate() {
        return Cur_OfficialRate;
    }

    public String getDate() {
        return Date;
    }
}
