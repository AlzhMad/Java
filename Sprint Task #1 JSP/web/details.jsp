<%@ page import="java.util.ArrayList" %>
<%@ page import="servlets.TaskDetailsServlet" %>
<%@ page import="models.Task" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>

  <%@include file="style/head.jsp"%>

</head>

<body>

<%@include file="style/header.jsp"%>

<div class="container" style="min-height: 500px;">
  <div class="row mt-3">
    <div class="col-sm-6 offset-3">
      <%
        Task t = (Task)request.getAttribute("task");
      %>
        <div class="form-group">
          <label>Name:</label>
          <input type="text" name="name" class ="form-control" value="<%=t.getName()%>">
        </div>
        <div class="form-group">
          <label>Description:</label>
          <textarea name="description" class ="form-control" style="min-height: 200px;"><%=t.getDescription()%></textarea>
        </div>
        <div class="form-group">
          <label>Deadline:</label>
          <input type="date" name="deadline" class ="form-control" value="<%=t.getDeadlineDate()%>">
        </div>
        <div class="form-group">
          <label>Status:</label>
          <input type="text" name="isdone" class ="form-control" value=<%=t.getIsDone()%>>
        </div>
        <div class="form-group">
          <br>
          <a class="btn btn-primary btn-dark  "href="/deleteTask?id=<%=t.getId()%>" role="button">DELETE</a>
          <a class="btn btn-primary btn-danger  "href="/home" role="button">BACK</a>
        </div>
    </div>

  </div>
</div>

</body>
</html>