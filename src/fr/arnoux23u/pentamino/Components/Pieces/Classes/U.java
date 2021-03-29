package fr.arnoux23u.pentamino.Components.Pieces.Classes;

import fr.arnoux23u.pentamino.Components.Piece;
import fr.arnoux23u.pentamino.Jeu;

import java.io.Serializable;

public class U extends Piece implements Serializable {

    private static final char identifier = 'u';
    private static final String path = Jeu.path + "Components\\Pieces\\Files\\"+ U.class.getSimpleName()+".txt";

    public U() {
        super(identifier, path);
    }

}
