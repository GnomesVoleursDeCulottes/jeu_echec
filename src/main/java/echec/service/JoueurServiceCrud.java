/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echec.service;

import echec.entity.Joueur;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author admin
 */
public interface JoueurServiceCrud extends CrudRepository<Joueur, Long>{
    
    
     public Joueur findOneByPseudo(String pseudo);
     
      @Override
      public List<Joueur> findAll();
    
     
    
}
