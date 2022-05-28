package task11a;

public class StringTooLongException extends  RuntimeException{

    public StringTooLongException(String message){
        super(message);
    }

    public StringTooLongException() {
        this("This string is too long.");
    }

}
