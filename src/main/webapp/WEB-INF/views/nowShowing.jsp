<%-- 
    Document   : cinemaView
    Created on : Dec 7, 2016, 5:34:40 PM
    Author     : Falcon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><c:out value="${cinemas.name}"/></h1>
        <h2>${cinemas.id}</h2>
        <h2>${cinemas.halls}</h2>
        
        <p>${data}</p>
    </body>
</html>