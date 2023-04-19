<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Character" %>
<%@ page import="models.Species" %>
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
            <h1>Hi <%=user.getFullName()%>!</h1>
            </div>



        </div>


    </div>

</div>


</body>

<%@include file="style/foot.jsp"%>

</html>
