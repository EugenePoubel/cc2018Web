<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Producer</title>
</head>
<body>
<h2>Add a new Producer</h2>
<form action="addProducteur" method="post">
    <div>
        <label for="nom">Name:</label>
        <input type="text" id="nom" name="nom" required>
    </div>
    <div>
        <label for="pays">Country:</label>
        <input type="text" id="pays" name="pays" required>
    </div>
    <div>
        <input type="submit" value="Submit">
    </div>
</form>
</body>
</html>
