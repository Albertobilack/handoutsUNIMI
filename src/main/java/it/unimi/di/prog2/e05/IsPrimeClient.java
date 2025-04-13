//specify and implement a procedure isPrime that determines whether an integer is prime

package it.unimi.di.prog2.e05;

/** controlla se un numero è primo, Esercizio 3.3 di PDJ */
public class IsPrimeClient {

    /** costruttore vuoto */
    private IsPrimeClient() {}

    /**
     * controlla se un numero è primo
     * 
     * <p> riceve in input uno o più {@code int} da linea di comando e 
     * stampa su flusso in uscita {@code true} se questo è un numero primo
     * 
     * @param args contiene gli interi da testare
     * @throws IllegalArgumentException se {@code args} non contiene uno o più elementi != {@code int}
     */
    public static void main(String[] args) throws IllegalArgumentException {
        
        for (String s : args) {
            int value;
            try { value = Integer.parseInt(s);}
            catch (IllegalArgumentException e) {throw new IllegalArgumentException();}
            if (IsPrime.checkPrime(value)) {System.out.println("true");}
        }

    }

}


/** Esercizio 3.3 di PDJ. */
//public class IsPrimeClient {
//
//  /**
//   * Private constructor to prevent instantiation
//   */
//  private IsPrimeClient() {}
//
//
//  /**
//   * Main method to test the {@code isPrime} method
//   * 
//   * @param args an array of {@code String} containing the numbers that must be checked
//   */
//  public static void main(String[] args) {
//    
//    int length = args.length;
//    for (int i=0; i<length; i++) {
//      if (isPrime(Integer.parseInt(args[i]))) {
//        System.out.println("true");
//      }
//    }
//  }
//
//  /**
//   * The method return true if the argument is a prime number
//   *  
//   * @param input number that must be checked
//   * @return {@code true} if the input is a prime number, {@code false} otherwise 
//  */
//  private static boolean isPrime(int input) {
//    
//    if (input <= 1) return false;
//    if (input == 3 || input ==2) {
//      return true;
//    } else if (input % 2 == 0) {
//      return false;
//    }
//
//    double square = Math.sqrt((double) input);
//
//    for (int i=3; i<=square; i+=2) {
//      if (input % i == 0) {
//        return false;
//      } 
//    }
//
//    return true;
//  }
//
//
//}
