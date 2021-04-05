package fr.arnoux23u.pentamino.Components;

import java.io.Serializable;

/**
 * Classe Carre
 */
public class Carre implements Serializable {

    //Position du Carré
    private final int x, y;

    /**
     * Constructeur public à deux paramètres
     *
     * @param x abscisse
     * @param y ordonnée
     */
    public Carre(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Méthode écrasée toString
     *
     * @return String d'affichage
     */
    @Override
    public String toString() {
        return "Carre{" + "x = " + x + ", y = " + y + '}';
    }

    /**
     * Méthode écrasée de test d'égalité
     *
     * @param o Objet à comparer
     * @return booleen, a vrai si this == o ou si les coordonnées sont les mêmes
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
     * @return abscisse du Carré
     */
    public int getX() {
        return this.x;
    }

    /**
     * Getter Y
     *
     * @return ordonnée du Carré
     */
    public int getY() {
        return this.y;
    }
}
