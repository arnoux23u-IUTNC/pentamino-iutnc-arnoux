package fr.arnoux23u.pentamino.Utils;

import fr.arnoux23u.pentamino.Components.Joueur;

import java.util.Comparator;

public class JoueurComparator implements Comparator<Joueur> {
    @Override
    public int compare(Joueur j1, Joueur j2){
        return -(j1.getScore()-j2.getScore());
    }
}
