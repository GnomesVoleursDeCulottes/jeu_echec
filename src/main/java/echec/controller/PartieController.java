/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echec.controller;

import echec.entity.Partie;
import echec.service.JoueurServiceCrud;
import echec.service.PartieServiceCrud;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import echec.service.PieceServiceCrud;

/**
 *
 * @author Laurent-LIM
 */
@Controller
public class PartieController {

    @Autowired
    private JoueurServiceCrud serviceJoueur;

    @Autowired
    private PartieServiceCrud servicePartie;

    @Autowired
    private PieceServiceCrud servicePion;

    //fonction qui affiche la liste de toutes les parties
    @RequestMapping(value = "/lister_parties", method = RequestMethod.GET)
    public String listePartie(Model model) {
        model.addAttribute("listePartie", servicePartie.findAll());
        return "parties.jsp";
    }

    //fonction qui affiche la listes des parties d'un joueur donné
    @RequestMapping(value = "/partie_en_cours", method = RequestMethod.GET)
    public String partieEnCours(Model model, HttpSession s) {
        Long joueur = (long) s.getAttribute("idUser");
        model.addAttribute("listePartie", servicePartie.findAllByBlancId(joueur));
        return "_PARTIE_EN_COURS.jsp";
    }

    //fonction qui affiche le formulaire de création d'une partie
    @RequestMapping(value = "/cree_partie", method = RequestMethod.GET)
    public String creePartie(Model model, HttpSession s) {
        model.addAttribute("PartieAttribut", new Partie());
        return "creer_partie.jsp";
    }

    //fonction de création d'une partie par validation du formulaire de la page _CREATION_PARTIE.jsps
    @RequestMapping(value = "/cree_partie", method = RequestMethod.POST)
    public String creePartie(@ModelAttribute("PartieAttribut") Partie partie, HttpSession s) {
        Long joueur = (long) s.getAttribute("idUser");
        partie.setBlanc(serviceJoueur.findOne(joueur));
        partie.setEtat(Partie.Etat.Creer);
        servicePartie.save(partie);
        return "redirect:/dashboard";
    }

    @RequestMapping(value = "partie/{id}", method = RequestMethod.GET)
    public String afficherPartie(@PathVariable(value = "id") Long partieId, HttpSession s, Model model) {
        model.addAttribute("laPartie", servicePartie.findOne(partieId));

        return "afficher_partie.jsp";
    }

    //fonction qui permet au joueur 2 de rejoindre la partie du joueur 1
    @RequestMapping(value = "/partie_en_cours/{id}", method = RequestMethod.GET)
    public String rejoindrePartie(Model model, HttpSession s, @PathVariable(value = "id") Long partieId) {
        Partie partie = servicePartie.findOne(partieId);
        Long joueur2 = (long) s.getAttribute("idUser");
        partie.setNoir(serviceJoueur.findOne(joueur2));
        partie.setEtat(Partie.Etat.EnCours);
        // emplacement des pièces a rajouter
        servicePartie.save(partie);
        return "partie/"+ partieId;
    }
}
