package fr.arnoux23u.pentamino.Components;

import fr.arnoux23u.pentamino.Jeu;

import java.io.Serializable;
import java.util.*;

public abstract class Joueur implements Comparable<Joueur>, Serializable {
    public static final int DEBUTANT = 0;
    public static final int INTERMEDIAIRE = 1;
    public static final int AVANCE = 2;

    private final ArrayList<Partie> listeParties;

    private final int type;
    private final int id;
    private final String name;
    private final int score;
    private final static Scanner sc = Jeu.sc;

    public Joueur(int id, String nom, int difficulty) {
        this.name = (nom != null && !nom.equals(" ") && !nom.equals("")) ? nom : "Sans nom";
        this.type = (difficulty >= 0 && difficulty <= 2) ? difficulty : DEBUTANT;
        this.score = 0;
        this.id = id;
        listeParties = new ArrayList<Partie>();
    }

    public int getType() {
        return this.type;
    }

    public char getTypeIdentifier() {
        return (this.type == 0) ? 'D' : (this.type == 1) ? 'I' : 'A';
    }

    public int getScore() {
        return this.score;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Joueur j2) {
        return this.getName().toLowerCase().compareTo(j2.getName().toLowerCase());
    }

    @Override
    public String toString() {
        return String.format("Joueur [\n\t\tId : %d,\n\t\t Nom : %s,\n\t\t Score : %d,\n\t\t Type : %d\n\t]", this.id, this.name, this.score, this.type);
    }

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

    public Partie creerPartie() {
        System.out.println("Entrez taille de grille (>5, <16)");
        int taille = sc.nextInt();
        taille = (taille < 6) ? 6 : Math.min(taille, 15);
        Partie p = new Partie(taille);
        this.listeParties.add(p);
        return p;
    }

    public void lancer(Jeu j) {
        boolean isParties = afficherParties();
        Partie partie = null;
        int choice = sc.nextInt();
        if (isParties) {
            switch (choice) {
                case 0 -> j.sauvegarder();
                case 1 -> partie = choisirPartie();
                default -> partie = creerPartie();
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
        try{
            partie.jouer(j);
        }catch (Exception e){
            aaa;
            //TODO REFLECHIR
        }
    }


}
