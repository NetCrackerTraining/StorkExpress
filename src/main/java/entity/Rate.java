package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Vlad on 11.11.2016.
 */
@Entity
@Table(name = "rates")
public class Rate extends AbstractEntity {

    @Column(name = "beginDate", nullable = false, length = 30)
    private Date beginDate;
    @Column(name = "endDate", nullable = false, length = 30)
    private Date endDate;
    @Column(name = "price", nullable = false)
    private int price;

    public Rate(){};

    public Rate(Date beginDate, Date endDate, int price) {
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.price = price;
    }

    public double calculateParcelCost(Parcel parcel){
        double cost;
        cost = parcel.getWeight() * this.price;
        if (parcel.getExpress()){
            cost *= 1.2;
        }
        return cost;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}