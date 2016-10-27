/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echec.service;

import echec.entity.Partie;
import echec.entity.Piece;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class JeuService {

    @Autowired
    private PieceServiceCrud servicePiece;

    public String plateau(Partie partie) {
        String plateau = "";
        List<Piece> pieces = servicePiece.findAllByPartieOrderByPositionXAscPositionYAsc(partie);
        Iterator<Piece> it = pieces.iterator();

        for (int i = 0; i < 8; i++) {
            plateau += "<tr>";
            for (int j = 0; j < 8; j++) {
                plateau += "<td>";
                if (it.hasNext() ) {
                    Piece PieceAct = it.next();
                    if (PieceAct.getPositionX() == i && PieceAct.getPositionY() == j) {
                        plateau += "<img id='" + PieceAct.getId().toString();
                        plateau += "' couleur=" + PieceAct.getCouleur().toString();
                        plateau += "' type=" + PieceAct.getType().toString();
                        plateau += "  src='/echec/IMAGE/" + PieceAct.getType().toString() + PieceAct.getCouleur().toString();
                        plateau += "' alt='" + PieceAct.getType().toString() + PieceAct.getCouleur().toString() + "'/>";
                        pieces.remove(1);
                    }
                }
                plateau += "</td>";
            }
            plateau += "</tr>";
        }

        return plateau;
    }

}
