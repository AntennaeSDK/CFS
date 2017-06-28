<!DOCTYPE HTML>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="javax.servlet.http.HttpServletRequest" %>

<%
//System.out.println("HHHHHHHH");
boolean isLoggedIn = (Boolean) request.getAttribute("isLoggedIn");
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
                    <a class="nav-link" href="/mail">Mail</a>
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

    <div class="jumbotron">

        <p class="lead">
            Enhance day-to-day life of <i><b>software/quality engineers, people/product/program managers</b></i>  by</p>
        <ul>
            <li>Simplifying meetings</li>
            <li>Collecting continuous feedback</li>
            <li>Providing personal metrics</li>
        </ul>
        <p><a class="btn btn-lg btn-success" href="#" role="button">Sign up today</a></p>
    </div>


    <div class="row">
        <div class="col-lg-6">
            <h3>Welcome!</h3>
        </div>
    </div>



    <!--<footer class="footer">-->
            <!--<p>&copy; Company 2017</p>-->
    <!--</footer>-->

</div> <!-- /container -->


</body>


</html>
