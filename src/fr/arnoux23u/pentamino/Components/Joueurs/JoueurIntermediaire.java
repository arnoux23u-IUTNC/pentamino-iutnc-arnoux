package fr.arnoux23u.pentamino.Components.Joueurs;

import fr.arnoux23u.pentamino.Components.Joueur;

import java.io.Serializable;

public class JoueurIntermediaire extends Joueur implements Serializable {
    public JoueurIntermediaire(int id, String nom){
        super(id, nom, Joueur.INTERMEDIAIRE);
    }
}
