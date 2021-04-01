package fr.arnoux23u.pentamino.Components;

import java.io.Serializable;

public class Carre implements Serializable {
    private final int x, y;

    public Carre(){
        this.x = 0;
        this.y = 0;
    }

    public Carre(int x, int y){
        //TODO VERIFIER QUE CA DEBORDE PAS
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Carre{" +"x = " + x +", y = " + y +'}';
    }

    public boolean equals(Carre c){
        return c.x == this.x && c.y == this.y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}
