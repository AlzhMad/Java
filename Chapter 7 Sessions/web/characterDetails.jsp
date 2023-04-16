<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Character" %>
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
                Character m = (Character)request.getAttribute("character");
            %>
            <div class="jumbotron">
                <h1 class="display-4"><%=m.getName()+ " " + m.getSurname()%></h1>
                <p class="lead"><%=m.getSpecies().getName()%></p>
                <hr class="my-4">
                <p><%=m.getOccupation()%></p>
                <br>
                <a class="btn btn-danger  btn-sm" href="/home" role="button">BACK</a>
                <a href="/editCharacter?id=<%=m.getId()%>" class="btn btn-danger btn-sm">EDIT</a>
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-secondary btn-sm" data-toggle="modal" data-target="#deleteModal">
                    DELETE
                </button>

                <!-- Modal -->
                <form action="/deleteCharacter" method="post">
                    <input type="hidden" name="id" value="<%=m.getId()%>">
                    <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-body">
                                    Are you sure  you want to delete <%=m.getName()+" "+m.getSurname()%>?
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                    <button type="submit" class="btn btn-danger">YES</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>

            </div>
        </div>

    </div>

</div>

</body>

<%@include file="style/foot.jsp"%>

</html>
