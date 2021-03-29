package fr.arnoux23u.pentamino.Components.Pieces.Classes;

import fr.arnoux23u.pentamino.Components.Piece;
import fr.arnoux23u.pentamino.Jeu;

import java.io.Serializable;

public class N extends Piece implements Serializable {

    private static final char identifier = 'n';
    private static final String path = Jeu.path + "Components\\Pieces\\Files\\"+ N.class.getSimpleName()+".txt";

    public N() {
        super(identifier, path);
    }

}
