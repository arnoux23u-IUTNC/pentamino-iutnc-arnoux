package fr.arnoux23u.pentamino.Components.Pieces.Classes;

import fr.arnoux23u.pentamino.Components.Piece;
import fr.arnoux23u.pentamino.Jeu;

import java.io.Serializable;

/**
 * Classe I extends Piece
 *
 * @author arnoux23u
 */
public class I extends Piece implements Serializable {

    /**
     * Identificateur de la piece
     */
    private static final char identifier = 'i';

    /**
     * Chemin de la piece
     */
    private static final String path = Jeu.path + "Components\\Pieces\\Files\\" + I.class.getSimpleName() + ".txt";

    /**
     * Constructeur public par defaut
     */
    public I() {
        super(identifier, path);
    }

}
