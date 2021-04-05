package fr.arnoux23u.pentamino.Components.Pieces.Classes;

import fr.arnoux23u.pentamino.Components.Piece;
import fr.arnoux23u.pentamino.Jeu;

import java.io.Serializable;

/**
 * Classe Z extends Pièce
 *
 * @author arnoux23u
 */
public class Z extends Piece implements Serializable {

    //Identificateur de la Pièce
    private static final char identifier = 'z';

    //Chemin de la Pièce
    private static final String path = Jeu.path + "Components\\Pieces\\Files\\" + Z.class.getSimpleName() + ".txt";

    /**
     * Constructeur public par défaut
     */
    public Z() {
        super(identifier, path);
    }

}
