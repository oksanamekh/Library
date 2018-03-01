<%--
  Created by IntelliJ IDEA.
  User: Andriy
  Date: 28-Feb-18
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<header id="head" class="secondary"></header>
<!-- container -->
<div class="container">

    <div class="row">

        <!-- Article main content -->
        <article class="col-xs-12 maincontent">
            <header class="page-header">
                <h1 class="page-title">Add the new author</h1>
            </header>

            <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <h3 class="thin text-center">Author registration</h3>

                        <hr>

                        <form:form action="/authorRegistration" method="POST" modelAttribute="newAuthorComponent">
                            <div class="top-margin">
                                <label>Author First Name</label>
                                <form:input type="text" id="firstName" placeholder="Author First Name" class="form-control"
                                            path="firstName"/>
                            </div>
                            <div class="top-margin">
                                <label>Author Last Name</label>
                                <form:input type="text" id="lastName" placeholder="Author Last Name"
                                            class="form-control"
                                            path="lastName"/>
                            </div>

                            <div class="top-margin">
                                <label>Author Birth day<span class="text-danger">*</span></label>
                                <form:input type="date" id="birthDate" class="form-control" path="birthDate"/>
                            </div>

                            <div class="top-margin">
                                <label>Author country<span class="text-danger">*</span></label>
                                <form:input type="text" id="country" placeholder="Author country"
                                            class="form-control"
                                            path="country"/>
                            </div>

                            <div class="top-margin">
                                <label>Photo url<span class="text-danger">*</span></label>
                                <form:input type="text" id="photoUrl" placeholder="Photo url" class="form-control"
                                            path="photoUrl"/>
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
