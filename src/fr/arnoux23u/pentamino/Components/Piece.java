package fr.arnoux23u.pentamino.Components;

import fr.arnoux23u.pentamino.Components.Pieces.Classes.L;
import fr.arnoux23u.pentamino.Components.Pieces.Classes.P;
import org.jetbrains.annotations.NotNull;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Piece implements Comparable<Piece>, Serializable {
    private int x, y;
    private final char identifier;
    private final ArrayList<Carre> listeCarre;
    private final String path;

    public Piece(char identifier, String path) {
        this.identifier = identifier;
        this.path = path;
        listeCarre = new ArrayList<Carre>();
        try {
            FileReader fr = new FileReader(path);
            char item = ' ';
            int line = 0, pos = 0;
            while ((item = (char) fr.read()) != '\uFFFF') {
                if (item == '#') {
                    Carre carre = new Carre(line, pos);
                    listeCarre.add(carre);
                }
                pos++;
                if (item == '\n') {
                    line++;
                    pos = 0;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Impossible de trouver " + path);
        } catch (IOException e) {
            System.out.println("Erreur de lecture !");
        }
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public Piece setX(int x) {
        this.x = x;
        return this;
    }

    public Piece setY(int y) {
        this.y = y;
        return this;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        char item = ' ';
        try {
            FileReader fr = new FileReader(path);
            while ((item = (char) fr.read()) != '\uFFFF') {
                sb.append(item == '#' || item == '\n' ? item : ' ');
            }
        } catch (IOException ignored) {}
        return sb.toString();

    }

    public String getPath() {
        return this.path;
    }

    public char getIdentifier() {
        return identifier;
    }

    public ArrayList<Carre> getListeCarre() {
        return this.listeCarre;
    }

    @Override
    public int compareTo(@NotNull Piece o) {
        return Character.compare(this.getIdentifier(),o.getIdentifier());
    }


}



