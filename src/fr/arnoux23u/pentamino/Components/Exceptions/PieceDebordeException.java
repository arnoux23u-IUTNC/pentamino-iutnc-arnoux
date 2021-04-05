package fr.arnoux23u.pentamino.Components.Exceptions;

/**
 * Classe Exception Débordement de Pièce
 */
public class PieceDebordeException extends Exception {

    /**
     * Constructeur public par défaut
     */
    public PieceDebordeException() {
        super();
    }

    /**
     * Constructeur public à un paramètre
     *
     * @param msg Message
     */
    public PieceDebordeException(String msg) {
        super(msg);
    }
}