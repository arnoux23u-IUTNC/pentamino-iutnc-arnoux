package fr.arnoux23u.pentamino.Components.Pieces.Classes;

import fr.arnoux23u.pentamino.Components.Piece;
import fr.arnoux23u.pentamino.Jeu;

import java.io.Serializable;

public class W extends Piece implements Serializable {

    private static final char identifier = 'w';
    private static final String path = Jeu.path + "Components\\Pieces\\Files\\"+ W.class.getSimpleName()+".txt";

    public W() {
        super(identifier, path);
    }

}
