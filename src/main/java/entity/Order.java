package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Андрей on 11.11.2016.
 */
@Entity
@Table(name = "orders")
public class Order extends AbstractEntity {
    @Column(name = "userId", nullable = false)
    private long userId;
    @Column(name = "date")
    private Date date;
    @Column(name = "totalCost")
    private double totalCost;
    @Transient
    private List<Parcel> parcels;


    public Order() {
    }

    public Order(long userID) {
        this.userId = userID;
    }


    public void setUserId(long userID) {
        this.userId = userID;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public void setParcels(List<Parcel> parcels) {
        this.parcels = parcels;
    }

    public long getUserId() {
        return userId;
    }

    public Date getDate() {
        return date;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public List<Parcel> getParcels() {
        return parcels;
    }
}
