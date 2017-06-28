<!DOCTYPE HTML>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="javax.servlet.http.HttpServletRequest" %>

<%
    boolean isLoggedIn = (Boolean) request.getAttribute("isLoggedIn");
    String name = (String) request.getAttribute("name");
    String email = (String) request.getAttribute("email");
%>


<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Home</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />



    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
          crossorigin="anonymous" />

    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"
            integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
            integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
            integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="/css/main.css" />


</head>
<body>

<div class="container">
    <div class="header clearfix">
        <nav>
            <ul class="nav float-right">
                <li class="nav-item">
                    <a class="nav-link active" href="/">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/mail">mail</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">APIs</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Register</a>
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

    <div class="row">
        <div class="col-lg-12">
            <h3>Microsoft Auth</h3>

                <p>Login Successful</p>

                <div>
                    <p>Name: <%=name%> </p>
                    <p>Email: <%=email%> </p>
                </div>
                <!--
                <p>AuthCode</p>
                <p>${authCode}"</p>

                <p>ID Token</p>
                <p>${idToken}</p>

                <p>Access Token</p>
                <p>${accessToken}</p>
                -->
        </div>
    </div>

</div> <!-- /container -->


</body>


</html>
