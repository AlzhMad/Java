package servlets;

import db.DBManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Character;
import models.News;
import models.Species;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AdminPanelServlet", value = "/admin")
public class AdminPanelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<News> news = DBManager.getNewsList(null);
        request.setAttribute("novosti", news);
        request.getRequestDispatcher("/adminPanel.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
