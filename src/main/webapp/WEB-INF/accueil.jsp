<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Accueil Dégustation de Café</title>
</head>
<body>
<h1>Accueil Dégustation de Café</h1>

<!-- Nombre de cafés dégustés -->
<p>Nombre de cafés dégustés : ${sessionScope.cafes.size()}</p>

<!-- Top 5 des cafés préférés -->
<h2>Top 5 des cafés préférés</h2>
<ol>
    <c:forEach var="cafe" items="${topCafes}">
        <li><a href="coffee?id=${cafe.id}">${cafe.nom}</a> - Note Globale : ${cafe.note}</li>
    </c:forEach>
</ol>

<!-- Classement des producteurs -->
<h2>Classement des Producteurs</h2>
<ol>
    <c:forEach var="producteur" items="${requestScope.classementProducteurs}">
        <li>${producteur.nom} - Note Moyenne : ${producteur.noteMoyenne}</li>
    </c:forEach>
</ol>

<!-- Liens pour naviguer -->
<a href="${pageContext.request.contextPath}/addProducteur">Créer un Producteur</a> | <a href="${pageContext.request.contextPath}/addCafe">Créer un Café</a>

<!-- Formulaire de tri des cafés -->
<h3>Trier les cafés</h3>
<form action="${pageContext.request.contextPath}/coffees" method="get">
    <label for="orderby">Trier par:</label>
    <select id="orderby" name="orderby">
        <option value="name">Nom</option>
        <option value="producer">Producteur</option>
        <option value="country">Pays</option>
        <option value="note">Note</option>
        <option value="intensity">Intensité</option>
        <option value="bitterness">Amertume</option>
        <option value="acidity">Acidité</option>
        <option value="body">Corps</option>
        <option value="roasting">Torréfaction</option>
    </select>
    <button type="submit">Trier</button>
</form>


<!-- Lien pour vider la session -->
<form action="viderSession" method="post">
    <button type="submit">Remise à Zéro</button>
</form>

</body>
</html>
