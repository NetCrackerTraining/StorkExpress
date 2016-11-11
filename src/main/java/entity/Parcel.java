package entity;

import javax.persistence.Column;

/**
 * Created by Андрей on 11.11.2016.
 */
public class Parcel extends AbstractEntity{
    @Column(name = "orderId")
    private long orderId;
    @Column(name = "rateId")
    private int rateId;
    @Column(name = "description", length = 30)
    private String description;
    @Column(name = "weight", nullable = false)
    private double weight;
    @Column(name = "toCountryId", nullable = false)
    private int toCountryId;
    @Column(name = "fromCountryId", nullable = false)
    private int fromCountryId;
    @Column(name = "express", nullable = false)
    private boolean express;
    @Column(name = "delivered")
    private boolean delivered;
    @Column(name = "cost")
    private double cost;


    public Parcel(double weight, int toCountryId, int fromCountryId, boolean express) {
        this.weight = weight;
        this.toCountryId = toCountryId;
        this.fromCountryId = fromCountryId;
        this.express = express;
    }

    public Parcel() {

    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public void setRateId(int rateId) {
        this.rateId = rateId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setToCountryId(int toCountryId) {
        this.toCountryId = toCountryId;
    }

    public void setFromCountryId(int fromCountryId) {
        this.fromCountryId = fromCountryId;
    }

    public void setExpress(boolean express) {
        this.express = express;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public long getOrderId() {
        return orderId;
    }

    public int getRateId() {
        return rateId;
    }

    public String getDescription() {
        return description;
    }

    public double getWeight() {
        return weight;
    }

    public int getToCountryId() {
        return toCountryId;
    }

    public int getFromCountryId() {
        return fromCountryId;
    }

    public boolean isExpress() {
        return express;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public double getCost() {
        return cost;
    }
}
