<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Member" %>
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
                Member m = (Member)request.getAttribute("member");
            %>
            <div class="jumbotron">
                <h1 class="display-4"><%=m.getName()+ " " + m.getSurname()%></h1>
                <p class="lead"><%=m.getSpecies()%></p>
                <hr class="my-4">
                <p><%=m.getOccupation()%></p>
                <a class="btn btn-primary btn-danger" href="/home" role="button">Back</a>
            </div>
        </div>

    </div>

</div>



<%@include file="style/footer.jsp"%>

</body>

<%@include file="style/foot.jsp"%>

</html>
