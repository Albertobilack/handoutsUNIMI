package it.unimi.di.prog2.e05;
import java.util.List;

/**
 * classe utility che contiene metodi per la somma utilizzati in SumClient
 */
public class Sum {
    
    /** . */
    private Sum() {}

    /**
     * restituisce la somma di una lista di numeri.
     * 
     * @param numbers contiene gli {@code int} da sommare
     * @return somma del contenuto di {@code numbers}
     */
    public static int SumNumbers(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

}
