package fr.arnoux23u.pentamino.Components.Pieces.Classes;

import fr.arnoux23u.pentamino.Components.Piece;
import fr.arnoux23u.pentamino.Jeu;

import java.io.Serializable;

/**
 * Classe U extends Piece
 *
 * @author arnoux23u
 */
public class U extends Piece implements Serializable {

    /**
     * Identificateur de la piece
     */
    private static final char identifier = 'u';

    /**
     * Chemin de la piece
     */
    private static final String path = Jeu.path + "Components\\Pieces\\Files\\" + U.class.getSimpleName() + ".txt";

    /**
     * Constructeur public par defaut
     */
    public U() {
        super(identifier, path);
    }

}
