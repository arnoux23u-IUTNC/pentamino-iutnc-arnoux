package fr.arnoux23u.pentamino.Components.Pieces.Classes;

import fr.arnoux23u.pentamino.Components.Piece;
import fr.arnoux23u.pentamino.Jeu;

import java.io.Serializable;

public class I extends Piece implements Serializable {

    private static final char identifier = 'i';
    private static final String path = Jeu.path + "Components\\Pieces\\Files\\"+ I.class.getSimpleName()+".txt";

    public I() {
        super(identifier, path);
    }

}
