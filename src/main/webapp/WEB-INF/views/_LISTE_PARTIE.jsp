<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>            <%-- A enlever une fois inclus dans la vue --%>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>      <%-- A enlever une fois inclus dans la vue --%>  

<table>
    <tr>
        <td>Nom de la partie</td>
        <td>Nom du joueur adverse</td>
        <td><!-- Ne rien mettre --></td>
    </tr>
  <c:forEach var="partieDispo" items="${listePartie}">
        <tr>
            <td>${partieDispo.nomPartie}</td>
            <td>${partieDispo.blanc.pseudo}</td>
            <td><a href="partie_en_cours/${partieEnCours.id}"><input value="Rejoindre Partie" type="button"/></a></td>
        </tr>
    </c:forEach>
</table>



