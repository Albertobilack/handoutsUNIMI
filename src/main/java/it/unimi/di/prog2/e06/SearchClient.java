package it.unimi.di.prog2.e06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Esercizio 4.2 di PDJ. */
public class SearchClient {

	/** . */
	private SearchClient() {}

	/**
	 * trova la posizione di un intero all'interno di una sequenza
	 * 
	 * <p> legge dal flusso di ingresso una sequenza di interi (separati da spazi) e, 
	 * assumendo che sia ordinata in ordine crescente, emette nel flusso d'uscita la posizione 
	 * dell'intero specificato sulla linea di comando (se presente nell'input), o -1 viceversa.
	 * 
	 * @param args contiene il numero da cercare nella posizione zero
	 * @throws IllegalArgumentException se {@code agrs[0]} contiene un argomento non traducibile in {@code int} o è vuoto; se
	 * viene inserito da flusso di ingresso un argomento non traducibile in {@code int} o non vengono forniti argomenti; se gli argomenti da flusso
	 * di ingresso non sono ordinati correttamente
	 */
	
	public static void main(String[] args) throws IllegalArgumentException {
		
		if (args.length == 0) {
			throw new IllegalArgumentException("SearchClient.main");
		}

		int target;
		try {
			target = Integer.parseInt(args[0]); 
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("SearchClient.main"); 
		}

		List<String> stringSequence = new ArrayList<>();
		try(Scanner s = new Scanner(System.in)) { 
			while(s.hasNext()) {
				stringSequence.add(s.next());
			}
		} catch(IllegalStateException e) {
			throw new IllegalStateException("SearchClient.main errore scanner");
		}

		if (stringSequence.size() == 0) {
			throw new IllegalArgumentException("SearchClient.java");
		}

		int[] numberSequence = new int[stringSequence.size()];
		for (int i=0; i<stringSequence.size(); i++) {
			try {
				numberSequence[i] = Integer.parseInt(stringSequence.get(i));
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("SearchClient.main errore input non valido");
			}
		}

		int prev = numberSequence[0];
		for (int i=1; i<numberSequence.length; i++) {
			if (prev>numberSequence[i]) {throw new IllegalArgumentException("SearchClient.main input non ordinato correttamente");}
		}

		int index = Search.indexSearch(target, numberSequence);

		System.out.println(index);

	}
  
  }
































//import java.util.Scanner;
//import java.util.List;
//import java.util.ArrayList;

/**
 * Esercizio 4.2 di PDJ.
 * Considerazioni: essendo un metodo pubblico assumeremo che i contratti non vengano sempre rispettati
 * Considerazioni: non trovare il numero all'interno della sequenza non è una
 * "call con illegal arguments" di conseguenza non viene tratta come un errore
 * e gestita con le eccezioni ma ritornando un valore preciso
 */
//public class SearchClient {
//
//	/** Private constructor to prevent instantiation */
//	private SearchClient() {}
//
//	/**
//	 * QUESTO È UN METODO TOTALE CHE GESTISCE SOTTOINSIEME DI INPUT NON CORRETTI CON
//	 * EXCEPTION, QUINDI INVECE CHE USARE REQUIRE SI DEFINISCONO
//	 * GLI EFFETTI DEGLI INPUT NON CORRETTI
//	 * 
//	 * Main method to test {@code searchWithLoop} and {@code searchWithWhile} methods of the class {@code Search}
//	 * 
//	 * if {@code args} is empty raise {@code IllegalArgumentException},
//	 * else if {@code args} at index 0 does not contain a number or arguments of the sequence
//	 * are not numbers, raise {@code NumberFormatException} else if the sequence given from
//	 * {@code System.in} is not sorted, raise {@code SequenceNotSorted}
//	 * else the method modifies {@code System.out} printing the index of the Integer
//	 * contained in {@code args[0]} if it is found in the sequence
//	 * given from {@code System.in}, {@code -1} otherwhise
//	 * 
//	 * atparam System.in sequence of {@code integer}, must be sorted in ascending order
//	 * @param args      an array of {@code String} that contains in the position 0 an integer
//	 */
//	public static void main(String[] args) throws SequenceNotSorted, IllegalArgumentException, NumberFormatException {
//
//		// potrei considerare un argomento nullo come non trovato a prescindere?
//		if (args.length == 0) {
//			throw new IllegalArgumentException("args[0] of method main of the class SearchClient cannot be empty");
//		}
//
//		// overloading con nostra exception dalla classe NumberFormatException per poter
//		// dare più informazini
//		int targetNumber = 0;
//		try {
//			targetNumber = Integer.parseInt(args[0]);
//		} catch (NumberFormatException e) {
//			throw new NumberFormatException("args[0] of method main of the class SearchClient must be a number");
//		}
//
//		List<Integer> sequence = new ArrayList<>();
//		try (Scanner s = new Scanner(System.in)) {
//			int previous = 0;
//			if (s.hasNext()) previous = Integer.parseInt(s.next());
//			sequence.add(previous);
//			while (s.hasNext()) {
//				int input = Integer.parseInt(s.next());
//				if (previous > input) {
//					throw new SequenceNotSorted();
//				}
//				sequence.add(input);
//			}
//		} //catch (RuntimeException e) {}
//
//		int[] sequenceArray = sequence.stream().mapToInt(Integer::intValue).toArray();
//
//		System.out.println(Search.searchWithLoop(sequenceArray, targetNumber));
//
//	}
//	// Il main fi questa classe legge dal flusso di ingresso una sequenza di
//	// interi (separati da spazi) e, assumendo che sia ordinata in ordine
//	// crescente, emette nel flusso d'uscita la posizione dell'intero specificato
//	// sulla linea di comando (se presente nell'input), o -1 viceversa.
//}
