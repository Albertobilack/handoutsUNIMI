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

package it.unimi.di.prog2.e04;
import java.util.Scanner;

/**
 * Vedi <a
 * href="https://github.com/mapio/labprog/blob/master/esercizi/saltapicchio/Testo.md">testo</a>, ma
 * senza il vincolo sul valore massimo per `N`.
 */
public class Saltapicchio {

  /** . */
  private Saltapicchio() {}


  //scritto da ChatGPT non avevo voglia  
  public static void sort(int[] array, int inizio, int fine) {
    if (inizio < fine) {
        int pivotIndex = partiziona(array, inizio, fine);
        sort(array, inizio, pivotIndex - 1); // Ordina la parte sinistra
        sort(array, pivotIndex + 1, fine);  // Ordina la parte destra
    }
}

// Metodo per partizionare l'array
private static int partiziona(int[] array, int inizio, int fine) {
    int pivot = array[fine];
    int i = inizio - 1;

    for (int j = inizio; j < fine; j++) {
        if (array[j] <= pivot) {
            i++;
            // Scambia array[i] con array[j]
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    // Scambia il pivot con l'elemento successivo a i
    int temp = array[i + 1];
    array[i + 1] = array[fine];
    array[fine] = temp;

    return i + 1;
}

  //decisamente si poteva rendere più semplice
  public static void main(String[] args) {
    
    int lenghtOfSequence = Integer.parseInt(args[0]); //numero di input
    int[] sequenceValues = new int[lenghtOfSequence-1]; //numero di valori assoluti

    try (Scanner s = new Scanner(System.in)) {
      int previous = Integer.parseInt(s.next());
      for (int i=0; i < lenghtOfSequence-1 && s.hasNext(); i++) {
        int next = Integer.parseInt(s.next().trim());
        sequenceValues[i] = Math.abs(next - previous);
        previous = next;
      }
    }

    sort(sequenceValues, 0, lenghtOfSequence-2);

    boolean saltapicchio = true;
    for (int i = 1; i<lenghtOfSequence-1; i++) {
      if (i != sequenceValues[i-1]) {
        saltapicchio = false;
      }
    }

    if (saltapicchio) {
      System.out.println("saltapicchio");
    }

  }
}
