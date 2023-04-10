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
                String user = request.getParameter("user");
                if(user!=null){
            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong>Welcome <%=user%></strong>
                <button type="close" class="close" data-dismiss="alert" aria-label="Close" style="background-color: transparent; border-color: transparent">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <%
                }
            %>

            <%
                if(request.getParameter("deleted")!=null){
            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong>The task successfully  deleted :)</strong>
                <button type="close" class="close" data-dismiss="alert" aria-label="Close" style="background-color: transparent; border-color: transparent">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <%
                }
            %>
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
            <button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#myModal">+ADD CHARACTER</button>
            <div class="modal" tabindex="-1" id="myModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">New Character</h5>
                        </div>
                        <div class="modal-body">
                            <form action="/addCharacter" method="post">
                                <div class="form-group">
                                    <label>Name:</label>
                                    <input type="text" name="name" class ="form-control">
                                    <br>
                                </div>
                                <div class="form-group">
                                    <label>Surname:</label>
                                    <input type="text" name="surname" class ="form-control">
                                    <br>
                                </div>
                                <div class="form-group">
                                    <label>Species:</label>
                                    <select name="i_species_id" class="form-control">
                                        <%
                                            ArrayList<Species> species = (ArrayList<Species>) request.getAttribute("types");
                                            for (Species s : species) {
                                        %>
                                        <option value="<%=s.getId()%>"><%=s.getName() + " / "+s.getCode()%></option>
                                        <%
                                            }
                                        %>
                                    </select>
                                    <br>
                                </div>
                                <div class="form-group">
                                    <label>Occupation:</label>
                                    <input type="text" name="occupation" class ="form-control">
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
                    <th>NAME</th>
                    <th>SURNAME</th>
                    <th>SPECIES</th>
                    <th>OCCUPATION</th>
                    <th>DETAILS</th>
                </tr>
                </thead>
                <tbody>
                <%
                    ArrayList<Character> characters = (ArrayList<Character>) request.getAttribute("cast");
                    if(characters !=null){
                        for(Character m : characters){
                            %>
                            <tr>
                                <td>
                                    <%=m.getId()%>
                                </td>
                                <td>
                                    <%=m.getName()%>
                                </td>
                                <td>
                                    <%=m.getSurname()%>
                                </td>
                                <td>
                                    <%=m.getSpecies().getName()%>
                                </td>
                                <td>
                                    <%=m.getOccupation()%>
                                </td>
                                <td style="width: 220px">
                                    <a href="/characterDetails?id=<%=m.getId()%>" class="btn btn-danger btn-sm">DETAILS</a>
                                    <a href="/editCharacter?id=<%=m.getId()%>" class="btn btn-danger btn-sm">EDIT</a>
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
