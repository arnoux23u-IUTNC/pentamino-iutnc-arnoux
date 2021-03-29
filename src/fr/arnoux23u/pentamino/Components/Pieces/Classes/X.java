package fr.arnoux23u.pentamino.Components.Pieces.Classes;

import fr.arnoux23u.pentamino.Components.Piece;
import fr.arnoux23u.pentamino.Jeu;

import java.io.Serializable;

public class X extends Piece implements Serializable {

    private static final char identifier = 'x';
    private static final String path = Jeu.path + "Components\\Pieces\\Files\\"+ X.class.getSimpleName()+".txt";

    public X() {
        super(identifier, path);
    }

}
