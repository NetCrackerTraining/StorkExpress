package crud;

import entity.Country;
import entity.User;
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
        Criteria criteria = session.createCriteria(Country.class);
        List<Country> countries = (List<Country>) criteria.list();
        session.getTransaction().commit();
        return countries;
    }
}
