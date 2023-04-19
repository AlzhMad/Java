<%@ page import="java.util.ArrayList" %>
<%@ page import="models.*" %>
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
                News n = (News) request.getAttribute("novost");
            %>
            <div class="jumbotron">
                <h1 class="display-4"><%=n.getContent().getTitle()%></h1>
                <p class="lead"><%=n.getContent().getContent()%></p>
                <hr class="my-4">
                <p><%=n.getPostedDate()%></p>
                <br>
                <%if(user!=null){
                    if(user.getRole().equals("admin") &&  request.getParameter("adminPanel")!=null){
                %>
                <a href="/editNews?id=<%=n.getId()%>" class="btn btn-danger btn-sm">EDIT</a>
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-secondary btn-sm" data-toggle="modal" data-target="#deleteModal">
                    DELETE
                </button>

                <!-- Modal -->
                <form action="/deleteNews" method="post">
                    <input type="hidden" name="id" value="<%=n.getId()%>">
                    <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-body">
                                    Are you sure  you want to delete?
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                    <button type="submit" class="btn btn-danger">YES</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
                <%}%>
            </div>

            <form action="/addComment" method="post">
                <div class="shadow-none p-3 mb-5 bg-light rounded">

                       <input type="hidden" name="news_id" value="<%=n.getId()%>">
                       <textarea class="form-control" name="txt" placeholder="Write a comment"></textarea>
                       <button type="submit" class="btn btn-danger mt-3">ADD COMMENT</button>

                </div>
            </form>
            <%}%>

            <%
                ArrayList<Comment> comments = (ArrayList<Comment>) request.getAttribute("comments");
                if (comments != null) {
                    for (Comment c : comments) {
            %>
            <div class="card">
                <div class="card-header">
                    <%=c.getPostDate()%>
                </div>
                <div class="card-body">
                    <blockquote class="blockquote mb-0">
                        <p><%=c.getComment()%></p>
                        <footer class="blockquote-footer"><%=c.getUser().getFullName()%></footer>
                    </blockquote>
                </div>
            </div><br>
            <%}
            }%>

        </div>

    </div>

</div>

</body>

<%@include file="style/foot.jsp"%>

</html>
