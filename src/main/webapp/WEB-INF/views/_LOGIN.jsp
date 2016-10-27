<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form class="centre" name="formulaire" modelAttribute="JoueurAttr" action="dashboard">
    <div>
        <label for="pseudo" >Pseudo :</label>
        <form:input id="pseudo" path="pseudo"/>
    </div>
    <br/>
    <div>
        <label for="mdp">Mot de passe :</label>
        <form:input id="mdp" path="mdp"/>
    </div>
    <br/>
    <input type="submit" value="Se connecter" />
</form:form>



