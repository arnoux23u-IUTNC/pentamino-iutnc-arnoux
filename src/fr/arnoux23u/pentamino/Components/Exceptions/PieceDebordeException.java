package fr.arnoux23u.pentamino.Components.Exceptions;

/**
 * Classe Exception Debordement de Piece
 *
 * @author arnoux23u
 */
public class PieceDebordeException extends Exception {

    /**
     * Constructeur public a un parametre
     *
     * @param msg Message
     */
    public PieceDebordeException(String msg) {
        super(msg);
    }
}