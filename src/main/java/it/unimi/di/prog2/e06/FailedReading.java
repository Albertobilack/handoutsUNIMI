package it.unimi.di.prog2.e06;

public class FailedReading extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    /** */
    public FailedReading() { super(); }

    /** */
    public FailedReading(String s) { super(s); }

}
