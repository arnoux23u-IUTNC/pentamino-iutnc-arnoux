package fr.arnoux23u.pentamino.Components;

import fr.arnoux23u.pentamino.Jeu;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Partie implements Serializable {
    private final String nom;
    private final char[][] grille;
    private final ArrayList<Piece> piecesPosees;
    private final ArrayList<Piece> piecesRestantes;
    private static final Scanner sc = new Scanner(System.in);

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
            Map<Character, Integer> affichage = new TreeMap<Character, Integer>();
            for (Piece p : piecesRestantes) {
                Integer count = affichage.get(Character.toUpperCase(p.getIdentifier()));
                affichage.put(Character.toUpperCase(p.getIdentifier()), (count == null) ? 1 : count + 1);
            }
            for (Map.Entry<Character, Integer> position : affichage.entrySet()) {
                st.append(String.format("\tPiece %c : %d occurrences\n", Character.toUpperCase(position.getKey()), position.getValue()));
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


    //TODO TRAVALLER ICI
    public void jouer(Jeu j) throws ClassNotFoundException, IOException {
        boolean encorePiece = afficher();
        int choice = sc.nextInt();
        if(encorePiece){
            switch (choice) {
                case 0 -> j.sauvegarder();
                //TODO case 2 -> retirerPiece();
                default -> poserPiece();
            }
        }else{
            if (choice == 0) {
                j.sauvegarder();
            } else {
                //TODO retirerPiece();
            }
        }
    }

    //LISTE POSSE NE DOIT PAS AVOIR DEUX PIECES IDENTIQUES
    //SCORE = nb de piece posee
}
