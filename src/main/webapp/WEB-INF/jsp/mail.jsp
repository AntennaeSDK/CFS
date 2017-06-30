<!DOCTYPE HTML>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="org.github.antennae.cfs.microsoft.Message" %>

<%
Boolean isLoggedIn = (Boolean) request.getAttribute("isLoggedIn");
Message[] messages = (Message[]) request.getAttribute("messages");

System.out.println("loggedin = "+ isLoggedIn );
System.out.println("messages = " + messages.length);
%>


<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Home</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>


    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
          crossorigin="anonymous"/>

    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"
            integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
            integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
            integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="/css/main.css"/>


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
                    <a class="nav-link" href="/meetings">Meetings</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">APIs</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Register</a>
                </li>
                <li class="nav-item">
                    <%if(isLoggedIn){%>
                    <a class="nav-link" href="/logout">Logout</a>
                    <%}else{%>
                    <a class="nav-link" href="/login">Login</a>
                    <%}%>
                </li>
            </ul>
        </nav>
        <h2 class="text-muted">CFS</h2>
    </div>

    <div class="row">
        <div class="col-lg-12">
            <h3>Microsoft Auth</h3>

            <B>Inbox</B>
            <table class="table">
                <thead>
                    <tr>
                        <th><span class="glyphicon glyphicon-envelope"></span></th>
                        <th>From</th>
                        <th>Subject</th>
                        <th>Received</th>
                        <th>Preview</th>
                    </tr>
                </thead>
                <tbody>
                    <%for( Message m : messages){%>
                    <tr class="info">
                        <td>
                            <span class="glyphicon glyphicon-envelope"></span>
                        </td>
                        <td>
                            <%=m.getFrom().getEmailAddress().getName()%>
                        </td>
                        <td>
                            <%=m.getSubject()%>
                        </td>
                        <td>
                            <%=m.getReceivedDateTime()%>
                        </td>
                        <td>
                            <%=m.getBodyPreview()%>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </div>

</div> <!-- /container -->


</body>


</html>
