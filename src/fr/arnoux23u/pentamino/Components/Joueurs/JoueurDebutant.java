package fr.arnoux23u.pentamino.Components.Joueurs;

import fr.arnoux23u.pentamino.Components.Exceptions.CaseDejaRemplieException;
import fr.arnoux23u.pentamino.Components.Exceptions.PieceDebordeException;
import fr.arnoux23u.pentamino.Components.Joueur;
import fr.arnoux23u.pentamino.Components.Partie;
import fr.arnoux23u.pentamino.Jeu;

import java.io.Serializable;

public class JoueurDebutant extends Joueur implements Serializable {
    public JoueurDebutant(int id, String nom) {
        super(id, nom, Joueur.DEBUTANT);
    }

    @Override
    public void lancerPartie(Jeu j, Partie partie) {
        try {
            partie.jouer(j);
        } catch (PieceDebordeException | CaseDejaRemplieException ignored) {
            lancerPartie(j, partie);
        }
    }
}
