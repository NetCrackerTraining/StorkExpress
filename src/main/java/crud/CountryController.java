package crud;

import entity.Country;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import utils.HibernateSessionFactory;

import java.util.List;

/**
 * Created by Андрей on 11.11.2016.
 */
public class CountryController {

    public List<Country> getAllCountries(){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        List<Country> countries = null;
        Criteria criteria = session.createCriteria(Country.class);
        try {
            countries = criteria.list();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        return countries;
    }
}
