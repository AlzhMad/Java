package servlets;

import db.DBManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Comment;
import models.User;

import java.io.IOException;

@WebServlet(name = "AddCommentServlet", value = "/addComment")
public class AddCommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long newsId = Long.parseLong(request.getParameter("news_id"));
        String txt = request.getParameter("txt");
        User user =  (User) request.getSession().getAttribute("currentUser");
        if(user!=null) {

            DBManager.addComment(new Comment(null, txt, null, user, newsId));
        }

        response.sendRedirect("/newsDetails?id="+newsId);
    }
}
