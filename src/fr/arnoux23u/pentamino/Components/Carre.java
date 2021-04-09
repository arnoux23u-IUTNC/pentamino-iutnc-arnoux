package fr.arnoux23u.pentamino.Components;

import java.io.Serializable;

/**
 * Classe Carre
 */
public class Carre implements Serializable {

    /**
     * Attributs prives
     * Positions du Carre
     */
    private final int x, y;

    /**
     * Constructeur public a deux parametres
     *
     * @param x abscisse
     * @param y ordonnee
     */
    public Carre(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Methode ecrasee toString
     *
     * @return String d'affichage
     */
    @Override
    public String toString() {
        return "Carre{" + "x = " + x + ", y = " + y + '}';
    }

    /**
     * Methode ecrasee de test d'egalite
     *
     * @param o Objet a comparer
     * @return booleen, a vrai si this == o ou si les coordonnees sont les mêmes
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Carre)) return false;
        Carre carre = (Carre) o;
        return x == carre.x && y == carre.y;
    }

    /**
     * Getter X
     *
     * @return abscisse du Carre
     */
    public int getX() {
        return this.x;
    }

    /**
     * Getter Y
     *
     * @return ordonnee du Carre
     */
    public int getY() {
        return this.y;
    }
}
