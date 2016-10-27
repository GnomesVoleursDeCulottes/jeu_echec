/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echec.service;

import echec.entity.Partie;
import echec.entity.Piece;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author admin
 */
public interface PieceServiceCrud extends CrudRepository<Piece, Long>{ 
    
    
    @Override
    public List<Piece> findAll();
    
    public List<Piece> findAllByPartieOrderByPositionXAscPositionYAsc(Partie partie);
    
}