<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<table>
    <tr>
        <td>Nom de la partie</td>
        <td>Nom du joueur</td>
        <td><!-- Ne rien mettre --></td>
    </tr>
    <c:forEach var="partieDispo" items="${listePartie}">
        <tr>
            <td>${partieDispo.nomPartie}</td>
            <td>${partieDispo.nomJoueur}</td>
            <td><input value="Rejoindre Partie" type="button"/></td>
        </tr>
    </c:forEach>
</table>



