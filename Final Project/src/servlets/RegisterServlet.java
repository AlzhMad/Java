package servlets;

import db.DBManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.User;

import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        if (currentUser == null) {
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
        response.sendRedirect("/home");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("rePassword");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        String redirect = "/register?userExists";

        User user = DBManager.getUserByEmail(email);
        if (user == null) {
            if(password.equals(rePassword)) {
                DBManager.addUser(new User(null, email, password, null, name + " " + surname));
                redirect = "/auth?success";
            }
            else{
                redirect = "/register?passwordMismatch";
            }
        }
        response.sendRedirect(redirect);
    }

}
