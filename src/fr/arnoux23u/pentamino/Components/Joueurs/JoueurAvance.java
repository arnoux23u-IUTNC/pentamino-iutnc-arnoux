package fr.arnoux23u.pentamino.Components.Joueurs;

import fr.arnoux23u.pentamino.Components.Joueur;

import java.io.Serializable;

public class JoueurAvance extends Joueur implements Serializable {
    public JoueurAvance(int id, String nom){
        super(id, nom, Joueur.AVANCE);
    }
}
