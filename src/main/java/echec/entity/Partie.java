/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echec.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Laurent-LIM
 */
@Entity
public class Partie implements Serializable {

     public enum Etat{
        Fini, EnCours, Termine
    }
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nomPartie;
    @Enumerated(EnumType.STRING)
    private Etat etat;

    @ManyToOne
    @JoinColumn(name = "ID_JOUEUR_BLANC")
    private Joueur blanc;
    
    @ManyToOne
    @JoinColumn(name = "ID_JOUEUR_NOIR")
    private Joueur noir;
    
    
    @OneToMany(mappedBy = "partie")
    private List<Pion> pions = new ArrayList<Pion>();

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public Joueur getBlanc() {
        return blanc;
    }

    public void setBlanc(Joueur blanc) {
        this.blanc = blanc;
    }

    public Joueur getNoir() {
        return noir;
    }

    public void setNoir(Joueur noir) {
        this.noir = noir;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Pion> getPions() {
        return pions;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partie)) {
            return false;
        }
        Partie other = (Partie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Partie[ id=" + id + " ]";
    }
    
}
