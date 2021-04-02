package fr.arnoux23u.pentamino.Components.Joueurs;

import fr.arnoux23u.pentamino.Components.Exceptions.CaseDejaRemplieException;
import fr.arnoux23u.pentamino.Components.Exceptions.PieceDebordeException;
import fr.arnoux23u.pentamino.Components.Joueur;
import fr.arnoux23u.pentamino.Components.Partie;
import fr.arnoux23u.pentamino.Jeu;

import java.io.Serializable;

public class JoueurIntermediaire extends Joueur implements Serializable {
    public JoueurIntermediaire(int id, String nom) {
        super(id, nom, Joueur.INTERMEDIAIRE);
    }

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
        }
    }
}
