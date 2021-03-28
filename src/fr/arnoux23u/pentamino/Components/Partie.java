package fr.arnoux23u.pentamino.Components;

import fr.arnoux23u.pentamino.Utils.JoueurComparator;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

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
        for(char[] ligne : grille){
            for (char caseGrille : ligne) {
                st.append(caseGrille);
            }
            st.append("\n");
        }
        st.append("Pièces à poser : ").append("\n");
        if(piecesRestantes.isEmpty()){
            st.append("\t").append("Aucune pièce ...").append("\n0 : Quitter la partie, 1 : Pose");
        }else {
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
