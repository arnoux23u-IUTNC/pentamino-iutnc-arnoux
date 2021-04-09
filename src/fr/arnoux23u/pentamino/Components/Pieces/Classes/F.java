package fr.arnoux23u.pentamino.Components.Pieces.Classes;

import fr.arnoux23u.pentamino.Components.Piece;
import fr.arnoux23u.pentamino.Jeu;

import java.io.Serializable;

/**
 * Classe F extends Piece
 *
 * @author arnoux23u
 */
public class F extends Piece implements Serializable {

    /**
     * Identificateur de la piece
     */
    private static final char identifier = 'f';

    /**
     * Chemin de la piece
     */
    private static final String path = Jeu.path + "Components\\Pieces\\Files\\" + F.class.getSimpleName() + ".txt";

    /**
     * Constructeur public par defaut
     */
    public F() {
        super(identifier, path);
    }

}
