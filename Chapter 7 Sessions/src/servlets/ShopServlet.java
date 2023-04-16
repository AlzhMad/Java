package servlets;

import db.DBManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Item;
import models.Species;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ShopServlet", value = "/shop")
public class ShopServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Item> items = DBManager.geItemsList();
        request.setAttribute("zattar", items);
        request.getRequestDispatcher("/shop.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
