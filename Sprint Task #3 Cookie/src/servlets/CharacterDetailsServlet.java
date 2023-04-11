package servlets;

import db.DBManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Character;
import models.Species;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/characterDetails")
public class CharacterDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Species> species = DBManager.getSpeciesList();
        request.setAttribute("types", species);
        Long id = Long.parseLong(request.getParameter("id"));
        Character m = DBManager.getCharacter(id);

        if(m!=null){
            request.setAttribute("character", m);
            request.getRequestDispatcher("/characterDetails.jsp").forward(request,response);
        }
        else{
            request.getRequestDispatcher("/home.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
