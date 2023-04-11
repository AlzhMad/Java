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
<%
    String user = request.getParameter("user");
    request.setAttribute("imya", user);
%>

<%@include file="style/header.jsp"%>

<div class="container" style="min-height: 500px;">

    <div class="row mt-3">
        <div class="col-12">
            <%
                if( request.getParameter("added")!=null){
            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong>The news successfully  added :)</strong>
                <button type="close" class="close" data-dismiss="alert" aria-label="Close" style="background-color: transparent; border-color: transparent">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <%
                }
            %>
            <button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#myModal">+ADD NEWS</button>
            <div class="modal" tabindex="-1" id="myModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">New Character</h5>
                        </div>
                        <div class="modal-body">
                            <form action="/addNews" method="post">
                                <div class="form-group">
                                    <label>Title:</label>
                                    <input type="text" name="title" class ="form-control">
                                    <br>
                                </div>
                                <div class="form-group">
                                    <label>Content:</label>
                                    <textarea name="content" class ="form-control"  required style="height: 300px"></textarea>
                                    <br>
                                </div>
                                <div class="form-group">
                                    <label>Language:</label>
                                    <select name="ln" class="form-control">
                                        <option>EN</option>
                                        <option>RU</option>
                                    </select>
                                    <br>
                                </div>
                                <div class="form-group">
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        <button type="submit" class="btn btn-danger">Add</button>
                                    </div>
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
                    <th>TITLE</th>
                    <th>POSTED DATE</th>
                    <th>LANGUAGE</th>
                    <th>DETAILS</th>
                </tr>
                </thead>
                <tbody>
                <%
                    ArrayList<News> news = (ArrayList<News>) request.getAttribute("novosti");
                    if(news !=null){
                        for(News n : news){
                %>
                <tr>
                    <td>
                        <%=n.getId()%>
                    </td>
                    <td>
                        <%=n.getTitle()%>
                    </td>
                    <td>
                        <%=n.getPostedDate()%>
                    </td>
                    <td>
                        <%=n.getLanguage()%>
                    </td>
                    <td style="width: 220px">
                        <a href="/newsDetails?id=<%=n.getId()%>" class="btn btn-danger btn-sm">DETAILS</a>
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
