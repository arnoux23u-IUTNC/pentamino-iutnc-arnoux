package fr.arnoux23u.pentamino.Components.Pieces.Classes;

import fr.arnoux23u.pentamino.Components.Piece;
import fr.arnoux23u.pentamino.Jeu;

import java.io.Serializable;

/**
 * Classe N extends Piece
 *
 * @author arnoux23u
 */
public class N extends Piece implements Serializable {

    /**
     * Identificateur de la piece
     */
    private static final char identifier = 'n';

    /**
     * Chemin de la piece
     */
    private static final String path = Jeu.path + "Components\\Pieces\\Files\\" + N.class.getSimpleName() + ".txt";

    /**
     * Constructeur public par defaut
     */
    public N() {
        super(identifier, path);
    }

}
