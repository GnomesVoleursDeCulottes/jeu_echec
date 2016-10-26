/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echec.service;

import echec.entity.Partie;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author admin
 */
public interface PartieServiceCrud extends CrudRepository<Partie, Long>{ 
    
    public List<Partie> findAll();
    
    public List<Partie> findAllbyBlancId(long idJoueur);
    
}
