$(document).ready(function () {
    setInterval(function () {
        $("#PEnCours").load("/echec/partie_en_cours");
    }, 1000);
});