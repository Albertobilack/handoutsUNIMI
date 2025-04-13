package it.unimi.di.prog2.e05;

/**classe utility di IsPrimeClient contiene metodi per controllare numeri primi */
public class IsPrime {
    
    /** placeholder */
    private IsPrime() {}

    /**
     * ritorna true se l'argomento è un numero primo
     * 
     * @param numero deve essere un {@code int}
     * @return {@code true} se {@code numero} è primo, altrimenti {@code false}
     */
    public static boolean checkPrime(int numero) {

        if (numero <= 1) return false;
        if (numero == 3 || numero ==2) {
          return true;
        } else if (numero % 2 == 0) {
          return false;
        }

        double square = Math.sqrt((double) numero);
        for (int i=3; i<=square; i+=2) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

}
