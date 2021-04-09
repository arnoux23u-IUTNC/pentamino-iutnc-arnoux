package fr.arnoux23u.pentamino.Components.Pieces.Classes;

import fr.arnoux23u.pentamino.Components.Piece;
import fr.arnoux23u.pentamino.Jeu;

import java.io.Serializable;

/**
 * Classe Y extends Piece
 *
 * @author arnoux23u
 */
public class Y extends Piece implements Serializable {

    /**
     * Identificateur de la piece
     */
    private static final char identifier = 'y';

    /**
     * Chemin de la piece
     */
    private static final String path = Jeu.path + "Components\\Pieces\\Files\\" + Y.class.getSimpleName() + ".txt";

    /**
     * Constructeur public par defaut
     */
    public Y() {
        super(identifier, path);
    }

}
