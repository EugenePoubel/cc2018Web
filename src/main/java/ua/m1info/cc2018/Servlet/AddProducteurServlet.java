package ua.m1info.cc2018.Servlet;

import ua.m1info.cc2018.Model.Producteur;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddProducteurServlet", value = "/addProducteur")
public class AddProducteurServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward to the form page
        request.getRequestDispatcher("/WEB-INF/addProducteur.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String nom = request.getParameter("nom");
        String pays = request.getParameter("pays");

        // Simple ID generation and session retrieval
        HttpSession session = request.getSession();
        ArrayList<Producteur> producteurs = (ArrayList<Producteur>) session.getAttribute("producteurs");
        if (producteurs == null) {
            producteurs = new ArrayList<>();
            System.out.println("C'est big");
        }
        int id = producteurs.size() + 1;

        // Create a new producer and add to the session
        Producteur newProducteur = new Producteur(id, nom, pays);
        producteurs.add(newProducteur);
        session.setAttribute("producteurs", producteurs);

        response.sendRedirect(request.getContextPath() + "/addCafe");
    }
}
