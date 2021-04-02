package fr.arnoux23u.pentamino.Components.Exceptions;

public class PieceEqualsException extends Exception{
    public PieceEqualsException(){
        super();
    }

    public PieceEqualsException(String msg){
        super(msg);
    }
}