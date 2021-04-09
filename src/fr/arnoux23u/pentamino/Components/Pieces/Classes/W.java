package fr.arnoux23u.pentamino.Components.Pieces.Classes;

import fr.arnoux23u.pentamino.Components.Piece;
import fr.arnoux23u.pentamino.Jeu;

import java.io.Serializable;

/**
 * Classe W extends Piece
 *
 * @author arnoux23u
 */
public class W extends Piece implements Serializable {

    /**
     * Identificateur de la piece
     */
    private static final char identifier = 'w';

    /**
     * Chemin de la piece
     */
    private static final String path = Jeu.path + "Components\\Pieces\\Files\\" + W.class.getSimpleName() + ".txt";

    /**
     * Constructeur public par defaut
     */
    public W() {
        super(identifier, path);
    }

}
