<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<header id="head" class="secondary"></header>

<!-- Intro -->
<div class="container text-center">
    <h4 class="thin">You can find best or worst of 4 books by period</h4>
    <form:form action="/books/filter" method="GET" modelAttribute="filter">
        <label>Choose books famous: </label>
        <form:radiobutton path="bookFamous" value="best" label="Best books"/>
        <form:radiobutton path="bookFamous" value="worst" label="Worst books"/>
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <label>Choose period: </label>
                <form:radiobutton path="period" value="week" label="Week"/>
                <form:radiobutton path="period" value="month" label="Month"/>
                <form:radiobutton path="period" value="year" label="Year"/>
            </div>
        </div>
        <label></label>
        <button class="btn btn-action" type="submit">Find</button>
    </form:form>
</div>
<!-- /Intro-->

<!-- Highlights - jumbotron -->
<div class="jumbotron top-space">
    <div class="container">
        <div class="row">
            <c:forEach var="book" items="${books}">
                <!-- BookCard -->
                <a href="/book/${book.id}">
                    <div class="col-md-3 col-sm-6 highlight">
                        <div class="h-caption">
                            <h3>
                                <img src="/resources/images/book_previews/${book.photoUrl}"
                                     alt="">${book.name}
                            </h3>
                        </div>
                        <div class="h-body text-center">
                            <h5 style="color:black">
                                <p>Author: ${book.mainAuthor.firstName} ${book.mainAuthor.lastName}</p>
                                <p>Genre: ${book.genre.genreName}</p>
                                <p>
                                    <c:if test="${book.availableCount > 0}">
                                        ${book.availableCount} books are available
                                    </c:if>
                                </p>
                            </h5>
                        </div>
                    </div>
                </a>
            </c:forEach>
        </div>
        <!-- /row  -->

    </div>
</div>
<!-- /Highlights -->
