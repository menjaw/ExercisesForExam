<%-- 
    Document   : index
    Created on : 25-02-2017, 21:16:41
    Author     : Menja
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="index.jsp" method="POST">
            <input type="text" name="username" id="username"/>
            <div>       
                <button type="submit">submit</button>
            </div>
        </form>
        
        <c:out value="${requestScope.test}"></c:out>
    </body>
</html>
