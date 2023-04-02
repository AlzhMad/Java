<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Member" %>
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
                String success = request.getParameter("success");
                if(success!=null){
            %>
            <div class="alert alert-success" role="alert">
                The member successfully  added :)
                <a class="btn btn-primary btn-success" href="/home" role="button">Back</a>
            </div>
            <%
                }
            %>
           <form action="/addMember" method="post">
               <div class="form-group">
                   <label>Name:</label>
                   <input type="text" name="name" class ="form-control">
               </div>
               <div class="form-group">
                   <label>Surname:</label>
                   <input type="text" name="surname" class ="form-control">
               </div>
               <div class="form-group">
                   <label>Species:</label>
                   <input type="text" name="species" class ="form-control">
               </div>
               <div class="form-group">
                   <label>Occupation:</label>
                   <input type="text" name="occupation" class ="form-control">
               </div>
               <div class="form-group">
                   <br>
                   <button class="btn btn-danger">ADD MEMBER</button>
               </div>
           </form>
        </div>

    </div>

</div>



<%@include file="style/footer.jsp"%>

</body>

<%@include file="style/foot.jsp"%>

</html>
