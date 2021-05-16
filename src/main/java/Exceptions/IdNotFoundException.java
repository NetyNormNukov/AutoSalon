package Exceptions;

public class IdNotFoundException extends Exception{
    public IdNotFoundException(){ }
    public IdNotFoundException(String gripe){
        super(gripe);
    }
}
