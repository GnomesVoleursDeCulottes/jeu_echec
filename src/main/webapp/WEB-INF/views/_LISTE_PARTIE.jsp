<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>            <%-- A enlever une fois inclus dans la vue --%>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>      <%-- A enlever une fois inclus dans la vue --%>  

<table>
    <tr>
        <td>Nom de la partie</td>
        <td>Nom du joueur adverse</td>
        <td><!-- Ne rien mettre --></td>
    </tr>
    <c:forEach var="partieEnCours" items="${listePartieEnCours}">
        <tr>
            <td>${partieEnCours.nomPartie}</td>
            <td>${partieEnCours.nomJoueur}</td>
            <td><input value="Reprendre Partie" type="button"/></td>
        </tr>
    </c:forEach>
</table>



