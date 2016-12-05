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
    @Column(name = "currencyRate", nullable = false)
    private String Cur_OfficialRate;
    @Column(name = "date")
    private String Date;
    @Column(name = "currencyScale")
    private int Cur_Scale;

    public Currency() {
    }

    public Currency(int cur_ID, String cur_Name, String cur_Abbreviation, String cur_OfficialRate, String date, int cur_Scale) {
        Cur_ID = cur_ID;
        Cur_Name = cur_Name;
        Cur_Abbreviation = cur_Abbreviation;
        Cur_OfficialRate = cur_OfficialRate;
        Date = date;
        Cur_Scale = cur_Scale;
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

    public String getCurrencyRate() {
        return Cur_OfficialRate;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getCur_Scale() {
        return Cur_Scale;
    }

    public void setCur_Scale(int cur_Scale) {
        Cur_Scale = cur_Scale;
    }
}
