package crud;

import entity.Order;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import utils.HibernateSessionFactory;

import java.util.List;

/**
 * Created by Влад on 12.11.2016.
 */
public class OrderController {
    public List<Order> getAllOrders(){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        List<Order> orders = null;
        try {

            orders = (List<Order>)session.createQuery("from Order").list();

        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        return orders;
    }
    public boolean addOrder(Order order){
        return false;
    }
    public List<Order> getUserOrders(long UserId){
        return null;
    }

    public boolean deleteOrder(long OrderId){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Order order = (Order) session.load(Order.class, OrderId);
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
