package task11b;

public class StringTooLongException extends Exception {

    public StringTooLongException(String message){
        super(message);
    }

    public StringTooLongException() {
        this("This string is too long.");
    }
}
