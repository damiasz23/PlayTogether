package ogloszenia;

import ogloszeniar.hibernate.util.HibernateUtil;
import playTogether.Player;
import playTogether.User;
import playTogether.repositorys.PlayerRepository;

import java.time.LocalDateTime;

/**
 * Created by Lukasz on 27.09.2017.
 */
public class App {

    public static void main(String[] args) throws Exception {
        HibernateUtil.openSession();

        User user = new User("dam@op.pl", "1234");


    }
}
