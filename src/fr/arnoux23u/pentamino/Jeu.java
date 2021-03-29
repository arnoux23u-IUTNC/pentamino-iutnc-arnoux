package fr.arnoux23u.pentamino;

import fr.arnoux23u.pentamino.Components.*;
import fr.arnoux23u.pentamino.Components.Joueurs.*;
import fr.arnoux23u.pentamino.Components.Pieces.Classes.*;
import fr.arnoux23u.pentamino.Utils.JoueurComparator;
import org.jetbrains.annotations.Contract;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.System.exit;

public class Jeu implements Serializable {
    public static final String path = ".\\src\\fr\\arnoux23u\\pentamino\\";
    private final ArrayList<Joueur> listeJoueurs;
    private static final Scanner sc = new Scanner(System.in);
    public int NBJOUEUR = 0;

    public Jeu() {
        listeJoueurs = new ArrayList<Joueur>();
    }

    ;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Bienvenue sur le Pentamino !\n\033[3mMade by Guillaume and Quentin\033[0m\n\n1 : Charger la sauvegarde, 2 : Nouvelle partie");
        int choice = sc.nextInt();
        Jeu jeu = null;
        if (choice == 1) {
            jeu = choixSauvegardes();
        }
        if (jeu == null) {
            jeu = nouvellePartie();
        }

        /*//TODO DEBUG
        Jeu jeu = new Jeu();
        Joueur j1 = new JoueurDebutant("Tules");
        Joueur j5 = new JoueurDebutant("Roploploplo");
        j1.setScore(20.0);
        j5.setScore(1020.1);
        Joueur j3 = new JoueurIntermediaire("Louis");
        j3.setScore(100.14);
        Joueur j4 = new JoueurAvance("Jules");
        j4.setScore(2.588454);
        jeu.listeJoueurs.add(j1);
        jeu.listeJoueurs.add(j3);
        jeu.listeJoueurs.add(j5);
        jeu.listeJoueurs.add(j4);
        //TODO FINDEBUG*/

        System.out.println("Partie valide !");
        Joueur player = null;
        boolean noEmpty = jeu.afficherJoueurs();

        choice = sc.nextInt();
        if(noEmpty){
            switch (choice) {
                case 0 -> jeu.sauvegarder();
                case 1 -> player = jeu.choisirJoueur();
                default -> player = jeu.creerJoueur();
            }
        }else{
            if (choice == 0) {
                jeu.sauvegarder();
            } else {
                player = jeu.creerJoueur();
            }
        }
        System.out.println("Joueur sélectionné :");
        System.out.println("\t"+player);
        assert player != null;
        System.out.println("Bienvenue "+ (player.getName().toLowerCase().contains("guillaume") || player.getName().toLowerCase().contains("quentin") ? ("Maitre "+player.getName()) : player.getName()));
        boolean isParties = player.afficherParties();
        Partie partie = null;
        choice = sc.nextInt();
        if(isParties){
            switch (choice) {
                case 0 -> jeu.sauvegarder();
                case 1 -> partie = player.choisirPartie();
                default -> partie = player.creerPartie();
            }
        }else{
            if (choice == 0) {
                jeu.sauvegarder();
            } else {
                partie = player.creerPartie();
            }
        }
        System.out.println("Partie selectionnée :");
        System.out.println("\t"+partie);
        assert partie != null;
        partie.jouer();
        jeu.sauvegarder();

    }

    private Joueur choisirJoueur() {
        System.out.println("Entrez ID (premiere colonne) : ");
        Joueur j = null;
        try {
            int id = sc.nextInt();
            for(Joueur pl : this.listeJoueurs){
                if(pl.getId() == id){
                    j = pl;
                    System.out.println("Vous avez choisi : " +j.getName());
                    break;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Joueur n'existe pas");
            j = creerJoueur();
        }
        return j;
    }

    private Joueur creerJoueur() {
        System.out.println("Création joueur, entrez nom");
        String name = sc.next();
        System.out.println("Entrez difficulté (Debutant : 0, Intermediaire : 1, Avance : 2)");
        int diff = sc.nextInt();
        int id = this.listeJoueurs.size();
        Joueur j = null;
        switch (diff) {
            case 1 -> {
                j = new JoueurIntermediaire(id, name);
            }
            case 2 -> {
                j = new JoueurAvance(id, name);
            }
            default -> {
                j =  new JoueurDebutant(id, name);
            }
        }
        this.listeJoueurs.add(j);
        return j;
    }

    private static Jeu choixSauvegardes() throws IOException, ClassNotFoundException {
        File f = new File(path + "Saves\\");
        File[] files = f.listFiles();
        System.out.println("Liste des sauvegardes : ");
        int i = 0;
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("\t" + i + " | " + (file.getName()));
                    i++;
                }
            }
            System.out.println("Choisissez un numéro");
            int num = sc.nextInt();
            return (Jeu) new ObjectInputStream(new FileInputStream(files[num])).readObject();
        } else {
            System.out.println("\tAucune sauvegarde ...");
            return null;
        }
    }

    private boolean afficherJoueurs() {
        if (this.listeJoueurs.isEmpty()) {
            System.out.println("Aucun joueur\n0 : Quitter, 1 : Creer un nouveau joueur");
            return false;
        } else {
            System.out.println("Liste des joueurs :\n\t- Ordre alphabétique :");
            Collections.sort(this.listeJoueurs);
            affiche();
            this.listeJoueurs.sort(new JoueurComparator());
            System.out.println("\t- Ordre Score décroissant :");
            affiche();
            Collections.sort(this.listeJoueurs);
            System.out.println("0 : Quitter, 1 : Selectionner un joueur, 2 : Creer un nouveau joueur ");
            return true;
        }
    }

    public void affiche() {
        for (Joueur j : listeJoueurs) {
            System.out.printf("\t\t%02d : %10s (%d | %1c) -> (%05d)%n", j.getId(), (j.getName().length() > 9) ? j.getName().substring(0, 9) : j.getName(), j.getType(), j.getTypeIdentifier(), j.getScore());
        }
    }


    private static Jeu nouvellePartie() throws IOException, ClassNotFoundException {
        return new Jeu();
    }

    private void sauvegarder() throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path + "Saves\\" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ".bin"));
        oos.writeObject(this);
        oos.close();
        sc.close();
        exit(0);
    }
}

