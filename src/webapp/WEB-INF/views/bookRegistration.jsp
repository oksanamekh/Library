<%--
  Created by IntelliJ IDEA.
  User: Andriy
  Date: 28-Feb-18
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header id="head" class="secondary"></header>
<!-- container -->
<div class="container">

    <div class="row">

        <!-- Article main content -->
        <article class="col-xs-12 maincontent">
            <header class="page-header">
                <h1 class="page-title">Add the new book</h1>
            </header>

            <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <h3 class="thin text-center">Add the new book</h3>

                        <hr>

                        <form:form action="/bookRegistration" method="POST" modelAttribute="newBookComponent">
                            <div class="top-margin">
                                <label>Book Title</label>
                                <form:input type="text" id="name" placeholder="Book Title" class="form-control"
                                            path="name"/>
                            </div>
                            <div class="top-margin">
                                <label>Main Author Last Name</label>
                                <form:select class="form-control" path="author" items="${authors}" itemValue="id"
                                             itemLabel="lastName"/>
                            </div>

                            <div class="top-margin">
                                <label>Releade Date<span class="text-danger">*</span></label>
                                <form:input type="date" id="releaseDate" class="form-control" path="releaseDate"/>
                            </div>

                            <div class="top-margin">
                                <label>General Count<span class="text-danger">*</span></label>
                                <form:input type="text" id="generalCount"
                                            placeholder="General Count" class="form-control" path="generalCount"/>
                            </div>

                            <div class="top-margin">
                                <label>Genre<span class="text-danger">*</span></label>
                                <form:select class="form-control" path="genre" items="${genres}" itemValue="id"
                                             itemLabel="genreName"/>
                            </div>

                            <div class="top-margin">
                                <label>Photo url<span class="text-danger">*</span></label>
                                <form:input type="text" id="photoUrl" placeholder="Photo url" class="form-control"
                                            path="photoUrl"/>
                            </div>

                            <div class="top-margin">
                                <label>Pages Amount<span class="text-danger">*</span></label>
                                <form:input type="text" id="pagesAmount" placeholder="Pages Amount" class="form-control"
                                            path="pagesAmount"/>
                            </div>

                            <div class="top-margin">
                                <label>Full Rescription<span class="text-danger">*</span></label>
                                <form:input type="text" id="photoUrl" placeholder="Full Rescription"
                                            class="form-control"
                                            path="fullDescription"/>
                            </div>

                            <hr>

                            <div class="row">
                                <div class="col-lg-4 text-right">
                                    <button class="btn btn-action" type="submit">Add New Book</button>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>

            </div>

        </article>
        <!-- /Article -->

    </div>
</div>
<!-- /container -->
