package fr.arnoux23u.pentamino;

import fr.arnoux23u.pentamino.Components.*;
import fr.arnoux23u.pentamino.Components.Joueurs.*;
import fr.arnoux23u.pentamino.Utils.JoueurComparator;

import java.io.*;
import java.text.*;
import java.util.*;

import static java.lang.System.exit;

/**
 * classe Principale Jeu
 * Depot GitHub : https://github.com/guillaumearnx/pentamino-iutnc-arnoux
 *
 * @author arnoux23u
 */
public class Jeu implements Serializable {

    /**
     * Attribut public
     * Lien utilise par d'autres classes
     */
    public static final String path = ".\\src\\fr\\arnoux23u\\pentamino\\";

    /**
     * Attribut prive
     * Liste des joueurs
     */
    private final ArrayList<Joueur> listeJoueurs;

    /**
     * Attribut public
     * Scanner principal (pour eviter l'instanciation multiple)
     */
    public static Scanner sc = new Scanner(System.in);

    /**
     * Constructeur public par defaut, instancie la liste des joueurs
     */
    public Jeu() {
        listeJoueurs = new ArrayList<Joueur>();
    }

    /**
     * Methode main
     *
     * @param args arguments
     */
    public static void main(String[] args) {
        System.out.println("Bienvenue sur le Pentamino !\n\033[3mMade by Guillaume and Quentin\033[0m\n\n1 : Charger la sauvegarde, 2 : Nouvelle partie");
        int choice = 0;
        try {
            choice = sc.nextInt();
        } catch (InputMismatchException e) {
            sc.close();
            exit(0);
        }
        Jeu jeu = null;
        File lSave = new File(path + "Saves\\");
        if (!lSave.exists()) {
            lSave.mkdir();
        }
        if (choice == 1) {
            jeu = choisirSauvegardes();
        }
        if (jeu == null) {
            jeu = creerJeu();
        }
        System.out.println("Jeu valide !");
        try {
            jeu.demarrer();
        } catch (Exception e) {
            jeu.sauvegarder();
        }
    }

    /**
     * Methode demmarer
     */
    private void demarrer() {
        Joueur player = null;
        boolean noEmpty = this.afficherJoueurs();
        int choice = sc.nextInt();
        if (noEmpty) {
            switch (choice) {
                case 0:
                    this.sauvegarder();
                    break;
                case 1:
                    player = this.choisirJoueur();
                    break;
                default:
                    player = this.creerJoueur();
                    break;
            }
        } else {
            if (choice == 0) {
                this.sauvegarder();
            } else {
                player = this.creerJoueur();
            }
        }
        System.out.println("Joueur sélectionné :");
        System.out.println("\t" + player);
        assert player != null;
        System.out.println("Bienvenue " + (player.getName().toLowerCase().contains("guillaume") || player.getName().toLowerCase().contains("quentin") ? ("Maitre " + player.getName()) : player.getName()));
        player.lancer(this);
        this.sauvegarder();
    }

    /**
     * Methode de selection d'un Joueur
     *
     * @return Joueur selectionne
     */
    private Joueur choisirJoueur() {
        System.out.println("Entrez ID (premiere colonne) : ");
        Joueur j = null;
        try {
            int id = sc.nextInt();
            for (Joueur pl : this.listeJoueurs) {
                if (pl.getId() == id) {
                    j = pl;
                    System.out.println("Vous avez choisi : " + j.getName());
                    break;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Joueur n'existe pas");
            j = creerJoueur();
        }
        return j;
    }

    /**
     * Methode de creation d'un Joueur
     *
     * @return Joueur cree
     */
    private Joueur creerJoueur() {
        System.out.println("Création joueur, entrez nom");
        String name = sc.next();
        System.out.println("Entrez difficulté (Debutant : 0, Intermediaire : 1, Avance : 2)");
        int diff = sc.nextInt();
        int id = this.listeJoueurs.size();
        Joueur j;
        switch (diff) {
            case 1:
                j = new JoueurIntermediaire(id, name);
                break;
            case 2:
                j = new JoueurAvance(id, name);
                break;
            default:
                j = new JoueurDebutant(id, name);
                break;
        }
        this.listeJoueurs.add(j);
        return j;
    }

    /**
     * Methode statique de choix d'une sauvegarde
     *
     * @return Jeu : sauvegarde
     */
    private static Jeu choisirSauvegardes() {
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
            try {
                return (Jeu) new ObjectInputStream(new FileInputStream(files[num])).readObject();
            } catch (ClassNotFoundException e) {
                System.out.println("Impossible de trouver la classe Jeu");
            } catch (IOException e) {
                System.out.println("Impossible de lire jeu");
            }
        } else {
            System.out.println("\tAucune sauvegarde ...");
        }
        return null;
    }

    /**
     * Methode de creation de Jeu
     *
     * @return Jeu cree
     */
    private static Jeu creerJeu() {
        return new Jeu();
    }

    /**
     * Methode d'affichage des joueurs
     *
     * @return booleen, a vrai si il y a des joueurs
     */
    private boolean afficherJoueurs() {
        if (this.listeJoueurs.isEmpty()) {
            System.out.println("Aucun joueur\n0 : Quitter, 1 : Creer un nouveau joueur");
            return false;
        } else {
            System.out.println("Liste des joueurs :\n\t- Ordre alphabétique :");
            Collections.sort(this.listeJoueurs);
            afficherListeJoueurs();
            Collections.sort(listeJoueurs, new JoueurComparator());
            System.out.println("\t- Ordre Score décroissant :");
            afficherListeJoueurs();
            Collections.sort(this.listeJoueurs);
            System.out.println("0 : Quitter, 1 : Selectionner un joueur, 2 : Creer un nouveau joueur ");
            return true;
        }
    }

    /**
     * Methode d'affichage des joueurs (concret)
     */
    public void afficherListeJoueurs() {
        for (Joueur j : listeJoueurs) {
            System.out.printf("\t\t%02d : %10s (%d | %1c) -> (%05d)%n", j.getId(), (j.getName().length() > 9) ? j.getName().substring(0, 9) : j.getName(), j.getType(), j.getTypeIdentifier(), j.getScore());
        }
    }

    /**
     * Methode de sauvegarde, termine le processus
     */
    public void sauvegarder() {
        System.out.println("Fin du jeu");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path + "Saves\\" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ".bin"));
            for (Joueur j : this.listeJoueurs) {
                int score = 0;
                for (Partie p : j.getListeParties()) {
                    score += p.getScore();
                }
                int multiplicateur = j.getType() == 0 ? 1 : (j.getType() == 1 ? 2 : 4);
                j.setScore(score * multiplicateur);
            }
            oos.writeObject(this);
            oos.close();
        } catch (IOException e) {
            System.out.println("Impossible de sauvegarder le jeu");
        }
        sc.close();
        exit(0);
    }
}

