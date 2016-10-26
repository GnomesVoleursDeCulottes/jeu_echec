/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echec.controller;

import echec.service.JoueurServiceCrud;
import echec.service.PartieServiceCrud;
import echec.service.pionServiceCrud;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Laurent-LIM
 */
@Controller
public class partieController {
    
    @Autowired
    private JoueurServiceCrud serviceJoueur;
    
    @Autowired
    private PartieServiceCrud servicePartie;
    
    @Autowired
    private pionServiceCrud servicePion;
    
    @RequestMapping(value = "/listePartie", method = RequestMethod.GET)
    public String listePartie(Model model){
        model.addAttribute("listePartie", servicePartie.findAll());
        return "parties.jsp";
    }
    
    @RequestMapping(value = "/partieEnCours",method = RequestMethod.GET)
    public String partieEnCours(Model model, HttpSession s){
        Long joueur = (long) s.getAttribute("idUser");
        model.addAttribute("listePartie", servicePartie.findAllByBlancId(joueur));
        return "_partieEnCours.jsp";
    }
    
    
    
    
}
