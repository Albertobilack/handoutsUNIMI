package it.unimi.di.prog2.e06;

public class InvalidInputFormat extends RuntimeException{
    
    private static final long serialVersionUID = 1L;

    public InvalidInputFormat() { super(); }
    public InvalidInputFormat(String s) { super(s); }

}
