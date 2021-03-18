package fr.arnoux23u.pentamino.Components;

public class Carre {
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
}