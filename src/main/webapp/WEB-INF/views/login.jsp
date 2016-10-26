<%-- 
    Document   : _template
    Created on : 25 oct. 2016, 15:50:29
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Echec - template</title>
        <link href="/echec/CSS/echec.css" rel="stylesheet" type="text/css"/>
        <script src="/echec/JS/jquery-3.1.1.js" type="text/javascript"></script>
    </head>
    <body>
        <c:import url="_HEADER.jsp"/>

        <div id="corps">
            <c:import url="_LOGIN.jsp"/>
        </div>    

        <c:import url="_FOOTER.jsp"/>
    </body>
</html>
