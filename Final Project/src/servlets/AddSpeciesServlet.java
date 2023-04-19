package servlets;

import db.DBManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Character;
import models.Species;

import java.io.IOException;

@WebServlet(name = "AddSpeciesServlet", value = "/addSpecies")
public class AddSpeciesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("code");
        String surname = request.getParameter("name");

        DBManager.addSpecies(new Species(null, name, surname));

        response.sendRedirect("/species?added");
    }
}
