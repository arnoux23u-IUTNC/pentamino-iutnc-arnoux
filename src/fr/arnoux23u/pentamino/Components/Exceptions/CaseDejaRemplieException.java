package fr.arnoux23u.pentamino.Components.Exceptions;

/**
 * Classe Exception Case Deja Remplie
 */
public class CaseDejaRemplieException extends Exception {

    /**
     * Constructeur public par défaut
     */
    public CaseDejaRemplieException() {
        super();
    }

    /**
     * Constructeur public à un paramètre
     *
     * @param msg Message
     */
    public CaseDejaRemplieException(String msg) {
        super(msg);
    }
}
