package fr.arnoux23u.pentamino.Components.Joueurs;

import fr.arnoux23u.pentamino.Components.Exceptions.*;
import fr.arnoux23u.pentamino.Components.*;
import fr.arnoux23u.pentamino.Jeu;

import java.io.Serializable;

/**
 * Classe Joueur Intermédiaire
 *
 * @author arnoux23u
 */
public class JoueurIntermediaire extends Joueur implements Serializable {

    /**
     * Constructeur public à deux paramètres
     *
     * @param id  id du Joueur
     * @param nom nom du Joueur
     */
    public JoueurIntermediaire(int id, String nom) {
        super(id, nom, Joueur.INTERMEDIAIRE);
    }

    /**
     * Méthode écrasée lancerPartie
     *
     * @param j      Jeu en cours
     * @param partie Partie à lancer
     */
    @Override
    public void lancerPartie(Jeu j, Partie partie) {
        try {
            partie.jouer(j);
        } catch (PieceDebordeException ignored) {
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
