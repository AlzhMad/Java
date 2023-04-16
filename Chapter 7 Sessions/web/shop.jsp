<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Character" %>
<%@ page import="models.Species" %>
<%@ page import="models.Item" %>
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
                <strong>The item successfully  added to card :)</strong>
                <button type="close" class="close" data-dismiss="alert" aria-label="Close" style="background-color: transparent; border-color: transparent">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <%
                }
            %>
            <div class="row row-cols-1 row-cols-md-3">
                <%
                    ArrayList<Item> items = (ArrayList<Item>) request.getAttribute("zattar");
                    if(items !=null){
                        for(Item i : items){
                %>

                <div class="col mb-4">
                    <div class="card h-100">
                        <div class="card-body">
                            <form action="/addToBasket" method="post">
                            <input type="hidden" name ="id" value="<%=i.getId()%>">
                            <h5 class="card-title"><%=i.getName()%></h5>
                            <p class="card-text"><%=i.getPrice()%> USD</p>
                            <button type="submit" class="btn btn-danger btn-sm">ADD TO CARD</button>
                            </form>
                        </div>
                    </div>
                </div>

                <%
                        }
                    }
                %>
            </div>

        </div>

    </div>

</div>


</body>

<%@include file="style/foot.jsp"%>

</html>
