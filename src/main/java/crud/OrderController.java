package crud;

import entity.Order;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import utils.HibernateSessionFactory;

import java.util.ArrayList;
import java.util.List;


public class OrderController {
    public ArrayList<Order> getAllOrders(){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        ArrayList<Order> orders = null;
        Criteria criteria = session.createCriteria(Order.class);
        try {
            orders = (ArrayList<Order>) criteria.list();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        session.close();
        return orders;
    }
    public Order addOrder(Order order){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            session.save(order);
        }catch (HibernateException e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
        session.getTransaction().commit();
        session.close();
        return order;
    }
    public List<Order> getUserOrders(long UserId){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Order.class);
        criteria.add(Restrictions.eq("userId", UserId));
        List<Order> orders = criteria.list();
        session.getTransaction().commit();
        session.close();
        if (orders.size() == 0)
            return null;
        return orders;
    }
    public boolean deleteOrder(long OrderId){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Order.class);
        criteria.add(Restrictions.eq("ID", OrderId));
        Order order = (Order) criteria.list().get(0);
        try {
            if(null != order) {
                session.delete(order);
            }
            else return false;
        }catch (HibernateException e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        session.close();
        return true;
    }
    public boolean updateOrder(Order order){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            session.update(order);
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
