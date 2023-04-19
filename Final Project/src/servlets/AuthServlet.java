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

        String redirect="/auth?register";

        if(user != null){
            if(!user.getPassword().equals(password)){
                redirect="/auth?wrongPassword";
            }else{
                HttpSession session = request.getSession();
                session.setAttribute("currentUser", user);
                redirect ="/home";
            }
        }

        response.sendRedirect(redirect);
    }
}
