package playTogether.repositorys;

import ogloszeniar.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import playTogether.User;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.Optional;

public class UserRepository {
    public static Optional<User> findUserByEmail(String email){
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            String hgl = "SELECT u FROM User u WHERE u.email = :email";
            Query query = session.createQuery(hgl);
            query.setParameter("email", email);
            return Optional.ofNullable((User) query.getSingleResult());
        }catch (NoResultException nre){
            return Optional.empty();
        }catch (Exception ex){
            ex.printStackTrace();
            return Optional.empty();
        }finally {
            if(session !=null && session.isOpen()){
                session.close();
            }
        }
    }

    public static Optional<User> findUserByEmailAndPassword(String email, String password){

        Session session = null;

        try {
            session = HibernateUtil.openSession();
            String hgl = "SELECT u FROM User u WHERE u.email = :email AND u.password = :password";
            Query query = session.createQuery(hgl);
            query.setParameter("email", email);
            query.setParameter("password", password);
            return Optional.ofNullable((User) query.getSingleResult());



        }catch (NoResultException nre){
            return Optional.empty();
        }catch (Exception ex){
            ex.printStackTrace();
            return Optional.empty();
        }finally {
            if(session !=null && session.isOpen()){
                session.close();
            }
        }
    }

    public static boolean save(User user){
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            session.save(user);
            return true;

        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }finally {
            if(session !=null && session.isOpen()){
                session.close();
            }
        }
    }
}
