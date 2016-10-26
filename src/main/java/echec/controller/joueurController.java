/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echec.controller;

import echec.entity.Joueur;
import echec.service.JoueurServiceCrud;
import echec.service.PartieServiceCrud;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author admin
 */
public class joueurController {

    @Autowired
    private JoueurServiceCrud serviceJoueur;

    @Autowired
    private PartieServiceCrud servicePartie;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String finDeSession(Model model, HttpSession s) {
        if (s != null) {
            s.invalidate();
        }
        model.addAttribute("JoueurAttr", new Joueur());
        return "login.jsp";
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.POST)
    public String ajouterMdp(@ModelAttribute("JoueurAttr") Joueur joueur, HttpSession s) {

        Joueur leJoueur = serviceJoueur.findOneByPseudo(joueur.getPseudo());
        if (leJoueur == null) {
            leJoueur = joueur;
            serviceJoueur.save(leJoueur);
        } else if (!leJoueur.getMdp().equals(joueur.getMdp())) {
            throw new RuntimeException("Vous avez entré un mauvais mot de passe, le système vous réclamera 5 euro ===> Cordialement");
        }
        s.setAttribute("idUser", leJoueur.getId());
        return "redirect:/dashboard";

    }
}