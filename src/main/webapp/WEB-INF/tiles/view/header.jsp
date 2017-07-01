<%
boolean isLoggedIn = (Boolean) request.getAttribute("isLoggedIn");
%>

    <div class="header clearfix">
        <nav>
            <ul class="nav float-right">
                <li class="nav-item">
                    <a class="nav-link active" href="/">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/mail">Mail</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/meetings">Meetings</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/contacts">Contacts</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">APIs</a>
                </li>
                <li class="nav-item">
                    <%if(isLoggedIn){%>
                    <a class="nav-link" href="/logout" >Logout</a>
                    <%}else{%>
                    <a class="nav-link" href="${loginUrl}" >Login</a>
                    <%}%>
                </li>
            </ul>
        </nav>
        <h2 class="text-muted">CFS</h2>
    </div>
