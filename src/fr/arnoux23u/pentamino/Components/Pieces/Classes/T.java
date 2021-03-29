package fr.arnoux23u.pentamino.Components.Pieces.Classes;

import fr.arnoux23u.pentamino.Components.Piece;
import fr.arnoux23u.pentamino.Jeu;

import java.io.Serializable;

public class T extends Piece implements Serializable {

    private static final char identifier = 't';
    private static final String path = Jeu.path + "Components\\Pieces\\Files\\"+ T.class.getSimpleName()+".txt";

    public T() {
        super(identifier, path);
    }

}
