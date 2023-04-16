<%@ page import="models.User" %>
<%@ page import="models.Item" %>
<div class="container">

  <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: black;">

    <div class="container-fluid">

      <a class="navbar-brand" href="/home">Supernatural Universe</a>

      <button class="navbar-toggler" type="button" data-bs-toggle="collapse"

              data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"

              aria-expanded="false" aria-label="Toggle navigation">

        <span class="navbar-toggler-icon"></span>

      </button>


        <ul class="nav justify-content-end">

          <li class="nav-item">

            <a class="nav-link" href="/home" style="color: white">News</a>

          </li>

          <li class="nav-item">

            <a class="nav-link" href="/characters" style="color: white">Characters</a>

          </li>

          <li class="nav-item">

            <a class="nav-link" href="/species" style="color:white">Species</a>

          </li>

          <li class="nav-item">

            <a class="nav-link" href="/shop" style="color: white">Shop</a>

          </li>
          <% User user = (User) session.getAttribute("currentUser");
            if(user!=null){
               if(user.getRole().equals("admin")){%>
          <li class="nav-item">

            <a class="nav-link" href="/admin" style="color: red;">Admin Panel</a>

          </li>

          <%}%>

          <li class="nav-item">

              <a class="nav-link" href="/profile" style="color: white;">Profile</a>

            </li>

          <li class="nav-item">

            <a class="nav-link" href="/logout" style="color: white;">Logout</a>

          </li>


          <%} else {%>

          <li class="nav-item">

            <a class="nav-link" href="/auth" style="color: white;">Sign In</a>

          </li>

          <%}%>

          <li class="nav-item">

            <a class="nav-link" href="/cookie?ln=en" style="color: white;">EN</a>

          </li>
          <li class="nav-item">

            <a class="nav-link" href="/cookie?ln=ru" style="color: white;">RU</a>

          </li>
          <li>
          <div class="btn-group">
            <%
              ArrayList<Item> basket = (ArrayList<Item>) session.getAttribute("basket");
            %>
            <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              Basket
              <%
              if(basket!=null){
              %>
               :<%=basket.size()%>
              <%}%>
            </button>
            <div class="dropdown-menu">
              <%
                if(basket!=null){
              %>
              <ul class="list-group list-group-flush">
                <%
                  for(Item i : basket){
                %>
                <li class="list-group-item"><%=i.getName()%><br><%=i.getPrice()%> USD</li>
                <%}%>
              </ul>
              <%}%>
            </div>
          </div>
          </li>
        </ul>
    </div>

  </nav>

</div>