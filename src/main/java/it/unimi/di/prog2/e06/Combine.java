package it.unimi.di.prog2.e06;
import java.util.ArrayList;
import java.util.List;

/**
 * utility class for CombineClient
 */
public class Combine {

    /**PLACEHOLDER */
    private Combine() {}

    /**
     * return the sum of the given list
     * 
     * @param container contains the numbers whom sum must be computed
     * @throws IllegalArgumentException if {@code container} is empty
     */
    public static int sumList(List<Integer> container) throws IllegalArgumentException {

        if (container.size() == 0) {throw new IllegalArgumentException();}

        int sum = 0;
        for(int i : container) {
            sum+= i;
        }

        return sum;
    }


    //dobbiamo decidere se modificare container o ritornarne uno nuovo
    //preferisco ritornarne uno nuovo
    //e se container è vuoto? ritorniamo una lista vuota
    /**
     * return a new List containing each element of {@code container} multiplied by {@code multip}
     * 
     * <p> the returned list will have the same order as {@code container}.
     * returns an empty list if {@code container} is empty
     * 
     * @param containers contains elements that must be multiplied with {@code multip}    
     * @param multip the multiplier
     * 
     */
    public static List<Integer> multiplyList(List<Integer> container, int multip) {
        
        List<Integer> multipList = new ArrayList<>();
        
        for(int i : container) {
            multipList.add(i*multip);
        }
        
        return multipList;

    }

}


//
//public class Combine {
//
//    /** PLACEHOLDER */
//    private Combine () {}
//
//    /**
//     * Modify {@code a} by multipling each of his elements by the sum of
//     * elements in {@code b}
//     *
//     * @param a PLACEHOLDER
//     * @param b PLACEHOLDER
//     * @throws NullPointerException if a == {@code null} or b == {@code null}
//     */
//    public static void combineValues(int[] a, int[] b) throws NullPointerException {
//
//        if (a == null || b == null) {
//            throw new NullPointerException();
//        }
//
//        if (a.length != 0 && b.length != 0) {
//            int sumB = 0;
//            for (int value : b) {
//                sumB += value;
//            }
//            for (int i = 0; i < a.length; i++) {
//                a[i] = a[i] * sumB;
//            }
//        }
//    }
//
//}
//