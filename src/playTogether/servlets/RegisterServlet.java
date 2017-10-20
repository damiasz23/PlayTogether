package playTogether.servlets;

import playTogether.*;
import playTogether.repositorys.PlayerRepository;
import playTogether.repositorys.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String passwordRepeat = req.getParameter("passwordRepeat");
        String nickName = req.getParameter("nickName");
        String dayOfBirth = req.getParameter("dayOfBirth");


        Optional<User> userByEmail = UserRepository.findUserByEmail(email);

        HashMap<String, String> errors = new HashMap<>();
        Boolean isValid = true;
        if(email == null || email.isEmpty()){
            isValid = false;
            errors.put("email", "Wrong email");
        }
        else if(userByEmail.isPresent()){
            isValid = false;
            errors.put("email", "Email already exist");
        }
        if(password == null || password.isEmpty() || password.length() < 6){
            isValid = false;
            errors.put("password", "Password is too short, min 6 characters");
        }
        if(passwordRepeat == null || passwordRepeat.isEmpty()|| !password.equals(passwordRepeat)){
            isValid = false;
            errors.put("passwordRepeat", "Password must be the same");
        }
        if(nickName == null || nickName.isEmpty()){
            isValid = false;
            errors.put("firstName", "Add first name");
        }

        if(dayOfBirth == null || dayOfBirth.isEmpty()){
            isValid = false;
            errors.put("dayOfBirth", "Add date of birth");
        }

        if(!isValid){

            HashMap<String, String> variable = new HashMap<>();
            variable.put("email",email);
            variable.put("nickName",nickName);

            req.setAttribute("variable",variable);
            req.setAttribute("error", errors);
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }
        else {
            User user = new User(email, password);
            UserRepository.save(user);
            Optional<Player> customerOptional = PlayerRepository.findByEmail(email);
            if(customerOptional.isPresent()){
                Player player = customerOptional.get();
                player.setBirthday(ProjectUtil.parseDateFromCalendar(dayOfBirth).toLocalDateTime());
                player.setNickName(nickName);
                PlayerRepository.saveOrUpdate(player);
                resp.sendRedirect("login.jsp");
            }else {
                resp.sendRedirect("register.jsp");
            }
        }
    }
}
