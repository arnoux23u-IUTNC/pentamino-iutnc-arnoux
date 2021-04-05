package fr.arnoux23u.pentamino.Components.Exceptions;

/**
 * Classe Exception Egalité de Pièce
 */
public class PieceEqualsException extends Exception {

    /**
     * Constructeur public par défaut
     */
    public PieceEqualsException() {
        super();
    }

    /**
     * Constructeur public à un paramètre
     *
     * @param msg Message
     */
    public PieceEqualsException(String msg) {
        super(msg);
    }
}