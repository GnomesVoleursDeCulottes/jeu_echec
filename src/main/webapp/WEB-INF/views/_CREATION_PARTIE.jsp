<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form class="centre" name="formulaire" modelAttribute="PartieAttribut">
    <div>
        <label for="NomPartie" >Nom de la partie : </label>
        <form:input id="NomPartie" path="NomPartie"/>
    </div>
    <br/>
    <input type="submit" value="Création" />
</form:form>

