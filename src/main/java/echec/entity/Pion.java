/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echec.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Laurent-LIM
 */
@Entity
public class Pion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    public enum Couleur{
        Blanc, Noir
    }
    
    @Enumerated(EnumType.STRING)
    private Couleur couleur;
    
    private String PositionX;
    
    private short PositionY;

    @ManyToOne
    @JoinColumn(name = "ID_PARTIE")
    private Partie partie;

    public Partie getPartie() {
        return partie;
    }

    public void setPartie(Partie partie) {
        this.partie = partie;
    }
    
    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    public String getPositionX() {
        return PositionX;
    }

    public void setPositionX(String PositionX) {
        this.PositionX = PositionX;
    }

    public short getPositionY() {
        return PositionY;
    }

    public void setPositionY(short PositionY) {
        this.PositionY = PositionY;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Pion)) {
            return false;
        }
        Pion other = (Pion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Pion[ id=" + id + " ]";
    }
    
}
