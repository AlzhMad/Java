package servlets;

import db.DBManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Employee> employees = DBManager.getEmployees();
        PrintWriter out = response.getWriter();

        out.println("<table><thead><th>Name</th><th>Surname</th><th>Salary</th><th>Department</th><thead><tbody>");
        for(Employee e : employees){
             out.println("<tr><td>"+e.getName()+"</td><td>"+e.getSurname()+"</td><td>"+e.getSalary()+"</td><td>"+e.getDepartment()+"</td></tr>");
        }
        out.println("</tbody></table>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
