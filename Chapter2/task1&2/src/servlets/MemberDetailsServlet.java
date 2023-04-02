package servlets;

import db.DBManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Member;

import java.io.IOException;

@WebServlet(value = "/details")
public class MemberDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Member m = DBManager.getMember(id);

        if(m!=null){
            request.setAttribute("member", m);
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
