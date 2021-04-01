package fr.arnoux23u.pentamino.Components;

import fr.arnoux23u.pentamino.Components.Exceptions.CaseDejaRemplieException;
import fr.arnoux23u.pentamino.Components.Exceptions.PieceDebordeException;
import fr.arnoux23u.pentamino.Jeu;

import java.io.File;
import java.io.*;
import java.lang.*;
import java.text.*;
import java.util.*;

public class Partie implements Serializable {
    private final String nom;
    private final char[][] grille;
    private final ArrayList<Piece> piecesPosees;
    private final ArrayList<Piece> piecesRestantes;
    private static final Scanner sc = Jeu.sc;

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

    public String getNom() {
        return this.nom;
    }

    public int getNbPiecesPosees() {
        return this.piecesPosees.size();
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

    private boolean afficher() {
        boolean res = false;
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
            res = true;
            Map<Piece, Integer> affichage = new TreeMap<Piece, Integer>();
            for (Piece p : piecesRestantes) {
                Integer count = affichage.get(p);
                affichage.put(p, (count == null) ? 1 : count + 1);
            }
            for (Map.Entry<Piece, Integer> position : affichage.entrySet()) {
                st.append(String.format("\tPiece %c : %d occurrences\n", Character.toUpperCase(position.getKey().getIdentifier()), position.getValue())).append(position.getKey()).append("\n");
            }
            st.append("0 : Quitter la partie, 1 : Poser une pièce, 2 : Retirer dernière pièce\n");
        }
        System.out.println(st);
        return res;
    }

    @Override
    public String toString() {
        return this.getNom();
    }

    public void jouer(Jeu j) throws CaseDejaRemplieException, PieceDebordeException {

            boolean encorePiece = afficher();
            int choice = sc.nextInt();
            if (encorePiece) {
                switch (choice) {
                    case 0 -> j.sauvegarder();
                    case 2 -> retirerPiece();
                    default -> poserPiece();
                }
            } else {
                if (choice == 0) {
                    j.sauvegarder();
                } else {
                    retirerPiece();
                }
            }
        jouer(j);
    }

    private boolean ajouterPiece(int n, int x, int y) throws CaseDejaRemplieException, PieceDebordeException {
        for (Carre c : piecesRestantes.get(n).getListeCarre()) {
            if (grille[c.getX()][c.getY()] != '☐') {
                throw new CaseDejaRemplieException("Case remplie !");
            }
            if (c.getX() < 0 || c.getY() < 0 || c.getX() >= this.grille.length || c.getY() > this.grille[0].length) {
                throw new PieceDebordeException("Débordement !");
            }
            piecesPosees.get(n).setX(x).setY(y);
        }
        return piecesPosees.add(piecesRestantes.remove(n));
    }

    private boolean poserPiece() throws CaseDejaRemplieException, PieceDebordeException {
        System.out.println("Choisir une pièce à poser (lettre correspondante) :");
        char c = sc.next().charAt(0);
        Piece p = null;
        for (Piece k : piecesRestantes) {
            if (Character.toLowerCase(c) == Character.toLowerCase(k.getIdentifier())) {
                p = k;
            }
        }
        if (p == null) {
            System.out.println("Impossible de choisir cette pièce");
        } else if (!verifierPresence(p)) {
            System.out.println("Entrez position X : ");
            int x = sc.nextInt();
            System.out.println("Entrez position Y : ");
            int y = sc.nextInt();
            return ajouterPiece(piecesRestantes.indexOf(p), x, y);
        } else {
            System.out.println("Pièce " + Character.toUpperCase(p.getIdentifier()) + " existe déjà à ces coordonnées");
        }
        return false;
    }

    private boolean verifierPresence(Piece p) {
        boolean res = false;
        for (Piece k : piecesPosees) {
            if (p == k) {
                res = true;
                break;
            }
        }
        return res;
    }

    private void retirerPiece() {

    }
    //LISTE POSSE NE DOIT PAS AVOIR DEUX PIECES IDENTIQUES
    //SCORE = nb de piece posee
}
