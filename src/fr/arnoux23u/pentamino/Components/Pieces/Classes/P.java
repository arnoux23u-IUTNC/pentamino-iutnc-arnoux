package fr.arnoux23u.pentamino.Components.Pieces.Classes;

import fr.arnoux23u.pentamino.Components.Piece;
import fr.arnoux23u.pentamino.Jeu;

import java.io.Serializable;

public class P extends Piece implements Serializable {

    private static final char identifier = 'p';
    private static final String path = Jeu.path + "Components\\Pieces\\Files\\"+ P.class.getSimpleName()+".txt";

    public P() {
        super(identifier, path);
    }

}
