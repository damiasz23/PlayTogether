package playTogether.repositorys;

import ogloszeniar.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import playTogether.Player;

import javax.persistence.Query;
import java.util.Optional;

public class PlayerRepository {

    public static Optional<Player> findByEmail(String email){

        Session session = null;

        try {
            session = HibernateUtil.openSession();
            String hgl = "SELECT p FROM Player p WHERE p.id = (SELECT u.id FROM User u WHERE u.email = :email)";
            Query query = (Query) session.createQuery(hgl);
            query.setParameter("email", email);
            return Optional.ofNullable((Player) query.getSingleResult());
        }catch (Exception ex){
            ex.printStackTrace();
            return Optional.empty();
        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }

        }
    }

    public static boolean update(Player player) {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            session.getTransaction().begin();
            session.update(player);
            session.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            return false;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }

        }
    }

    public static Optional<Player> findById(Integer userId){
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            return Optional.ofNullable(session.find(Player.class, userId));

        }catch (Exception ex){
            ex.printStackTrace();
            return Optional.empty();
        }finally {
            if(session!=null && session.isOpen()){
                session.close();
            }
        }
    }
    public static boolean saveOrUpdate(Player player) {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            session.getTransaction().begin();
            session.saveOrUpdate(player);
            session.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            if (session != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            ex.printStackTrace();
            return false;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
