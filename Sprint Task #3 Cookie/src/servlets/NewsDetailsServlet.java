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

@WebServlet(name = "NewsDetailsServlet", value = "/newsDetails")
public class NewsDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        News news = DBManager.getNews(id);

        if(news!=null){
            request.setAttribute("novost", news);
            request.getRequestDispatcher("/newsDetails.jsp").forward(request,response);
        }
        else{
            response.sendRedirect("/admin");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
