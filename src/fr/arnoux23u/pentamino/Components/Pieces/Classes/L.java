package fr.arnoux23u.pentamino.Components.Pieces.Classes;

import fr.arnoux23u.pentamino.Components.Piece;
import fr.arnoux23u.pentamino.Jeu;

import java.io.Serializable;

/**
 * Classe L extends Piece
 *
 * @author arnoux23u
 */
public class L extends Piece implements Serializable {

    /**
     * Identificateur de la piece
     */
    private static final char identifier = 'l';

    /**
     * Chemin de la piece
     */
    private static final String path = Jeu.path + "Components\\Pieces\\Files\\" + L.class.getSimpleName() + ".txt";

    /**
     * Constructeur public par defaut
     */
    public L() {
        super(identifier, path);
    }

}
