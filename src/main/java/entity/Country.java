package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Vlad on 11.11.2016.
 */
@Entity
@Table(name = "countries")
public class Country extends AbstractEntity {

    @Column(name = "countryNameEN", nullable = false, length = 30)
    private String countryNameEN;
    @Column(name = "countryNameRU", nullable = false, length = 30)
    private String countryNameRU;
    @Column(name = "countryCode", nullable = false)
    private int countryCode;

    public Country() {
    }

    public Country(String countryNameEN, String countryNameRU, int countryCode) {
        this.countryNameEN = countryNameEN;
        this.countryNameRU = countryNameRU;
        this.countryCode = countryCode;
    }


    public String getCountryNameEN() {
        return countryNameEN;
    }

    public void setCountryNameEN(String countryNameEN) {
        this.countryNameEN = countryNameEN;
    }

    public String getCountryNameRU() {
        return countryNameRU;
    }

    public void setCountryNameRU(String countryNameRU) {
        this.countryNameRU = countryNameRU;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }
}