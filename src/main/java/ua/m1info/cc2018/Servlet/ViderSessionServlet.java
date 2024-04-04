package ua.m1info.cc2018.Servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ViderSessionServlet", value = "/viderSession")
public class ViderSessionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtention de la session courante
        HttpSession session = request.getSession();

        // Invalidation de la session pour supprimer tous les attributs
        session.invalidate();

        // Redirection vers la page d'accueil après avoir vidé la session
        response.sendRedirect(request.getContextPath() + "/");
    }
}
