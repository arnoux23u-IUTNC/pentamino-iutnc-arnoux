package fr.arnoux23u.pentamino.Components.Joueurs;

import fr.arnoux23u.pentamino.Components.Exceptions.*;
import fr.arnoux23u.pentamino.Components.*;
import fr.arnoux23u.pentamino.Jeu;

import java.io.Serializable;

/**
 * Classe Joueur Avance
 *
 * @author arnoux23u
 */
public class JoueurAvance extends Joueur implements Serializable {

    /**
     * Constructeur public a deux parametres
     *
     * @param id  id du Joueur
     * @param nom nom du Joueur
     */
    public JoueurAvance(int id, String nom) {
        super(id, nom, Joueur.AVANCE);
    }

    /**
     * Methode ecrasee lancerPartie
     *
     * @param j      Jeu en cours
     * @param partie Partie a lancer
     */
    @Override
    public void lancerPartie(Jeu j, Partie partie) {
        try {
            partie.jouer(j);
        } catch (PieceDebordeException e) {
            System.out.println("La pièce ne peut pas sortir de la grille !");
            partie.retirerDernierePiece();
            lancerPartie(j, partie);
        } catch (CaseDejaRemplieException e) {
            System.out.println("Les pièces ne peuvent pas se superposer !");
            partie.retirerDernierePiece();
            lancerPartie(j, partie);
        } catch (PieceEqualsException e) {
            System.out.println("La pièce existe déjà à cet endroit dans la grille");
            lancerPartie(j, partie);
        }
    }
}
