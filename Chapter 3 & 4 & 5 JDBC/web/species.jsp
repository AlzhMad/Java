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
        <div class="col-12">
            <%
                if( request.getParameter("added")!=null){
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
            <button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#myModal">+ADD SPECIES</button>
            <div class="modal" tabindex="-1" id="myModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">New Species</h5>
                        </div>
                        <div class="modal-body">
                            <form action="/addSpecies" method="post">

                                <div class="form-group">
                                    <label>Code:</label>
                                    <input type="text" name="code" class ="form-control" required>
                                    <br>
                                </div>
                                <div class="form-group">
                                    <label>Name:</label>
                                    <input type="text" name="name" class ="form-control" required>
                                    <br>
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
            <table class="table">
                <thead class="thead-light">
                <tr>
                    <th>#</th>
                    <th>CODE</th>
                    <th>NAME</th>
                </tr>
                </thead>
                <tbody>
                <%
                    ArrayList<Species> species = (ArrayList<Species>) request.getAttribute("creatures");
                    if(species !=null){
                        for(Species s : species){
                %>
                <tr>
                    <td>
                        <%=s.getId()%>
                    </td>
                    <td>
                        <%=s.getCode()%>
                    </td>
                    <td>
                        <%=s.getName()%>
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

<%@include file="style/foot.jsp"%>

</html>
