package entity;

import crud.ParcelController;

import javax.persistence.*;
import java.util.ArrayList;
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
    private ArrayList<Parcel> parcels = null;


    public Order() {
    }

    public Order(long userID) {
        this();
        this.userId = userID;
        this.parcels = new ArrayList<Parcel>();
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

    public void setParcels(ArrayList<Parcel> parcels) {
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

    public ArrayList<Parcel> getParcels() {
        if (parcels!=null){
            return parcels;
        }
        ParcelController parcelController = new ParcelController();
        ArrayList<Parcel> orderParcels = (ArrayList<Parcel>) parcelController.getOrderParcels(this.getId());
        if (orderParcels!=null){
            return orderParcels;
        }
        return new ArrayList<Parcel>();
    }

    public void addParcel(Parcel parcel){
        parcels.add(parcel);
        totalCost+=parcel.getCost();
    }

    public void deleteParcel(long parcelId){
//        for (int i =0; i < parcels.size(); i++){
//            if (parcels.get(i).getId() == parcelId){
//                this.totalCost -= parcels.get(i).getCost();
//                parcels.remove(i);
//                break;
//            }
//        }
        this.totalCost -= parcels.get((int) parcelId).getCost();
        parcels.remove(parcelId);
    }
}
