package ua.m1info.cc2018.Servlet;

import ua.m1info.cc2018.Model.Cafe;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@WebServlet(name = "ListCafesServlet", value = "/coffees")
public class ListCafesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Cafe> cafes = (List<Cafe>) session.getAttribute("cafes");
        String orderby = request.getParameter("orderby");

        if (cafes != null) {
            Comparator<Cafe> comparator = getComparator(orderby);
            cafes.sort(comparator);
        }

        request.setAttribute("cafes", cafes);
        request.getRequestDispatcher("/WEB-INF/listCafes.jsp").forward(request, response);
    }

    private Comparator<Cafe> getComparator(String orderby) {
        switch (orderby) {
            case "name":
                return Comparator.comparing(Cafe::getNom);
            case "producer":
                return Comparator.comparing(cafe -> cafe.getProducteur().getNom());
            case "country":
                return Comparator.comparing(cafe -> cafe.getProducteur().getPays());
            case "note":
                return Comparator.comparingDouble(Cafe::getNote).reversed();
            case "intensity":
                return Comparator.comparingInt(Cafe::getIntensite).reversed();
            case "bitterness":
                return Comparator.comparingInt(Cafe::getAmertume).reversed();
            case "acidity":
                return Comparator.comparingInt(Cafe::getAcidite).reversed();
            case "body":
                return Comparator.comparingInt(Cafe::getCorps).reversed();
            case "roasting":
                return Comparator.comparingInt(Cafe::getTorrefaction).reversed();
            default:
                return Comparator.comparingInt(Cafe::getId); // Fallback to default sorting
        }
    }
}
