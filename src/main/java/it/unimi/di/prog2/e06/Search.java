package it.unimi.di.prog2.e06;

/*
 * the Class implement search in two ways: using for loops, and using while (true) loops that are terminated when accesing 
 * the array raises IndexOutOfBoundsException.

	CONSIDERAZIONI: essendo i metodi pubblici, controlleremo di nuovo che sequence sia ordinata, se i metodi fossero privati,
	essendo che abbiamo già effettuato questo controllo nel main, non sarebbe necessario, e potremmo rendere la funzione parziale
	per permettere una maggiore efficenza mettendo come clausola require "sequence must be sorted in ascending order"  
 */

public class Search {

	/** Private constructor to prevent instantiation */
	private Search() {
	}

	// public static void main(String[] args) {
		
	// }

	/**
	 * NB: array può essere empty e ritorna -1
	 * this method search for an {@code int} inside an {@code array} of {@code int}  
	 * 
	 * @param sequence array that must be inspected {@code int}
	 * @param target integer that must be searched
	 * @return the index of {@code target} if contained in {@code sequence}, {@code -1} otherwise
	 */
	public static int searchWithLoop(int[] sequence, int target) {
		for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] == target) {
                return i; 
            } else if (sequence[i] > target) {
                break;
            }
        }
        return -1;
    }

	/**
	 * this method search for an {@code int} inside an {@code array} of {@code int}  
	 * 
	 * @param sequence array that must be inspected {@code int}
	 * @param target integer that must be searched
	 * @return the index of {@code target} if contained in {@code sequence}, {@code -1} otherwise
	 */
	public static int searchWithWhile(int[] sequence, int target) {
		int i = 0;
		while (true) {
			try {
				if (sequence[i] == target) {
					return i;
				}
			} catch (IndexOutOfBoundsException e) {
				return -1;
			}
			i++;
		}
	}
}
