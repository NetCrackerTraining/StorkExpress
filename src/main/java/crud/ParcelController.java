package crud;

import entity.Parcel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import utils.HibernateSessionFactory;

import java.util.List;

/**
 * Created by Андрей on 12.11.2016.
 */
public class ParcelController {

    public Boolean AddParcel(Parcel parcel){

        return true;
    }

    public List<Parcel> getOrderParcels(long orderId){

        return null;
    }

    public boolean deleteParcel(long parcelId){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Parcel parcel = (Parcel) session.load(Parcel.class, parcelId);
        try {
            if(null != parcel) {
                session.delete(parcel);
            }
        }catch (HibernateException e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        session.getTransaction().commit();
        return true;
    }
}
