package it.unimi.di.prog2.e06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Esercizio 4.4 di PDJ.
 * Combine multiplies each element of a by the sum of the
 * elements of b; for example, if a = [1 ,2, 3] and b = [4, 5], the on return
 * a=[9, 18, 27]. What should this procedure do if a or b is null or empty? Give
 * a specification for combine that answer these questions and explain why your
 * specification is a good one.
 */

public class CombineClient {

    /**
     * .
     */
    private CombineClient() {
    }

    /**
     * Decodifica una stringa contenente interi separati da spazi.
     *
     * @param string la stringa in ingresso, non può essere {@code null} e deve
     * contenere interi separati da spazi
     *
     * @return gli interi contenuti nella stringa.
     *
     */
    private static int[] parseInts(String string) {
        List<Integer> list = new ArrayList<>();
        try (Scanner sl = new Scanner(string)) {
            while (sl.hasNextInt()) {
                list.add(sl.nextInt());
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    /**
     * Used to test combineValues method from Combine class.
     * Read from {@code system.in} two lines containing integers separated by spaces,
     * and modify the values of each element of the first line {@code a} by
     * multipling them by the sum of the elements of the second line {@code B}
     * If {@code A} or {@code B} is null, an exception is raised, if system.in
     * contains non-integer input, an exception is raised
     *
     * (se sono vuoti è accettabile)
     *
     * @param args not used
     * @param system.in used to read {@code A} and {@code B}
     * @throws IllegalArgumentException if input is incorrect or scanner fails 
     */
    public static void main(String[] args) throws IllegalArgumentException {

        int[] a;
        int[] b;

        try (Scanner s = new Scanner(System.in)) {
            a = parseInts(s.nextLine());
            b = parseInts(s.nextLine());
        } catch (RuntimeException e) { //catch illegalstate and nosuchelement
            throw new IllegalArgumentException("exception reading input lines on main method class CombineClient");
        }

        try {
            Combine.combineValues(a, b);
        } catch (NullPointerException e) { //should not happen so maybe I can avoid it
            throw new NullPointerException("exception calling combineValues on main method class CombineClient");
        }

        for (int value : a) {
            System.out.println(value);
        }

    }

    // Il main di questa classe legge due righe dal flusso di ingresso ciascuna
    // delle quali contiene gli interi (separati da spazi) di uno dei due array da
    // combinare e ne emette il risultato della combinazione (separando gli interi
    // uno per linea). Può avvalersi della funzione precedente per decodificare
    // ciascuna delle due linee in ingresso.
}
