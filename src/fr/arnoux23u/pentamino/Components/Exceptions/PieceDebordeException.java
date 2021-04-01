package fr.arnoux23u.pentamino.Components.Exceptions;

public class PieceDebordeException extends Exception{
    public PieceDebordeException(){
        super();
    }

    public PieceDebordeException(String msg){
        super(msg);
    }
}