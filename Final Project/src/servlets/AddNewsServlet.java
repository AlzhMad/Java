package servlets;

import db.DBManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.*;
import models.Character;

import java.io.IOException;

@WebServlet(name = "AddNewsServlet", value = "/addNews")
public class AddNewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User)request.getSession().getAttribute("currentUser");
        String redirect ="/home";

        if(user.getRole().equalsIgnoreCase("admin")) {


            String title = request.getParameter("title");
            String contentText = request.getParameter("content");
            Long categoryId = Long.parseLong(request.getParameter("i_category_id"));
            Long languageId = Long.parseLong(request.getParameter("i_language_id"));
            Language language = DBManager.getLanguage(languageId);
            Content content = new Content(null, title, contentText, language);
            Category category = DBManager.getCategory(categoryId);

            DBManager.addNews(new News(null, content, null, category));

            redirect = "/admin?added";
        }

        response.sendRedirect(redirect);

    }
}
