<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Character" %>
<%@ page import="models.Species" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>

    <%@include file="style/head.jsp"%>

</head>

<body>

<%@include file="style/header.jsp"%>

<div class="container" style="min-height: 500px;">

    <div class="row mt-3">
        <div class="col-4 offset-4">
            <%
                if(request.getParameter("success")!=null){
            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong>You have been successfully registered :)</strong>
            </div>
            <%
                }
            %>

            <%
                if(request.getParameter("register")!=null){
            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong>No user found! You  should register :)</strong>
            </div>
            <%
                }
            %>
            <%
                if( request.getParameter("wrongPassword")!=null){
            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong>Wrong password :)</strong>
            </div>
            <%
                }
            %>
            <form action="/auth" method="post">
            <div class="form-group">
                <label>Email:</label>
                <input type="text" name="email" class ="form-control">
                <br>
            </div>
            <div class="form-group">
                <label>Password:</label>
                <input type="password" name="password" class ="form-control">
                <br>
                <button type="submit" class="btn btn-danger">SIGN IN</button>
            </div>
            </form>

        </div>

    </div>

</div>


</body>

<%@include file="style/foot.jsp"%>

</html>
