package fr.arnoux23u.pentamino;

import fr.arnoux23u.pentamino.Components.*;
import fr.arnoux23u.pentamino.Components.Pieces.Classes.*;

public class Jeu {
    public static final String path = ".\\src\\fr\\arnoux23u\\pentamino\\";

    public static void main(String[] args) {
        System.out.println("Bienvenue sur le jeu");
        Piece f = new F(2,2);
        System.out.println(f);
    }
}
