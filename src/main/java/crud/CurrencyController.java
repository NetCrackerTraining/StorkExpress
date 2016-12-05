package crud;

import entity.Currency;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import utils.HibernateSessionFactory;

import java.util.List;

/**
 * Created by Андрей on 04.12.2016.
 */
public class CurrencyController {

    public void addCurrency(Currency currency){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(currency);
        session.getTransaction().commit();
        session.close();
    }

    public List<Currency> getAllCurrency(){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Currency.class);
        List<Currency> countries = (List<Currency>) criteria.list();
        session.getTransaction().commit();
        session.close();
        return countries;
    }

    public boolean updateCurrency(Currency currency) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            session.update(currency);
        }catch (HibernateException e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
        session.getTransaction().commit();
        session.close();
        return true;
    }

}
