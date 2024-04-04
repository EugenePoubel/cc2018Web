package ua.m1info.cc2018.Servlet;

import ua.m1info.cc2018.Model.Cafe;
import ua.m1info.cc2018.Model.Producteur;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddCafeServlet", value = "/addCafe")
public class AddCafeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/addCafe.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        int producteurId = Integer.parseInt(request.getParameter("producteurId"));
        String nom = request.getParameter("nom");
        int intensite = Integer.parseInt(request.getParameter("intensite"));
        int amertume = Integer.parseInt(request.getParameter("amertume"));
        int acidite = Integer.parseInt(request.getParameter("acidite"));
        int corps = Integer.parseInt(request.getParameter("corps"));
        int torrefaction = Integer.parseInt(request.getParameter("torrefaction"));
        String texteDegustation = request.getParameter("texteDegustation");
        int noteGlobale = Integer.parseInt(request.getParameter("noteGlobale"));

        // Retrieve the session and the list of producers
        HttpSession session = request.getSession();

        // Récupération de la liste des producteurs de la session
        ArrayList<Producteur> producteurs = (ArrayList<Producteur>) session.getAttribute("producteurs");
        if (producteurs == null) {
            producteurs = new ArrayList<>();
        }

        // Trouver le producteur correspondant à l'id fourni
        Producteur producteur = null;
        for (Producteur p : producteurs) {
            if (p.getId() == producteurId) {
                producteur = p;
                break; // Sortir de la boucle dès que le producteur est trouvé
            }
        }

        if (producteur == null) {
            // Gérer le cas où aucun producteur n'est trouvé (redirection, message d'erreur, etc.)
            response.sendRedirect("errorPage.jsp"); // Par exemple
            return;
        }


        // Retrieve the list of coffees from the session
        ArrayList<Cafe> cafes = (ArrayList<Cafe>) session.getAttribute("cafes");
        if (cafes == null) {
            cafes = new ArrayList<>();
        }
        int id = cafes.size() + 1;

        // Create a new coffee and add it to the session
        Cafe newCafe = new Cafe(id, nom, producteur, intensite, amertume, acidite, corps, torrefaction, texteDegustation, noteGlobale);
        cafes.add(newCafe);
        session.setAttribute("cafes", cafes);

        // Redirect to the homepage
        response.sendRedirect(request.getContextPath() + "/accueil");
    }
}
