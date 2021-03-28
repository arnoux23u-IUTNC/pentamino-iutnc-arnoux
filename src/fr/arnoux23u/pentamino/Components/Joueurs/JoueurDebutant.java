package fr.arnoux23u.pentamino.Components.Joueurs;

import fr.arnoux23u.pentamino.Components.Joueur;

import java.io.Serializable;

public class JoueurDebutant extends Joueur implements Serializable {
    public JoueurDebutant(int id, String nom){
        super(id, nom, Joueur.DEBUTANT);
    }
}
