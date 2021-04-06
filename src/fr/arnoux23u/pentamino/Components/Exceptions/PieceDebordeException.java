package fr.arnoux23u.pentamino.Components.Exceptions;

/**
 * Classe Exception Débordement de Pièce
 *
 * @author arnoux23u
 */
public class PieceDebordeException extends Exception {

    /**
     * Constructeur public à un paramètre
     *
     * @param msg Message
     */
    public PieceDebordeException(String msg) {
        super(msg);
    }
}