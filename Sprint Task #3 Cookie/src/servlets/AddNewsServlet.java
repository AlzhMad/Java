package servlets;

import db.DBManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Character;
import models.News;
import models.Species;

import java.io.IOException;

@WebServlet(name = "AddNewsServlet", value = "/addNews")
public class AddNewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String language = request.getParameter("ln").toLowerCase();

        DBManager.addNews(new News(null, title, content,language, null));

        response.sendRedirect("/admin?added");

    }
}
