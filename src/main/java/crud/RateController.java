package crud;

import entity.Rate;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import utils.HibernateSessionFactory;

import java.util.Date;
import java.util.List;

/**
 * Created by Влад on 11.11.2016.
 */
public class RateController {
    public List<Rate> getAllRates(){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        List<Rate> rates = null;
        Criteria criteria = session.createCriteria(Rate.class);
        try {
            rates = criteria.list();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        return rates;
    }

    public List<Rate> getRatesBetweenDates(Date fromDate, Date toDate){

        return null;
    }

    public Rate getCurrentRate()
    {

        return null;
    }
}
