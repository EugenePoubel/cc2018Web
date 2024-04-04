<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Liste des Cafés</title>
</head>
<body>
<h1>Liste des Cafés</h1>

<c:if test="${not empty cafes}">
    <ul>
        <c:forEach var="cafe" items="${cafes}">
            <li>
                <a href="coffee?id=${cafe.id}">${cafe.nom}</a> -
                <a href="producer?id=${cafe.producteur.id}">${cafe.producteur.nom}</a>
            </li>
        </c:forEach>
    </ul>
</c:if>

<a href="${pageContext.request.contextPath}/">Retour à l'accueil</a>

</body>
</html>
