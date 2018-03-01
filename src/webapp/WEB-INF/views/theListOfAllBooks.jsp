<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header id="head" class="secondary"></header>
<html>
<head>
    <title>All books list</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
</head>
<body>

<table class="table">
    <thead class="thead-inverse">
    <tr class="text-center">
        <th>Title</th>
        <th>Main Author</th>
        <th>Genre</th>
        <th>Release date</th>
        <th>Available count</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <c:forEach var="book" items="${books}">
    <tr>
        <td>${book.name}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
