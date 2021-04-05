package fr.arnoux23u.pentamino.Components.Pieces.Classes;

import fr.arnoux23u.pentamino.Components.Piece;
import fr.arnoux23u.pentamino.Jeu;

import java.io.Serializable;

/**
 * Classe F extends Pièce
 *
 * @author arnoux23u
 */
public class F extends Piece implements Serializable {

    //Identificateur de la Pièce
    private static final char identifier = 'f';

    //Chemin de la Pièce
    private static final String path = Jeu.path + "Components\\Pieces\\Files\\" + F.class.getSimpleName() + ".txt";

    /**
     * Constructeur public par défaut
     */
    public F() {
        super(identifier, path);
    }

}
