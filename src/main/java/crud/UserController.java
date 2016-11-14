package crud;

import entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
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
}
