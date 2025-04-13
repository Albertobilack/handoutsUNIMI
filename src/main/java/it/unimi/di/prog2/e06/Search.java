package it.unimi.di.prog2.e06;

import java.security.InvalidParameterException;

/**
 * classe utility per SearchClient che contiene metodi per la ricerca di un Integer 
 * in una lista di Integer
 */
public class Search {

	/** placeholder */
	private Search() {}

	//parametri non possono essere vuoti per definizione di un metodo in java
	//non viene gestito il caso in cui sequence non è ordinato, sarebbe inutilmente costoso
	/**
	 * restituisce la posizione di {@code target} all'interno di {@code sequence}
	 * 
	 * <p> se target si trova all'interno di sequence ne restituisce la posizione,
	 * altrimenti restituisce -1
	 * 
	 * 
	 * @param sequence sequenza di {@code int}, deve essere ordinata in ordine crescente
	 * @param target {@code int} da cercare
	 * @return posizione di {@code target} se presente in {@code sequence}, {@code -1} altrimenti
	 * 
	 */
	public static int indexSearch(int target, int[] sequence) {

		int left = 0;
        int right = sequence.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (sequence[mid] == target) {
                return mid; // trovato!
            } else if (sequence[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // non trovato

	}

}



























/*
 * the Class implement search in two ways: using for loops, and using while (true) loops that are terminated when accesing 
 * the array raises IndexOutOfBoundsException.

	CONSIDERAZIONI: essendo i metodi pubblici, controlleremo di nuovo che sequence sia ordinata, se i metodi fossero privati,
	essendo che abbiamo già effettuato questo controllo nel main, non sarebbe necessario, e potremmo rendere la funzione parziale
	per permettere una maggiore efficenza mettendo come clausola require "sequence must be sorted in ascending order"  
 */
/** PLACEHOLDER */
//public class Search {
//
//	/** Private constructor to prevent instantiation */
//	private Search() {
//	}
//
//	// public static void main(String[] args) {
//		
//	// }
//
//	/**
//	 * NB: array può essere empty e ritorna -1
//	 * this method search for an {@code int} inside an {@code array} of {@code int}  
//	 * 
//	 * @param sequence array that must be inspected {@code int}
//	 * @param target integer that must be searched
//	 * @return the index of {@code target} if contained in {@code sequence}, {@code -1} otherwise
//	 */
//	public static int searchWithLoop(int[] sequence, int target) {
//		for (int i = 0; i < sequence.length; i++) {
//            if (sequence[i] == target) {
//                return i; 
//            } else if (sequence[i] > target) {
//                break;
//            }
//        }
//        return -1;
//    }
//
//	/**
//	 * this method search for an {@code int} inside an {@code array} of {@code int}  
//	 * 
//	 * @param sequence array that must be inspected {@code int}
//	 * @param target integer that must be searched
//	 * @return the index of {@code target} if contained in {@code sequence}, {@code -1} otherwise
//	 */
//	public static int searchWithWhile(int[] sequence, int target) {
//		int i = 0;
//		while (true) {
//			try {
//				if (sequence[i] == target) {
//					return i;
//				}
//			} catch (IndexOutOfBoundsException e) {
//				return -1;
//			}
//			i++;
//		}
//	}
//}
//