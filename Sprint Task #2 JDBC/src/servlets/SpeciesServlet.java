package servlets;

import db.DBManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Character;
import models.Species;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SpeciesServlet", value = "/species")
public class SpeciesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Species> species = DBManager.getSpeciesList();
        request.setAttribute("creatures", species);
        request.getRequestDispatcher("/species.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
