<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Détail du Café</title>
</head>
<body>
<h1>Détail du Café</h1>

<c:if test="${not empty cafe}">
    <p>Nom: ${cafe.nom}</p>
    <p>Producteur: ${cafe.producteur.nom}</p>
    <p>Pays: ${cafe.producteur.pays}</p>
    <p>Note Globale: ${cafe.note}</p>
    <p>Intensité: ${cafe.intensite}</p>
    <p>Amertume: ${cafe.amertume}</p>
    <p>Acidité: ${cafe.acidite}</p>
    <p>Corps: ${cafe.corps}</p>
    <p>Torréfaction: ${cafe.torrefaction}</p>
    <p>Description: ${cafe.description}</p>
</c:if>

<a href="${pageContext.request.contextPath}/">Retour à l'accueil</a>

</body>
</html>
