package servlets;

import db.DBManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Character;
import models.Species;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/addCharacter")
public class AddCharacterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        Long speciesId =Long.parseLong(request.getParameter("i_species_id"));
        Species species = DBManager.getSpecies(speciesId);
        String occupation = request.getParameter("occupation");

        DBManager.addCharacter(new Character(null, name, surname,occupation, species));

        response.sendRedirect("/home?added");
    }
}
