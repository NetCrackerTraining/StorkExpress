package crud;

import entity.Country;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
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
        session.close();
        return countries;
    }
    public void addCountry(Country country){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            session.save(country);
            session.getTransaction().commit();
        }
        catch (HibernateException e){
            session.getTransaction().rollback();
        }
        session.close();
    }
    public void deleteAllCountries(){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

            String stringQuery = "DELETE FROM entity.Country";
            Query query = session.createQuery(stringQuery);
            query.executeUpdate();
            session.getTransaction().commit();


        session.close();

    }
}
