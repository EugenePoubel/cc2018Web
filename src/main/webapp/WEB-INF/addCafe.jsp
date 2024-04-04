<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Coffee</title>
</head>
<body>
<h2>Add a new Coffee</h2>
<form action="addCafe" method="post">
    <div>
        <%--@declare id="producteur"--%><label for="producteur">Producer:</label>
        <select id="producteurId" name="producteurId" required>
            <c:forEach var="producteur" items="${sessionScope.producteurs}">
                <option value="${producteur.id}">${producteur.nom}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <label for="nom">Name:</label>
        <input type="text" id="nom" name="nom" required>
    </div>
    <div>
        <label for="intensite">Intensity (1-10):</label>
        <input type="number" id="intensite" name="intensite" min="1" max="10" required>
    </div>
    <div>
        <label for="amertume">Bitterness (1-5):</label>
        <input type="number" id="amertume" name="amertume" min="1" max="5" required>
    </div>
    <div>
        <label for="acidite">Acidity (1-5):</label>
        <input type="number" id="acidite" name="acidite" min="1" max="5" required>
    </div>
    <div>
        <label for="corps">Body (1-5):</label>
        <input type="number" id="corps" name="corps" min="1" max="5" required>
    </div>
    <div>
        <label for="torrefaction">Roasting (1-5):</label>
        <input type="number" id="torrefaction" name="torrefaction" min="1" max="5" required>
    </div>
    <div>
        <label for="texteDegustation">Tasting Notes:</label>
        <textarea id="texteDegustation" name="texteDegustation" required></textarea>
    </div>
    <div>
        <label for="noteGlobale">Overall Rating (0-5):</label>
        <input type="number" id="noteGlobale" name="noteGlobale" min="1" max="5" required>
    </div>
    <div>
        <input type="submit" value="Submit">
    </div>
</form>
</body>
</html>
