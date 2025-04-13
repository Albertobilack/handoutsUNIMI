package it.unimi.di.prog2.e06;
import java.util.List;

/**
 * classe utility per SumClient
 * contiene metodi per somma di elementi in un array
 */
public class Sum {

    /**PLACEHOLDER */
    private Sum() {}

    //ricordiamo che un oggetto non può essere passato come argomento se non è inizializzato
    //ma totalmente possibile se è vuoto
    //ed è totalmente possibile se è = null. non possiamo determinare la somma di un null o di un empty
    /**
     * returns the sum of all elemenets in the given list of integers.
     * 
     * <p> requires the given list to be non-empty and != null
     * 
     * @param sequence contains the numbers whose sum is to be determined
     * @return the sum of all the elements in {@code sequence}
     * @throws IllegalArgumentException if {@code sequence} is empty.
     * @throws NullPointerException if {@code sequence} is null.
     */
    public static int ListInteger(List<Integer> sequence) throws IllegalArgumentException, NullPointerException{

        if (sequence == null) { throw new NullPointerException("Sum.ListInteger"); }
        if (sequence.size() == 0) { throw new IllegalArgumentException("Sum.ListInteger"); }

        int sum = 0;
        for (Integer i : sequence) {
            sum += i;
        }

        return sum;
    }

}










//
///** PLACEHOLDER */
//public class Sum {
//    
//    /** Private constructor to prevent instantiation */
//    private Sum() {}
//
//    /**
//     * method that compute the sum of all elements of a given array of {@code int} 
//     * if {@code numbers} is empty, throws {@code IllegalArgumentException}
//     * 
//     * @param numbers array of {@code int}, must be non-empty
//     * @return sum of the elements of the array
//     */
//    public static int sumOfArray(int[] numbers) {
//
//        if (numbers.length == 0) {
//            throw (new IllegalArgumentException("Array must be non-empty, method sumOfArray class Sum"));
//        }
//
//        int sum = 0;
//        for (int number : numbers) {
//            sum += number;
//        }
//        return sum;
//    }
//
//}
