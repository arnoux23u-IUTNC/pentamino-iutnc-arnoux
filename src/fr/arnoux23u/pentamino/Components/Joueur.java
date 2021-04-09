package fr.arnoux23u.pentamino.Components;

import fr.arnoux23u.pentamino.Jeu;

import java.io.Serializable;
import java.util.*;

/**
 * Classe Joueur
 *
 * @author arnoux23u
 */
public abstract class Joueur implements Comparable<Joueur>, Serializable {

    /**
     * Attribut static DEBUTANT
     */
    public static final int DEBUTANT = 0;

    /**
     * Attribut static INTERMEDIAIRE
     */
    public static final int INTERMEDIAIRE = 1;

    /**
     * Attribut static AVANCE
     */
    public static final int AVANCE = 2;

    /**
     * Attribut prive
     * Liste des parties du Joueur
     */
    private final ArrayList<Partie> listeParties;

    /**
     * Attribut prive
     * Type du Joueur
     */
    private final int type;

    /**
     * Attribut prive
     * ID du Joueur
     */
    private final int id;

    /**
     * Attribut prive
     * Nom du Joueur
     */
    private final String name;

    /**
     * Attribut prive
     * Score du Joueur
     */
    private int score;

    /**
     * Attribut Public
     * Scanner issu du Jeu
     */
    public final static Scanner sc = Jeu.sc;

    /**
     * Constructeur public a 3 parametres
     *
     * @param id         Id du Joueur
     * @param nom        Nom du Joueur
     * @param difficulty Difficulte choisie
     */
    public Joueur(int id, String nom, int difficulty) {
        this.name = (nom != null && !nom.equals(" ") && !nom.equals("")) ? nom : "Sans nom";
        this.type = (difficulty >= 0 && difficulty <= 2) ? difficulty : DEBUTANT;
        this.score = 0;
        this.id = id;
        listeParties = new ArrayList<Partie>();
    }

    /**
     * Getter Identificateur de difficulte
     *
     * @return char correspondant a la difficulte
     */
    public char getTypeIdentifier() {
        return (this.type == 0) ? 'D' : (this.type == 1) ? 'I' : 'A';
    }

    /**
     * Getter Type
     *
     * @return type du Joueur
     */
    public int getType() {
        return this.type;
    }

    /**
     * Getter ID
     *
     * @return ID du Joueur
     */
    public int getId() {
        return this.id;
    }

    /**
     * Getter Nom
     *
     * @return Nom du Joueur
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter Score
     *
     * @return score du Joueur
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Setter Score
     *
     * @param i nouveau score du Joueur
     */
    public void setScore(int i) {
        score = i;
    }

    /**
     * Getter Liste des parties
     *
     * @return Liste des parties du Joueur
     */
    public ArrayList<Partie> getListeParties() {
        return this.listeParties;
    }

    /**
     * Methode ecrasee de comparaison
     *
     * @param j2 Joueur a comparer
     * @return Entier issu de la methode String.compareTo
     */
    public int compareTo(Joueur j2) {
        return this.getName().toLowerCase().compareTo(j2.getName().toLowerCase());
    }

    /**
     * Methode ecrasee toString
     *
     * @return String d'affichage
     */
    @Override
    public String toString() {
        return String.format("Joueur [\n\t\tId : %d,\n\t\t Nom : %s,\n\t\t Score : %d,\n\t\t Type : %d\n\t]", this.id, this.name, this.score, this.type);
    }

    /**
     * Methode d'affichage des parties
     *
     * @return booleen, a vrai si le Joueur possede des parties
     */
    public boolean afficherParties() {
        if (this.listeParties.isEmpty()) {
            System.out.println("Aucune partie\n0 : Quitter, 1 : Creer une nouvelle partie");
            return false;
        } else {
            System.out.println("Liste des parties :");
            for (Partie p : listeParties) {
                System.out.printf("\t\t%02d : %s -> (%02d Pièces posées)\n", listeParties.indexOf(p), p.getNom(), p.getNbPiecesPosees());
            }
            System.out.println("0 : Quitter, 1 : Selectionner une partie, 2 : Creer une nouvelle partie");
            return true;
        }
    }

    /**
     * Methode de choix d'une Partie
     *
     * @return Partie choisie
     */
    public Partie choisirPartie() {
        System.out.println("Entrez ID (premiere colonne) : ");
        Partie p;
        try {
            int id = sc.nextInt();
            p = listeParties.get(id);
            System.out.println("Vous avez choisi : " + p.getNom());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Partie n'existe pas");
            p = creerPartie();
        }
        return p;
    }

    /**
     * Methode de creation d'une Partie
     *
     * @return Partie cree
     */
    public Partie creerPartie() {
        System.out.println("Entrez taille de grille (>5, <20)");
        int taille = sc.nextInt();
        taille = (taille < 6) ? 6 : Math.min(taille, 19);
        Partie p = new Partie(taille);
        this.listeParties.add(p);
        return p;
    }

    /**
     * Methode de demmarage du Joueur
     *
     * @param j Jeu principal
     */
    public void lancer(Jeu j) {
        boolean isParties = afficherParties();
        Partie partie = null;
        int choice = sc.nextInt();
        if (isParties) {
            switch (choice) {
                case 0:
                    j.sauvegarder();
                    break;
                case 1:
                    partie = choisirPartie();
                    break;
                default:
                    partie = creerPartie();
                    break;
            }
        } else {
            if (choice == 0) {
                j.sauvegarder();
            } else {
                partie = creerPartie();
            }
        }
        System.out.println("Partie sélectionnée :");
        System.out.println("\t" + partie);
        assert partie != null;
        lancerPartie(j, partie);
    }

    /**
     * Methode abstraite de lancement d'une Partie
     *
     * @param j      Jeu en cours
     * @param partie Partie a lancer
     */
    public abstract void lancerPartie(Jeu j, Partie partie);

}
