/* 
 * Contient les différentes fonctions liées au jeu
 */

$(document).ready(function () {
    $("tr:even td:odd").css("background-color", "black");
    $("tr:even td:even").css("background-color", "white");
    $("tr:odd td:even").css("background-color", "black");
    $("tr:odd td:odd").css("background-color", "white");
});

/**/
var estLibre = function () {
    return true;
};

var estPrenable = function () {
    return true;
};

var deplacementPion = function () {

};