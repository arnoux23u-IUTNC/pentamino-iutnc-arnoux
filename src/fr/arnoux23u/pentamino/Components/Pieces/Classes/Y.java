package fr.arnoux23u.pentamino.Components.Pieces.Classes;

import fr.arnoux23u.pentamino.Components.Piece;
import fr.arnoux23u.pentamino.Jeu;

import java.io.Serializable;

public class Y extends Piece implements Serializable {

    private static final char identifier = 'y';
    private static final String path = Jeu.path + "Components\\Pieces\\Files\\"+ Y.class.getSimpleName()+".txt";

    public Y() {
        super(identifier, path);
    }

}
