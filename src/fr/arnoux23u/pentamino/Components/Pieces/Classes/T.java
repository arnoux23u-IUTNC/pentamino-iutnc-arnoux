package fr.arnoux23u.pentamino.Components.Pieces.Classes;

import fr.arnoux23u.pentamino.Components.Piece;
import fr.arnoux23u.pentamino.Jeu;

public class T extends Piece {

    private static final char identifier = 'f';
    private static final String path = Jeu.path + "Components\\Pieces\\Files\\"+ F.class.getSimpleName()+".txt";

    public T(int x, int y) {
        super(x, y, identifier, path);
    }

}