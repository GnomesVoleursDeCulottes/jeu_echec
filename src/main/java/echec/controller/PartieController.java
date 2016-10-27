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
import echec.service.PionServiceCrud;
import org.springframework.web.bind.annotation.PathVariable;

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
    private PionServiceCrud servicePion;
    
    @RequestMapping(value = "/lister_parties", method = RequestMethod.GET)
    public String listePartie(Model model){
        model.addAttribute("listePartie", servicePartie.findAll());
        return "parties.jsp";
    }
    
    @RequestMapping(value = "/partie_en_cours",method = RequestMethod.GET)
    public String partieEnCours(Model model, HttpSession s){
        Long joueur = (long) s.getAttribute("idUser");
        model.addAttribute("listePartie", servicePartie.findAllByBlancId(joueur));
        return "_PARTIE_EN_COURS.jsp";
    }
    
    @RequestMapping(value = "/creePartie/{nomPartie}", method = RequestMethod.POST)
    public String creePartie(Model model, HttpSession s, @PathVariable("nomPartie")String nomPartie){
        Long joueur = (long) s.getAttribute("idUser");
        Partie partie = new Partie();
        partie.setNomPartie(nomPartie);
        
        return "creer_partie.jsp";
    }
    
}
