package fr.arnoux23u.pentamino.Components.Joueurs;

import fr.arnoux23u.pentamino.Components.Exceptions.*;
import fr.arnoux23u.pentamino.Components.*;
import fr.arnoux23u.pentamino.Jeu;

import java.io.Serializable;

/**
 * Classe Joueur Débutant
 *
 * @author arnoux23u
 */
public class JoueurDebutant extends Joueur implements Serializable {

    /**
     * Constructeur public à deux paramètres
     *
     * @param id  id du Joueur
     * @param nom nom du Joueur
     */
    public JoueurDebutant(int id, String nom) {
        super(id, nom, Joueur.DEBUTANT);
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
        } catch (PieceDebordeException e) {
            lancerPartie(j, partie);
        } catch (CaseDejaRemplieException e) {
            lancerPartie(j, partie);
        } catch (PieceEqualsException e) {
            System.out.println("La pièce existe déjà à cet endroit dans la grille");
            lancerPartie(j, partie);
        }
    }
}
