package fr.arnoux23u.pentamino.Components.Pieces.Classes;

import fr.arnoux23u.pentamino.Components.Piece;
import fr.arnoux23u.pentamino.Jeu;

import java.io.Serializable;

/**
 * Classe T extends Piece
 *
 * @author arnoux23u
 */
public class T extends Piece implements Serializable {

    /**
     * Identificateur de la piece
     */
    private static final char identifier = 't';

    /**
     * Chemin de la piece
     */
    private static final String path = Jeu.path + "Components\\Pieces\\Files\\" + T.class.getSimpleName() + ".txt";

    /**
     * Constructeur public par defaut
     */
    public T() {
        super(identifier, path);
    }

}
