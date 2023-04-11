package servlets;

import db.DBManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.User;

import java.io.IOException;

@WebServlet(name = "AuthServlet", value = "/auth")
public class AuthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/auth.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = DBManager.getUserByEmail(email);

        System.out.println("in "+user.getPassword());

        String redirect="/auth?register";

        if(user != null){
            redirect ="/home?user="+user.getFullName();
            if(!user.getPassword().equals(password)){
                redirect="/auth?wrongPassword";
            }
        }

        response.sendRedirect(redirect);
    }
}
