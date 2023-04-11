<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Character" %>
<%@ page import="models.News" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>

    <%@include file="style/head.jsp"%>

</head>

<body>

<%@include file="style/header.jsp"%>

<div class="container" style="min-height: 500px;">

    <div class="row mt-3">

        <div class="col-12">
            <%
                News n = (News) request.getAttribute("novost");
            %>
            <div class="jumbotron">
                <h1 class="display-4"><%=n.getTitle()%></h1>
                <p class="lead"><%=n.getContent()%></p>
                <hr class="my-4">
                <p><%=n.getPostedDate()%></p>
                <br>
                <a class="btn btn-danger  btn-sm" href="/admin" role="button">BACK</a>
            </div>
        </div>

    </div>

</div>

</body>

<%@include file="style/foot.jsp"%>

</html>
