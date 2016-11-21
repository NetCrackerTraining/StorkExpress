package crud;

import entity.Rate;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import utils.HibernateSessionFactory;

import java.util.*;

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
        session.close();
        return rates;
    }

    public List<Rate> getRatesBetweenDates(Date fromDate, Date toDate){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Rate.class);
        criteria.add(Restrictions.between("startDate", fromDate, toDate));
        List<Rate> rates=criteria.list();
        session.getTransaction().commit();
        session.close();
        if (rates.size() == 0)
            return null;
        return rates;
    }

    public Rate getCurrentRate()
    {
        Date currentDate = java.util.Calendar.getInstance().getTime();
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Rate.class);
        criteria.add(Restrictions.ge("endDate", currentDate));
        criteria.add(Restrictions.le("beginDate", currentDate));
        criteria.addOrder(Order.desc("price"));
        ArrayList<Rate> list = (ArrayList<Rate>) criteria.list();
        session.getTransaction().commit();
        session.close();
        if (list.size()<1)
            return null;
        return list.get(0);
    }

    public void addRate(Rate rate){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(rate);
        session.getTransaction().commit();
        session.close();
    }
}
