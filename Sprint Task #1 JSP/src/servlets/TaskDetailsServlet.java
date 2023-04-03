package servlets;

import db.DBManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Task;

import java.io.IOException;


@WebServlet(value = "/details")
public class TaskDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Task t = DBManager.getTask(id);

        if(t!=null){
            request.setAttribute("task", t);
            request.getRequestDispatcher("/details.jsp").forward(request,response);
        }
        else{
            request.getRequestDispatcher("/home.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
