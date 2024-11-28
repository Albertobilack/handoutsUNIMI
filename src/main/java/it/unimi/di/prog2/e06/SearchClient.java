/*

Copyright 2024 Massimo Santini

This file is part of "Programmazione 2 @ UniMI" teaching material.

This is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This material is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this file.  If not, see <https://www.gnu.org/licenses/>.

*/

package it.unimi.di.prog2.e06;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * Esercizio 4.2 di PDJ.
 * Considerazioni: essendo un metodo pubblico assumeremo che i contratti non vengano sempre rispettati
 * Considerazioni: non trovare il numero all'interno della sequenza non è una
 * "call con illegal arguments" di conseguenza non viene tratta come un errore
 * e gestita con le eccezioni ma ritornando un valore preciso
 */

public class SearchClient {

	/** Private constructor to prevent instantiation */
	private SearchClient() {}

	/**
	 * QUESTO È UN METODO TOTALE CHE GESTISCE SOTTOINSIEME DI INPUT NON CORRETTI CON
	 * EXCEPTION, QUINDI INVECE CHE USARE REQUIRE SI DEFINISCONO
	 * GLI EFFETTI DEGLI INPUT NON CORRETTI
	 * 
	 * Main method to test {@code searchWithLoop} and {@code searchWithWhile} methods of the class {@code Search}
	 * 
	 * if {@code args} is empty raise {@code IllegalArgumentException},
	 * else if {@code args} at index 0 does not contain a number or arguments of the sequence
	 * are not numbers, raise {@code NumberFormatException} else if the sequence given from
	 * {@code System.in} is not sorted, raise {@code SequenceNotSorted}
	 * else the method modifies {@code System.out} printing the index of the Integer
	 * contained in {@code args[0]} if it is found in the sequence
	 * given from {@code System.in}, {@code -1} otherwhise
	 * 
	 * @param System.in sequence of {@code integer}, must be sorted in ascending order
	 * @param args      an array of {@code String} that contains in the position 0 an integer
	 */
	public static void main(String[] args) throws SequenceNotSorted, IllegalArgumentException, NumberFormatException {

		// potrei considerare un argomento nullo come non trovato a prescindere?
		if (args.length == 0) {
			throw new IllegalArgumentException("args[0] of method main of the class SearchClient cannot be empty");
		}

		// overloading con nostra exception dalla classe NumberFormatException per poter
		// dare più informazini
		int targetNumber = 0;
		try {
			targetNumber = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			throw new NumberFormatException("args[0] of method main of the class SearchClient must be a number");
		}

		List<Integer> sequence = new ArrayList<>();
		try (Scanner s = new Scanner(System.in)) {
			int previous = 0;
			if (s.hasNext()) previous = Integer.parseInt(s.next());
			sequence.add(previous);
			while (s.hasNext()) {
				int input = Integer.parseInt(s.next());
				if (previous > input) {
					throw new SequenceNotSorted();
				}
				sequence.add(input);
			}
		} //catch (RuntimeException e) {}

		int[] sequenceArray = sequence.stream().mapToInt(Integer::intValue).toArray();

		System.out.println(Search.searchWithLoop(sequenceArray, targetNumber));

	}
	// Il main fi questa classe legge dal flusso di ingresso una sequenza di
	// interi (separati da spazi) e, assumendo che sia ordinata in ordine
	// crescente, emette nel flusso d'uscita la posizione dell'intero specificato
	// sulla linea di comando (se presente nell'input), o -1 viceversa.
}
