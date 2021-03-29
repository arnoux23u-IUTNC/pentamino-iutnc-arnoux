package fr.arnoux23u.pentamino.Components.Pieces.Classes;

import fr.arnoux23u.pentamino.Components.Piece;
import fr.arnoux23u.pentamino.Jeu;

import java.io.Serializable;

public class V extends Piece implements Serializable {

    private static final char identifier = 'v';
    private static final String path = Jeu.path + "Components\\Pieces\\Files\\"+ V.class.getSimpleName()+".txt";

    public V() {super(identifier, path);
    }

}
