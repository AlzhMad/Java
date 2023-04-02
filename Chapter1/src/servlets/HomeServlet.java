package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String name = request.getParameter("name");
         String surname = request.getParameter("surname");
         Integer age = Integer.parseInt(request.getParameter("age"));

         String result = (name+" "+surname+" "+age);

         response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<h1>"+result+"</h1>");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
