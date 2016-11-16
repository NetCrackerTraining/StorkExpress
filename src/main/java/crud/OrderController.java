package crud;

import entity.Order;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import utils.HibernateSessionFactory;

import java.util.List;


public class OrderController {
    public List<Order> getAllOrders(){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        List<Order> orders = null;
        Criteria criteria = session.createCriteria(Order.class);
        try {
            orders = criteria.list();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
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
        return order;
    }

    public List<Order> getUserOrders(long UserId){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Order.class);
        criteria.add(Restrictions.eq("ID", UserId));
        List<Order> orders = criteria.list();
        session.getTransaction().commit();
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
        return true;
    }
    public boolean updateOrder(Order order){
        return false;
    }
}
