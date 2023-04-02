package servlets;

import db.DBManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Employee;

import java.io.IOException;

@WebServlet(name = "AddEmployeeServlet", value = "/add")
public class AddEmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        int salary = Integer.parseInt(request.getParameter("salary"));
        String department = request.getParameter("department");

        DBManager.addEmployee(new Employee(name, surname,salary,department));

        response.sendRedirect("/home");
    }
}
