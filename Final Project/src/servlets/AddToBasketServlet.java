package servlets;

import db.DBManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Item;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AddToBasketServlet", value = "/addToBasket")
public class AddToBasketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         Long id =  Long.parseLong(request.getParameter("id"));

         HttpSession session = request.getSession();

        ArrayList<Item> basket = (ArrayList<Item>) session.getAttribute("basket");

        if(basket==null){

            basket= new ArrayList<Item>();

        }

        basket.add(DBManager.getItem(id));
        session.setAttribute("basket", basket);

        response.sendRedirect("/shop?added");

    }
}
