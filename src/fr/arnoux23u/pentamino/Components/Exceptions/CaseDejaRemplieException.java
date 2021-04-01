package fr.arnoux23u.pentamino.Components.Exceptions;

public class CaseDejaRemplieException extends Exception{
    public CaseDejaRemplieException(){
        super();
    }

    public CaseDejaRemplieException(String msg){
        super(msg);
    }
}
