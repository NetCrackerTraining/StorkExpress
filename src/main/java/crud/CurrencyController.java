package crud;

import entity.Currency;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import utils.HibernateSessionFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
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

    public Currency getCurrency(String Abbreviation){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Currency.class);
        criteria.add(Restrictions.eq("Cur_Abbreviation", Abbreviation));
        Currency currency = (Currency) criteria.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return currency;
    }

    public boolean updateCurrency(Currency currency){
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

    public double conversion(double cost, String Abbreviation){
        Currency currency=getCurrency(Abbreviation);
        double conversionCost;
        double BYN_Cur_Rate = Double.parseDouble(currency.getCurrencyRate());
        int Scale=currency.getCur_Scale();

        conversionCost=cost/BYN_Cur_Rate*Scale;
        conversionCost=conversionCost*100;
        conversionCost= Math.round(conversionCost);
        conversionCost = conversionCost / 100;
        return conversionCost;
    }

}
