
            <form:form class="centre" name="formulaire" modelAttribute="JoueurAttr" action="DASHBOARD">
                <div>
                    <label for="pseudo" >Pseudo :</label>
                    <form:input id="pseudo" path="login"/>
                </div>
                <br/>
                <div>
                    <label for="mdp">Mot de passe :</label>
                    <form:input id="mdp" path="mdp"/>
                </div>
                <br/>
                <input type="submit" value="Valider" />
            </form:form>
   
    

