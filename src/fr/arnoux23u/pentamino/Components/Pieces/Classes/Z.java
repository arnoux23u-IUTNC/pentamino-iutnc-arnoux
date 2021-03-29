package fr.arnoux23u.pentamino.Components.Pieces.Classes;

import fr.arnoux23u.pentamino.Components.Piece;
import fr.arnoux23u.pentamino.Jeu;

import java.io.Serializable;

public class Z extends Piece implements Serializable {

    private static final char identifier = 'z';
    private static final String path = Jeu.path + "Components\\Pieces\\Files\\"+ Z.class.getSimpleName()+".txt";

    public Z() {
        super(identifier, path);
    }

}
