package it.unimi.di.prog2.e06;

//mi aspetto che user controlli se sequenza è sortata, è un erorre evitabile e gestibile
public class SequenceNotSorted extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public SequenceNotSorted() {super();}
    public SequenceNotSorted(String s) {super(s);}

}

//non ho controllo sull'input utente, quindi utlizzo exception
//utlizzando exception sto dicendo al programmatore di controllare sempre di gestire
//questa casistica perchè non c'è modo di controllarla
// class NumberFormatException extends Exception {

//     public NumberFormatException() {super();}
//     public NumberFormatException(String s) {super(s);}

// }

// class IllegalArgumentException extends Exception {

//     public IllegalArgumentException() {super();}
//     public IllegalArgumentException(String s) {super(s);} 

// }