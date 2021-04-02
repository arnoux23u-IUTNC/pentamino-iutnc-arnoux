package fr.arnoux23u.pentamino.Components;

import java.io.Serializable;
import java.util.Objects;

public class Carre implements Serializable {
    private final int x, y;

    public Carre(){
        this.x = 0;
        this.y = 0;
    }

    public Carre(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Carre{" +"x = " + x +", y = " + y +'}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Carre)) return false;
        Carre carre = (Carre) o;
        return x == carre.x && y == carre.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}
