package playTogether.servlets;

import playTogether.User;
import playTogether.repositorys.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Optional<User> user = UserRepository.findUserByEmailAndPassword(email, password);
        if(user.isPresent()){
            req.getSession().setAttribute("userId", user.get().getId());
        }

        if(user.isPresent()) {
            resp.sendRedirect("index.jsp");
        }else {
            resp.sendRedirect("login.jsp?error=true");
        }
    }
}
