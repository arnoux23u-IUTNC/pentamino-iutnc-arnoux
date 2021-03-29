package fr.arnoux23u.pentamino.Components.Pieces.Classes;

import fr.arnoux23u.pentamino.Components.Piece;
import fr.arnoux23u.pentamino.Jeu;

import java.io.Serializable;

public class L extends Piece implements Serializable {

    private static final char identifier = 'l';
    private static final String path = Jeu.path + "Components\\Pieces\\Files\\"+ L.class.getSimpleName()+".txt";

    public L() {
        super(identifier, path);
    }

}
