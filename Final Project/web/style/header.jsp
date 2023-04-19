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

            <a class="nav-link text-white" href="/home">News</a>

          </li>

          <li class="nav-item">

            <a class="nav-link text-white" href="/characters">Characters</a>

          </li>

          <li class="nav-item">

            <a class="nav-link text-white" href="/species">Species</a>

          </li>

          <li class="nav-item">

            <a class="nav-link text-white" href="/shop">Shop</a>

          </li>
          <% User user = (User) session.getAttribute("currentUser");
            if(user!=null){
               if(user.getRole().equals("admin")){%>
          <li class="nav-item">

            <a class="nav-link text-danger" href="/admin">Admin Panel</a>

          </li>

          <%}%>

          <li class="nav-item dropdown">

            <a class="nav-link dropdown-toggle text-danger" href="#" id="navbarDropdown" role="button"

               data-bs-toggle="dropdown" aria-expanded="false">

              <%=user.getFullName()%>

            </a>

            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">

              <li><a class="dropdown-item text-danger" href="/profile">Profile</a></li>

              <li><hr class="dropdown-divider"></li>

              <li><a class="dropdown-item text-danger" href="/logout">Logout</a></li>

            </ul>

          </li>

          <%} else {%>

          <li class="nav-item">

            <a class="nav-link text-white" href="/auth" >Sign In </a>

          </li>
          <li class="nav-item">

            <a class="nav-link text-white" href="/register" >Register</a>

          </li>

          <%}%>
          <li class="nav-item"><a class="nav-link text-white"  href="/cookie?ln=ru">RU</a></li>
          <li class="nav-item" ><a class="nav-link text-white"  href="/cookie?ln=en">EN</a></li>
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

              <%
                if(basket!=null){
              %>
            <div class="dropdown-menu">
              <ul class="list-group list-group-flush">
                <%
                  for(Item i : basket){
                %>
                <li class="list-group-item"><%=i.getName()%><br><%=i.getPrice()%> USD</li>
                <%}%>
              </ul>
            </div>
              <%}%>

          </div>
          </li>
        </ul>
    </div>

  </nav>

</div>