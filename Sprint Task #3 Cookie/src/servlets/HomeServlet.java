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

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ln = null;
        Cookie[] cookies = request.getCookies();

        if(cookies!=null){

            for(Cookie cookie : cookies){

                if(cookie.getName().equals("ln")){
                    ln = cookie.getValue();
                    break;
                }
            }
        }
        ArrayList<News> news = DBManager.getNewsList(ln);
        request.setAttribute("zhanalyki", news);
        request.getRequestDispatcher("/home.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
