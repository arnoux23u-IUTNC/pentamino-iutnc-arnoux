package fr.arnoux23u.pentamino.Components;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Piece {
    private int x, y;
    private char identifier;
    private final ArrayList<Carre> listeCarre;
    private String path;


    public Piece(int x, int y, char identifier, String path) {
        this.x = x;
        this.y = y;
        this.identifier = identifier;
        this.path = path;
        listeCarre = new ArrayList<Carre>();
        try {
            FileReader fr = new FileReader(path);
            char item = ' ';
            int line = x, pos = y;
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
        }catch (FileNotFoundException e){
            System.out.println("Impossible de trouver "+path);
        }catch (IOException e){
            System.out.println("Erreur de lecture !");
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Classe ").append(Character.toUpperCase(identifier)).append(" :");
        for(Carre c : listeCarre){
            sb.append("\n\t").append(c);
        }
        return sb.toString();
    };

    public String getPath(){
        return this.path;
    }

    public char getIdentifier(){
        return identifier;
    };

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public ArrayList<Carre> getListeCarre(){
        return this.listeCarre;
    }
}
