<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header id="head" class="secondary"></header>

<!-- container -->
<div class="container">

    <div class="row">

        <!-- Sidebar -->
        <aside class="col-md-4 sidebar sidebar-left">

            <div class="row widget">
                <div class="col-xs-12">
                    <p>
                        <img src="/resources/images/author_previews/${authorView.photoUrl}"
                             alt=""></p>
                </div>
            </div>
        </aside>
        <!-- /Sidebar -->

        <!-- Article main content -->
        <article class="col-md-8 maincontent">
            <header class="page-header">
                <h1 class="page-title page-header">${authorView.firstName} ${authorView.lastName}</h1>
                <h4 class="page-title">Date of birth: ${authorView.birthDate}</h4>
                <h4 class="page-title page-header">Country: ${authorView.country}</h4>
                <h5 class="page-title">Average client age: ${authorView.averageClientsAge}</h5>
            </header>

            <blockquote>
                Some description here! Numquam, ut iure quia facere totam quas odit illo incidunt. Voluptatem, nostrum,
                ex, quasi incidunt similique cum maxime expedita unde labore inventore excepturi veniam corporis sequi
                facere ullam voluptates amet illum quam fuga voluptatibus ipsum atque sunt eos. Ut, necessitatibus.
            </blockquote>

            <div class="row">
                <div class="col-md-12">
                    <div id="accordion" role="tablist">
                        <div class="card">
                            <div class="card-header" role="tab" id="headingOne">
                                <h5 class="mb-0">
                                    <a data-toggle="collapse" href="#collapseOne" aria-expanded="true"
                                       aria-controls="collapseOne" class="btn btn-primary">Show book list<i
                                            class="fa fa-arrow-down ml-1"></i></a>
                                </h5>
                            </div>
                            <div id="collapseOne" class="collapse " role="tabpanel" aria-labelledby="headingOne"
                                 data-parent="#accordion">
                                <div class="card-body">
                                    <table class="table table-bordered">
                                        <tr>
                                            <th class="text-center">Book name</th>
                                            <th class="text-center">Co-authors</th>
                                            <th class="text-center">Genre</th>
                                            <th class="text-center">Release year</th>
                                            <th class="text-center">Available count</th>
                                        </tr>
                                        <c:forEach var="book" items="${authorView.books}">
                                            <tr>
                                                <td class="text-center">
                                                    <a href="/book/${book.id}">${book.name}</a>
                                                </td>
                                                <c:if test="${!empty book.collaborationAuthors}">
                                                    <td class="text-center">
                                                        <c:forEach var="author" items="${book.collaborationAuthors}">
                                                            <a href="/author/${author.id}">
                                                                    ${author.firstName} ${author.lastName},
                                                            </a>
                                                        </c:forEach>
                                                    </td>
                                                </c:if>

                                                <td class="text-center">${book.genre.genreName}</td>
                                                <td class="text-center">${book.releaseDate.year}</td>
                                                <td class="text-center">${book.availableCount}</td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </article>
        <!-- /Article -->

    </div>
</div>
<!-- /container -->