package servlets;

import db.DBManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Member;

import java.io.IOException;

@WebServlet(value = "/addMember")
public class AddMemberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/addMember.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String species = request.getParameter("species");
        String occupation = request.getParameter("occupation");

        DBManager.addMember(new Member(null, name, surname,species,occupation));

        response.sendRedirect("/addMember?success");
    }
}
