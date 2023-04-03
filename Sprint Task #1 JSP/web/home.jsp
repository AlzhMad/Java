<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Task" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>

    <%@include file="style/head.jsp"%>

</head>

<body>

<%@include file="style/header.jsp"%>
<div class="container">
    <div class="row mt-3">
        <div class="col-12">
            <%
                String added = request.getParameter("addTask");
                if(added!=null){
            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong>The task successfully  added :)</strong>
                <button type="close" class="close" data-dismiss="alert" aria-label="Close" style="background-color: transparent; border-color: transparent">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <%
                }
            %>

            <%
                String deleted = request.getParameter("deleteTask");
                if(deleted!=null){
            %>
            <div class="alert alert-dark alert-dismissible fade show" role="alert">
                <strong>The task successfully  deleted :)</strong>
                <button type="close" class="close" data-dismiss="alert" aria-label="Close" style="background-color: transparent; border-color: transparent">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <%
                }
            %>
            <button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#myModal">+ADD TASK</button>
                <div class="modal" tabindex="-1" id="myModal">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">New Task</h5>
                            </div>
                            <div class="modal-body">
                                <form action="/addTask" method="post">

                                    <div class="form-group">
                                        <label>Name:</label>
                                        <input type="text" name="name" class ="form-control" required>
                                        <br>
                                    </div>
                                    <div class="form-group">
                                        <label>Description:</label>
                                        <textarea name="description" class ="form-control" required></textarea>
                                        <br>
                                    </div>
                                    <div class="form-group">
                                        <label>Deadline:</label>
                                        <input type="date" name="deadline" class ="form-control" required>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        <button type="submit" class="btn btn-danger">Add</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            <div class="row"><p></div>
            <table class="table" >
                <thead>
                <tr>
                    <th>ID</th>
                    <th>NAME</th>
                    <th>DEADLINE</th>
                    <th>DONE</th>
                    <th>DETAILS</th>
                </tr>
                </thead>
                <tbody>
                <%
                    ArrayList<Task> tasks = (ArrayList<Task>) request.getAttribute("jumys");
                    if(tasks!=null){
                        for(Task t : tasks){
                %>
                <tr>
                    <td>
                        <%=t.getId()%>
                    </td>
                    <td>
                        <%=t.getName()%>
                    </td>
                    <td>
                        <%=t.getDeadlineDate()%>
                    </td>
                    <td>
                        <%=t.getIsDone()%>
                    </td>
                    <td>
                        <a href="/details?id=<%=t.getId()%>" class="btn btn-danger btn-sm">DETAILS</a>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
