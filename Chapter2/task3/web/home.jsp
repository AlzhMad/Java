<%@ page import="java.util.ArrayList" %>
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
            <div class="jumbotron">
                <h1 class="display-4"><%=n.getTitle()%></h1>
                <p class="lead"><%=n.getContent()%></p>
                <p>Author: <strong><%=n.getAuthor()%></strong></p>
            </div>
            <div class="card"></div>
                            <%
                        }
                    }
                %>

        </div>

    </div>

</div>



<%@include file="style/footer.jsp"%>

</body>

<%@include file="style/foot.jsp"%>

</html>
