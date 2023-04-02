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

        <div class="col-12">
            <table class="table" >
                <thead>
                <tr>
                    <th>ID</th>
                    <th>NAME</th>
                    <th>SURNAME</th>
                    <th>SPECIES</th>
                    <th>OCCUPATION</th>
                    <th>DETAILS</th>
                </tr>
                </thead>
                <tbody>
                <%
                    ArrayList<Member> members = (ArrayList<Member>) request.getAttribute("cast");
                    if(members!=null){
                        for(Member m : members){
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
                                    <%=m.getSpecies()%>
                                </td>
                                <td>
                                    <%=m.getOccupation()%>
                                </td>
                                <td>
                                    <a href="/details?id=<%=m.getId()%>" class="btn btn-danger btn-sm">DETAILS</a>
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



<%@include file="style/footer.jsp"%>

</body>

<%@include file="style/foot.jsp"%>

</html>
