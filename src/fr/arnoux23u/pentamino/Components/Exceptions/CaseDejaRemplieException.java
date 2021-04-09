package fr.arnoux23u.pentamino.Components.Exceptions;

/**
 * Classe Exception Case Deja Remplie
 *
 * @author arnoux23u
 */
public class CaseDejaRemplieException extends Exception {

    /**
     * Constructeur public a un parametre
     *
     * @param msg Message
     */
    public CaseDejaRemplieException(String msg) {
        super(msg);
    }
}
