<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>

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
      if(request.getParameter("userExists")!=null){
      %>
      <div class="alert alert-danger alert-dismissible fade show" role="alert">
        <strong>User exists! :)</strong>
      </div>
      <%
        }
      %>

      <%
        if(request.getParameter("passwordMismatch")!=null){
      %>
      <div class="alert alert-danger alert-dismissible fade show" role="alert">
        <strong>Passwords do not match! :)</strong>
      </div>
      <%
        }
      %>

      <form action="/register" method="post">
        <div class="form-group">
          <label>Name:</label>
          <input type="text" name="name" class ="form-control" required>
          <br>
        </div>
        <div class="form-group">
          <label>Surname:</label>
          <input type="text" name="surname" class ="form-control" required>
          <br>
        </div>
        <div class="form-group">
          <label>Email:</label>
          <input type="text" name="email" class ="form-control" required>
          <br>
        </div>
        <div class="form-group">
          <label>Password:</label>
          <input type="password" name="password" class ="form-control" required>
          <br>
        </div>
        <div class="form-group">
          <label>Repeat Password:</label>
          <input type="password" name="rePassword" class ="form-control" required>
        </div>
        <div class="form-group">
          <br>
          <button type="submit" class="btn btn-danger">SIGN UP</button>
        </div>
      </form>

    </div>

  </div>

</div>


</body>

<%@include file="style/foot.jsp"%>

</html>
