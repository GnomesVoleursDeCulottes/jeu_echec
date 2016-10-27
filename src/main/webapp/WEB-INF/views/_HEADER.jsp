<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <h1>ECHEC ET MAT</h1>
    <c:if test="${idUser != null}">
        <c:import url="_MENU.jsp"/>
    </c:if>
</header>