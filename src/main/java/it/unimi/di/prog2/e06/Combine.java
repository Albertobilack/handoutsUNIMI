package it.unimi.di.prog2.e06;

/**
 *
 */
public class Combine {

    /**
     * Modify {@code a} by multipling each of his elements by the sum of
     * elements in {@code b}
     *
     * @param a
     * @param b
     * @throws NullPointerException if a == {@code null} or b == {@code null}
     */
    public static void combineValues(int[] a, int[] b) throws NullPointerException {

        if (a == null || b == null) {
            throw new NullPointerException();
        }

        if (a.length != 0 && b.length != 0) {
            int sumB = 0;
            for (int value : b) {
                sumB += value;
            }
            for (int i = 0; i < a.length; i++) {
                a[i] = a[i] * sumB;
            }
        }
    }

}
