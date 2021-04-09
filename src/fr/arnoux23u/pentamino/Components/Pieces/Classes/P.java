package fr.arnoux23u.pentamino.Components.Pieces.Classes;

import fr.arnoux23u.pentamino.Components.Piece;
import fr.arnoux23u.pentamino.Jeu;

import java.io.Serializable;

/**
 * Classe P extends Piece
 *
 * @author arnoux23u
 */
public class P extends Piece implements Serializable {

    /**
     * Identificateur de la piece
     */
    private static final char identifier = 'p';

    /**
     * Chemin de la piece
     */
    private static final String path = Jeu.path + "Components\\Pieces\\Files\\" + P.class.getSimpleName() + ".txt";

    /**
     * Constructeur public par defaut
     */
    public P() {
        super(identifier, path);
    }

}
