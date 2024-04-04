package ua.m1info.cc2018.Servlet;

import ua.m1info.cc2018.Model.Cafe;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CoffeeDetailServlet", value = "/coffee")
public class CoffeeDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam == null) {
            // Gérer l'erreur ou rediriger si l'ID n'est pas fourni
            response.sendRedirect("errorPage.jsp");
            return;
        }

        int id = Integer.parseInt(idParam);
        HttpSession session = request.getSession();
        List<Cafe> cafes = (List<Cafe>) session.getAttribute("cafes");

        if (cafes != null) {
            Cafe cafe = cafes.stream()
                    .filter(c -> c.getId() == id)
                    .findFirst()
                    .orElse(null);

            if (cafe != null) {
                request.setAttribute("cafe", cafe);
                request.getRequestDispatcher("/WEB-INF/coffeeDetails.jsp").forward(request, response);
            } else {
                // Gérer le cas où aucun café n'est trouvé avec cet ID
                response.sendRedirect("errorPage.jsp");
            }
        } else {
            // Gérer le cas où la liste des cafés n'existe pas
            response.sendRedirect("errorPage.jsp");
        }
    }
}
