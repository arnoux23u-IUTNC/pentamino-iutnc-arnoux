package fr.arnoux23u.pentamino.Components;

import fr.arnoux23u.pentamino.Components.Exceptions.*;
import fr.arnoux23u.pentamino.Jeu;

import java.io.*;
import java.lang.*;
import java.lang.reflect.*;
import java.text.*;
import java.util.*;

/**
 * Classe Partie
 *
 * @author arnoux23u
 */
public class Partie implements Serializable {

    //Nom de la Partie
    private final String nom;

    //Grille de la Partie
    private final char[][] grille;

    //Liste de pièces posées
    private final ArrayList<Piece> piecesPosees;

    //Liste de pièces restantes
    private final ArrayList<Piece> piecesRestantes;

    //Score de la Partie
    private int score;

    //Scanner issu de la classe Jeu
    private static final Scanner sc = Jeu.sc;

    //Caractère vide de grille
    private static final char charVide = '∎';

    /**
     * Constructeur public à 1 paramètre
     *
     * @param taille Taille de la grille
     */
    public Partie(int taille) {
        nom = new SimpleDateFormat("yyyy-MM-dd_HH-mm").format(new Date());
        piecesPosees = new ArrayList<Piece>();
        piecesRestantes = new ArrayList<Piece>();
        grille = new char[taille][taille];
        actualiserGrille();
        remplirAleatoire();
    }

    /**
     * Méthode de remplissage aléatoire de la liste piecesRestantes
     */
    private void remplirAleatoire() {
        System.out.println("Insertion de 20 pièces aléatoires");
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

    /**
     * Getter Nom
     *
     * @return Nom de la Partie
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Getter Nombre de pièces posées
     *
     * @return Nombre de pièces posées dans la Partie
     */
    public int getNbPiecesPosees() {
        return this.piecesPosees.size();
    }

    /**
     * Getter Score
     *
     * @return score de la Partie
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Méthode qui actualise la grille selon les listes
     */
    private void actualiserGrille() {
        for (char[] chars : grille) {
            Arrays.fill(chars, charVide);
        }
        for (Piece p : piecesPosees) {
            for (Carre c : p.getListeCarre()) {
                try {
                    grille[p.getX() + c.getX()][p.getY() + c.getY()] = Character.toUpperCase(p.getIdentifier());
                } catch (ArrayIndexOutOfBoundsException ignored) {
                }
            }
        }
    }

    /**
     * Méthode d'affichage des pièces et de la grille
     *
     * @return entier selon les listes
     */
    private int afficher() {
        int res = 0;
        StringBuffer st = new StringBuffer();
        //Affichage grille
        for (char[] ligne : grille) {
            for (char caseGrille : ligne) {
                st.append(String.format("%2c",caseGrille));
            }
            st.append("\n");
        }
        st.append("\nPièces à poser : ").append("\n");
        if (piecesRestantes.isEmpty()) {
            st.append("\tAucune pièce ...\n");
            if (piecesPosees.isEmpty()) {
                st.append("0 : Quitter la partie, 1 : Remplissage\n");
            } else {
                res = 1;
                st.append("0 : Quitter la partie, 1 : Remplissage, 2 : Retirer dernière pièce\n");
            }
        } else {
            Map<Piece, Integer> affichage = new TreeMap<Piece, Integer>();
            for (Piece p : piecesRestantes) {
                Integer count = affichage.get(p);
                affichage.put(p, (count == null) ? 1 : count + 1);
            }
            for (Map.Entry<Piece, Integer> position : affichage.entrySet()) {
                st.append(String.format("\tPiece %c : %d occurrences\n", Character.toUpperCase(position.getKey().getIdentifier()), position.getValue())).append(position.getKey()).append("\n");
            }
            if (piecesPosees.isEmpty()) {
                res = 2;
                st.append("0 : Quitter la partie, 1 : Poser une pièce\n");
            } else {
                res = 3;
                st.append("0 : Quitter la partie, 1 : Poser une pièce, 2 : Retirer dernière pièce\n");
            }

        }
        System.out.println(st);
        return res;
    }

    /**
     * Méthode écrasée toString
     *
     * @return Nom de la Partie
     */
    @Override
    public String toString() {
        return this.getNom();
    }

    /**
     * Méthode jouer
     *
     * @param j Jeu
     * @throws CaseDejaRemplieException Exception en cas de case occupée
     * @throws PieceDebordeException    Exception en cas de débordement
     * @throws PieceEqualsException     Exception si pièces égales
     */
    public void jouer(Jeu j) throws CaseDejaRemplieException, PieceDebordeException, PieceEqualsException {
        int resultAffichage = afficher() * 10 + sc.nextInt();
        switch (resultAffichage) {
            case 1, 11 -> remplirAleatoire();
            case 12, 32 -> retirerDernierePiece();
            case 21, 31 -> poserPiece();
            default -> j.sauvegarder();
        }
        jouer(j);
    }

    /**
     * Méthode d'ajout de Pièce
     *
     * @param n Position de la Pièce dans la liste
     * @param x Abscisse
     * @param y Ordonnée
     * @throws CaseDejaRemplieException Exception en cas de case occupée
     * @throws PieceDebordeException    Exception en cas de débordement
     * @throws PieceEqualsException     Exception si pièces égales
     */
    private void ajouterPiece(int n, int x, int y) throws CaseDejaRemplieException, PieceDebordeException, PieceEqualsException {
        boolean deborde = false, fill = false;
        for (Carre c : piecesRestantes.get(n).getListeCarre()) {
            try {
                if (grille[x + c.getX()][y + c.getY()] != charVide) {
                    fill = true;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                deborde = true;
            }

            if (c.getX() < 0 || c.getY() < 0 || c.getX() >= this.grille.length || c.getY() >= this.grille[0].length) {
                deborde = true;
            }
            Piece p = piecesRestantes.get(n).setX(x).setY(y);
            for (Piece o : piecesPosees) {
                if (p.equals(o)) {
                    throw new PieceEqualsException("Pièces égales");
                }
            }
        }
        piecesPosees.add(piecesRestantes.remove(n));
        actualiserGrille();
        score++;
        if (fill) throw new CaseDejaRemplieException("Case remplie !");
        if (deborde) throw new PieceDebordeException("Piece deborde !");
    }

    /**
     * Méthode pour poser une Pièce
     *
     * @throws CaseDejaRemplieException Exception en cas de case occupée
     * @throws PieceDebordeException    Exception en cas de débordement
     * @throws PieceEqualsException     Exception si pièces égales
     */
    private void poserPiece() throws CaseDejaRemplieException, PieceDebordeException, PieceEqualsException {
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
            ajouterPiece(piecesRestantes.indexOf(p), x, y);
        } else {
            System.out.println("Pièce " + Character.toUpperCase(p.getIdentifier()) + " existe déjà à ces coordonnées");
        }
    }

    /**
     * Méthode qui vérifie qu'une Pièce n'est pas déjà présente
     *
     * @param p Pièce à tester
     * @return booleen, a vrai si la Pièce existe
     */
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

    /**
     * Méthode pour retirer la dernière Pièce posée
     */
    public void retirerDernierePiece() {
        piecesRestantes.add(piecesPosees.remove(piecesPosees.size() - 1).setNull());
        actualiserGrille();
        this.score--;
    }

}
