<%@ page import="models.Character" %>
<%@ page import="models.Character" %>
<%@ page import="models.Species" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>

    <%@include file="style/head.jsp"%>

</head>

<body>

<%@include file="style/header.jsp"%>

<div class="container" style="min-height: 500px;">
    <%
        Character m = (Character)request.getAttribute("character");
    %>

    <div class="row mt-3">

        <div class="col-sm-6 offset-3">
            <%
                String success = request.getParameter("success");
                if(success!=null){
            %>
            <div class="alert alert-success" role="alert">
                The character successfully  saved :)
                <a class="btn btn-primary btn-success" href="/home" role="button">Back</a>
            </div>
            <%
                }
            %>
            <form action="/editCharacter" method="post">
                <input type="hidden" name="id" value="<%=m.getId()%>">
                <div class="form-group">
                    <label>Name:</label>
                    <input type="text" name="name" class ="form-control" value="<%=m.getName()%>">
                    <br>
                </div>
                <div class="form-group">
                    <label>Surname:</label>
                    <input type="text" name="surname" class ="form-control" value="<%=m.getSurname()%>">
                    <br>
                </div>
                <div class="form-group">
                    <label>Species:</label>
                    <select name="i_brand.id" class="form-select" >
                        <%
                            ArrayList<Species> species = (ArrayList<Species>) request.getAttribute("types");
                            for (Species s : species) {
                        %>
                        <option value="<%=s.getId()%>" <%=(m.getSpecies().getId()== s.getId()?"selected":"")%> ><%=s.getName() + "/" + s.getCode()%></option>
                        <%
                            }
                        %>
                    </select>
                    <br>
                </div>
                <div class="form-group">
                    <label>Occupation:</label>
                    <input type="text" name="occupation" class ="form-control" value="<%=m.getOccupation()%>">
                </div>
                <div class="form-group">
                    <br>
                    <button class="btn btn-danger">SAVE</button>
                </div>
            </form>
        </div>

    </div>

</div>


</body>

<%@include file="style/foot.jsp"%>

</html>
