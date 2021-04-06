package fr.arnoux23u.pentamino.Utils;

import fr.arnoux23u.pentamino.Components.Joueur;

import java.util.Comparator;

/**
 * Classe de comparaison de Joueurs
 *
 * @author arnoux23u
 */
public class JoueurComparator implements Comparator<Joueur> {
    /**
     * Methode écrasée de comparaison
     *
     * @param j1 Joueur 1
     * @param j2 Joueur 2
     * @return Négation du score 1 moins le score 2 -> -(difference)
     */
    public int compare(Joueur j1, Joueur j2) {
        return -(j1.getScore() - j2.getScore());
    }
}
