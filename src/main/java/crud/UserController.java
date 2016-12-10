package crud;

import entity.Order;
import entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import utils.HibernateSessionFactory;

import java.util.List;

/**
 * Created by Влад on 09.11.2016.
 */
public class UserController {
    private User getUser(String username)
    {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username));
        List<User> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        if (list.size() == 0)
            return null;
        return list.get(0);
    }


    public User addUser(User user){
        User userFromDB = getUser(user.getUsername());
        if (userFromDB != null)
            return null;
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }


    public User checkUser(String login, String password){
        User user = getUser(login);
        if (user == null)
            return null;
        if (user.getPassword().equals(password)){
            return user;
        }
        return null;
    }

    public List<User> getPageOfUsers(int pageNumber, int pageSize){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        criteria.setFirstResult((pageNumber - 1)*pageSize);
        criteria.setMaxResults(pageSize);
        List<User> list = (List<User>) criteria.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    public List<User> getAllUsers(){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        List<User> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    public Integer getPageAmount(int pageSize){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Criteria criteriaCount = session.createCriteria(User.class);
        criteriaCount.setProjection(Projections.rowCount());
        Integer count = (int) (long) (Long) criteriaCount.uniqueResult();
        Integer pageAmount =  (count - 1) / pageSize + 1;
        session.close();
        return pageAmount;
    }

    public Integer getAllUserCount(){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.setProjection(Projections.rowCount());
        Integer count = (int) (long) (Long) criteria.uniqueResult();
        return count;
    }

    public Integer getSimpleUserCount(){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("role", 1));
        criteria.setProjection(Projections.rowCount());
        Integer count = (int) (long) (Long) criteria.uniqueResult();
        return count;
    }

    public User editUser(User user){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }
/**Method for show usernames in admin.ShowOrders**/
/**
    public static String getUsernameByOrder(Order order){

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        long userid = order.getUserId();
        Criteria criteria = session.createCriteria(UserModel.class);
        criteria.add(Restrictions.eq("ID", userid));
        List<UserModel> users = criteria.list();
        session.getTransaction().commit();
        session.close();
        return users.get(0).getUsername();
    }
 **/
}
