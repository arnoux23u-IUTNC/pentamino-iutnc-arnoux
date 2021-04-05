package fr.arnoux23u.pentamino.Components.Pieces.Classes;

import fr.arnoux23u.pentamino.Components.Piece;
import fr.arnoux23u.pentamino.Jeu;

import java.io.Serializable;

/**
 * Classe N extends Pièce
 *
 * @author arnoux23u
 */
public class N extends Piece implements Serializable {

    //Identificateur de la Pièce
    private static final char identifier = 'n';

    //Chemin de la Pièce
    private static final String path = Jeu.path + "Components\\Pieces\\Files\\" + N.class.getSimpleName() + ".txt";

    /**
     * Constructeur public par défaut
     */
    public N() {
        super(identifier, path);
    }

}
