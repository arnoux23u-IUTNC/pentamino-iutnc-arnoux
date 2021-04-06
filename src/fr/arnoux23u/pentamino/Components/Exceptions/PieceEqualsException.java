package fr.arnoux23u.pentamino.Components.Exceptions;

/**
 * Classe Exception Egalité de Pièce
 *
 * @author arnoux23u
 */
public class PieceEqualsException extends Exception {

    /**
     * Constructeur public à un paramètre
     *
     * @param msg Message
     */
    public PieceEqualsException(String msg) {
        super(msg);
    }
}