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

            <a class="nav-link" href="/home" style="color: red">News</a>

          </li>

          <li class="nav-item">

            <a class="nav-link" href="/characters" style="color: red">Characters</a>

          </li>

          <li class="nav-item">

            <a class="nav-link" href="/species" style="color:red">Species</a>

          </li>

          <li class="nav-item">

            <a class="nav-link" href="/admin" style="color: red;">Admin Panel</a>

          </li>
          <% String name = (String) request.getAttribute("imya");
             if(name==null){%>

            <li class="nav-item">

              <a class="nav-link" href="/auth" style="color: white;">Sign In</a>

            </li>

            <%} else {%>

          <li class="nav-item">

            <a class="nav-link" href="/home" style="color: white;"><%=name%></a>

          </li>
          <%}%>

          <li class="nav-item">

            <a class="nav-link" href="/cookie?ln=en" style="color: white;">EN</a>

          </li>
          <li class="nav-item">

            <a class="nav-link" href="/cookie?ln=ru" style="color: white;">RU</a>

          </li>

        </ul>

    </div>

  </nav>

</div>