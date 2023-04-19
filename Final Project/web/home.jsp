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
            <%
                ArrayList<News> news = (ArrayList<News>) request.getAttribute("zhanalyki");
                if(news!=null){
                    for(News n : news){
            %>
            <div class="card">
                <div class="container">
                    <h1 class="display-6"><%=n.getContent().getTitle()%></h1>
                    <p class="lead"><%=n.getContent().getContent()%> ... <a href="/newsDetails?id=<%=n.getId()%>" class="text-danger" style="text-decoration: none" >read more</a></p>
                    <p>
                        <% if(n.getContent().getLanguage().getCode().equals("en")){ %>Posted:<%} else {%>Опубликовано:<%}%> <strong><%=n.getPostedDate()%></strong></p>
                </div>
            </div>
            <div class="row"><p></div>
            <%
                    }
                }
            %>

        </div>


    </div>

</div>


</body>

<%@include file="style/foot.jsp"%>

</html>
