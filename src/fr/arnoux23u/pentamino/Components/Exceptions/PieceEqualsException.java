package fr.arnoux23u.pentamino.Components.Exceptions;

/**
 * Classe Exception Egalite de Piece
 *
 * @author arnoux23u
 */
public class PieceEqualsException extends Exception {

    /**
     * Constructeur public a un parametre
     *
     * @param msg Message
     */
    public PieceEqualsException(String msg) {
        super(msg);
    }
}