package fr.arnoux23u.pentamino.Components;

import fr.arnoux23u.pentamino.Jeu;
import fr.arnoux23u.pentamino.Utils.JoueurComparator;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.*;

public class Partie implements Serializable {
    private String nom;
    private char[][] grille;
    private ArrayList<Piece> piecesPosees;
    private ArrayList<Piece> piecesRestantes;

    public Partie(int taille) {
        nom = new SimpleDateFormat("yyyy-MM-dd_HH-mm").format(new Date());
        piecesPosees = new ArrayList<Piece>();
        piecesRestantes = new ArrayList<Piece>();
        grille = new char[taille][taille];
        actualiserGrille();
        remplirAleatoire();
    }

    private void remplirAleatoire() {
        System.out.println("Insertion de 20 pièces aléatoire");
        File f = new File(Jeu.path + "Components\\Pieces\\Classes");
        File[] files = f.listFiles();
        int index = 0;
        if (files != null && files.length > 0) {
            for (int i = 0; i < 20; i++) {
                String s = files[new Random().nextInt(files.length)].getName().substring(0, 1);
                try {
                    Piece p = (Piece) Class.forName("fr.arnoux23u.pentamino.Components.Pieces.Classes." + s).getDeclaredConstructor().newInstance();
                    this.piecesRestantes.add(p);
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
                    System.out.println("Erreur d'instanciation de la pièce " + s);
                }
            }
        }
    }

    private boolean poserPiece() {
        return true;
    }

    public String getNom() {
        return this.nom;
    }

    public int getNbPiecesPosees() {
        return this.piecesPosees.size();
    }

    private void ajouterPiece(int n, int x, int y) /*throws SOMETHING*/ {
        //TODO
        actualiserGrille();
    }

    private void actualiserGrille() {
        for (char[] chars : grille) {
            Arrays.fill(chars, '☐');
        }
        for (Piece p : piecesPosees) {
            for (Carre c : p.getListeCarre()) {
                grille[p.getX() + c.getX()][p.getY() + c.getY()] = p.getIdentifier();
            }
        }
    }

    private void afficher() {
        StringBuffer st = new StringBuffer();
        for (char[] ligne : grille) {
            for (char caseGrille : ligne) {
                st.append(caseGrille);
            }
            st.append("\n");
        }
        st.append("Pièces à poser : ").append("\n");
        if (piecesRestantes.isEmpty()) {
            st.append("\t").append("Aucune pièce ...").append("\n0 : Quitter la partie, 1 : Retirer dernière pièce");
        } else {
            for (Piece p : piecesRestantes) {
                st.append("\t").append(p).append("\n");
            }
        }
        System.out.println(st);
    }

    @Override
    public String toString() {
        return this.getNom();
    }

    public void jouer() {
        afficher();
    }

    //LISTE POSSE NE DOIT PAS AVOIR DEUX PIECES IDENTIQUES
    //SCORE = nb de piece posee
}
