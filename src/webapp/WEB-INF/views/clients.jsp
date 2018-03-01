<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header id="head" class="secondary"></header>
<table class="table">
    <thead class="thead-inverse">
    <tr class="text-center">
        <th>Name</th>
        <th>Phone</th>
        <th>Home address</th>
        <th>Age</th>
        <th>Time of library using (days)</th>
        <th>Borrowing books</th>
        <th>Not returned books</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="client" items="${clientViews}">
        <tr>
            <td class="text-center">${client.firstName} ${client.lastName}</td>
            <td class="text-center">${client.phoneNumber}</td>
            <td class="text-center">${client.homeAddress}</td>
            <td class="text-center">${client.usingLibraryDaysCount}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>


