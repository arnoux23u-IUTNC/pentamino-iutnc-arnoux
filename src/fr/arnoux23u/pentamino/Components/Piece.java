package fr.arnoux23u.pentamino.Components;

import java.io.*;
import java.util.*;

/**
 * Classe Piece
 *
 * @author arnoux23u
 */
public class Piece implements Comparable<Piece>, Serializable {

    /**
     * Attributs prives
     * Entiers representant les coordonnees de la Piece
     */
    private Integer x, y;

    /**
     * Attribut prive
     * Caractere permettant d'identifier la Piece
     */
    private final char identifier;

    /**
     * Attribut prive
     * Liste de carres composant la Piece
     */
    private final ArrayList<Carre> listeCarre;

    /**
     * Attribut prive
     * Path pour acceder a la classe de la Piece
     */
    private final String path;

    /**
     * Constructeur public a deux parametres
     *
     * @param identifier caractere d'identification
     * @param path       chemin vers la Piece
     */
    public Piece(char identifier, String path) {
        this.identifier = identifier;
        this.path = path;
        listeCarre = new ArrayList<Carre>();
        try {
            FileReader fr = new FileReader(path);
            char item;
            int line = 0, pos = 0;
            while ((item = (char) fr.read()) != '\uFFFF') {
                if (item == '#') {
                    Carre carre = new Carre(pos, line);
                    listeCarre.add(carre);
                }
                pos++;
                if (item == '\n') {
                    line++;
                    pos = 0;
                }
            }
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Impossible de trouver " + path);
        } catch (IOException e) {
            System.out.println("Erreur de lecture !");
        }
    }

    /**
     * Getter X
     *
     * @return Position X de la piece
     */
    public int getX() {
        return this.x;
    }

    /**
     * Getter Y
     *
     * @return Position Y de la piece
     */
    public int getY() {
        return this.y;
    }

    /**
     * Setter X
     *
     * @param x position x
     * @return Piece
     */
    public Piece setX(int x) {
        this.x = x;
        return this;
    }

    /**
     * Setter Y
     *
     * @param y position Y
     * @return Piece
     */
    public Piece setY(int y) {
        this.y = y;
        return this;
    }

    /**
     * Setter Null, supprime les coordonnes de la Piece
     *
     * @return Piece
     */
    public Piece setNull() {
        this.x = null;
        this.y = null;
        return this;
    }

    /**
     * Methode qui retourne le Path de la Piece
     *
     * @return String, path de la Piece
     */
    public String getPath() {
        return this.path;
    }

    /**
     * Methode qui retourne le caractere de la Piece
     *
     * @return char, caractere identifieur de la Piece
     */
    public char getIdentifier() {
        return identifier;
    }

    /**
     * Methode qui retourne la liste de carres de la Piece
     *
     * @return Liste de carres
     */
    public ArrayList<Carre> getListeCarre() {
        return this.listeCarre;
    }

    /**
     * Methode ecrasee d'egalite
     *
     * @param o Objet a comparer
     * @return booleen, a vrai si this == o ou si l'identificateur et les coordonnees de la Piece et du parametres sont egaux
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Piece)) {
            System.out.println("noinstance");
            return false;
        }
        Piece piece = (Piece) o;
        try {
            return identifier == piece.getIdentifier() && x.equals(piece.getX()) && y.equals(piece.getY());
        } catch (NullPointerException e) {
            return false;
        }
    }

    /**
     * Methode ecrasee de comparaison de pieces
     *
     * @param o Piece a comparer
     * @return Entier issu de la comparaison
     */
    public int compareTo(Piece o) {
        return (this.getIdentifier() > o.getIdentifier()) ? 1 : (this.getIdentifier() < o.getIdentifier()) ? -1 : 0;
    }

    /**
     * Methode ecrasee toString
     *
     * @return String d'affichage
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        char item;
        try {
            FileReader fr = new FileReader(path);
            while ((item = (char) fr.read()) != '\uFFFF') {
                sb.append(item == '#' || item == '\n' ? item : ' ');
            }
            fr.close();
        } catch (IOException ignored) {
        }
        return sb.toString();

    }

}



