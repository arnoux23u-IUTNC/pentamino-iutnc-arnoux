package fr.arnoux23u.pentamino.Components.Pieces.Classes;

import fr.arnoux23u.pentamino.Components.Piece;
import fr.arnoux23u.pentamino.Jeu;

import java.io.Serializable;

/**
 * Classe X extends Piece
 *
 * @author arnoux23u
 */
public class X extends Piece implements Serializable {

    /**
     * Identificateur de la piece
     */
    private static final char identifier = 'x';

    /**
     * Chemin de la piece
     */
    private static final String path = Jeu.path + "Components\\Pieces\\Files\\" + X.class.getSimpleName() + ".txt";

    /**
     * Constructeur public par defaut
     */
    public X() {
        super(identifier, path);
    }

}
