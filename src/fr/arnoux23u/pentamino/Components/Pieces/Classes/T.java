package fr.arnoux23u.pentamino.Components.Pieces.Classes;

import fr.arnoux23u.pentamino.Components.Piece;
import fr.arnoux23u.pentamino.Jeu;

import java.io.Serializable;

/**
 * Classe T extends Pièce
 *
 * @author arnoux23u
 */
public class T extends Piece implements Serializable {

    //Identificateur de la Pièce
    private static final char identifier = 't';

    //Chemin de la Pièce
    private static final String path = Jeu.path + "Components\\Pieces\\Files\\" + T.class.getSimpleName() + ".txt";

    /**
     * Constructeur public par défaut
     */
    public T() {
        super(identifier, path);
    }

}
