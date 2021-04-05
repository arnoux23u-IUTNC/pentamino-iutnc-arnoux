package fr.arnoux23u.pentamino.Components.Pieces.Classes;

import fr.arnoux23u.pentamino.Components.Piece;
import fr.arnoux23u.pentamino.Jeu;

import java.io.Serializable;

/**
 * Classe P extends Pièce
 *
 * @author arnoux23u
 */
public class P extends Piece implements Serializable {

    //Identificateur de la Pièce
    private static final char identifier = 'p';

    //Chemin de la Pièce
    private static final String path = Jeu.path + "Components\\Pieces\\Files\\" + P.class.getSimpleName() + ".txt";

    /**
     * Constructeur public par défaut
     */
    public P() {
        super(identifier, path);
    }

}
