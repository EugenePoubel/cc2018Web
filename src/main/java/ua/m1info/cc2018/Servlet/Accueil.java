package ua.m1info.cc2018.Servlet;

import ua.m1info.cc2018.Model.Cafe;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@WebServlet(name = "accueilServlet", value = "/accueil")
public class Accueil extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // Récupérer la liste des cafés de la session
        List<Cafe> cafes = (List<Cafe>) session.getAttribute("cafes");
        if (cafes == null) {
            request.getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
            return;
        }

        // Tri des cafés par note globale décroissante
        Collections.sort(cafes, new Comparator<Cafe>() {
            @Override
            public int compare(Cafe cafe1, Cafe cafe2) {
                return Integer.compare(cafe2.getNote(), cafe1.getNote());
            }
        });

        // Récupérer les 5 premiers si la liste contient au moins 5 éléments
        List<Cafe> topCafes = new ArrayList<>(cafes.subList(0, Math.min(5, cafes.size())));

        // Passer la liste des 5 meilleurs cafés à la requête
        request.setAttribute("topCafes", topCafes);

        // Rediriger vers la page JSP
        request.getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
    }
}
