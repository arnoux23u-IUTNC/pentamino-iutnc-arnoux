package fr.arnoux23u.pentamino.Components;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.*;

/**
 * Classe Pièce
 *
 * @author arnoux23u
 */
public class Piece implements Comparable<Piece>, Serializable {

    //Entiers représentant les coordonnées de la Pièce
    private Integer x, y;

    //Caractère permettant d'identifier la Pièce
    private final char identifier;

    //Liste de carrés composant la Pièce
    private final ArrayList<Carre> listeCarre;

    //Path pour acceder à la classe de la Pièce
    private final String path;

    /**
     * Constructeur public à deux paramètres
     *
     * @param identifier caractère d'identification
     * @param path       chemin vers la Pièce
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
                    Carre carre = new Carre(line, pos);
                    listeCarre.add(carre);
                }
                pos++;
                if (item == '\n') {
                    line++;
                    pos = 0;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Impossible de trouver " + path);
        } catch (IOException e) {
            System.out.println("Erreur de lecture !");
        }
    }

    /**
     * Getter X
     *
     * @return Position X de la pièce
     */
    public int getX() {
        return this.x;
    }

    /**
     * Getter Y
     *
     * @return Position Y de la pièce
     */
    public int getY() {
        return this.y;
    }

    /**
     * Setter X
     *
     * @param x position x
     * @return Pièce
     */
    public Piece setX(int x) {
        this.x = x;
        return this;
    }

    /**
     * Setter Y
     *
     * @param y position Y
     * @return Pièce
     */
    public Piece setY(int y) {
        this.y = y;
        return this;
    }

    /**
     * Setter Null, supprime les coordonnés de la Pièce
     *
     * @return Pièce
     */
    public Piece setNull() {
        this.x = null;
        this.y = null;
        return this;
    }

    /**
     * Méthode qui retourne le Path de la Pièce
     *
     * @return String, path de la Pièce
     */
    public String getPath() {
        return this.path;
    }

    /**
     * Méthode qui retourne le caractère de la Pièce
     *
     * @return char, caractère identifieur de la Pièce
     */
    public char getIdentifier() {
        return identifier;
    }

    /**
     * Méthode qui retourne la liste de carrés de la Pièce
     *
     * @return Liste de carrés
     */
    public ArrayList<Carre> getListeCarre() {
        return this.listeCarre;
    }

    /**
     * Méthode écrasée d'égalité
     *
     * @param o Objet à comparer
     * @return booleen, a vrai si this == o ou si l'identificateur et les coordonnées de la Pièce et du paramètres sont égaux
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
     * Méthode écrasée de comparaison de pièces
     *
     * @param o Pièce à comparer
     * @return Entier issu de la méthode Character.compare()
     */
    @Override
    public int compareTo(@NotNull Piece o) {
        return Character.compare(this.getIdentifier(), o.getIdentifier());
    }

    /**
     * Méthode écrasée toString
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
        } catch (IOException ignored) {
        }
        return sb.toString();

    }

}



