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

package it.unimi.di.prog2.e03;

import java.lang.String;
import java.util.Scanner;

/**
 * Vedi <a
 * href="https://github.com/mapio/labprog/blob/master/esercizi/lettera_piu_frequente/Testo.md">testo</a>,
 */
public class LetteraPiùFrequente {

  /** . */
  private LetteraPiùFrequente() {}

  /**
   * 
   * @param args
   */
  public static void main(String[] args) {
    
    int[] valoriLettere = new int[26];
    int valoreMaxLettera = 0;
    try (Scanner s = new Scanner(System.in)) {
      while (s.hasNext()) {
        final String frase = s.nextLine();
        for (String parola : frase.split(" ")) {
          for (char c : parola.toCharArray()) {
            final int posizione = c - 'a';
            valoriLettere[posizione]++;
            if (valoriLettere[posizione] > valoreMaxLettera) valoreMaxLettera = valoriLettere[posizione];
          }
        }
      }
    }

    System.out.println(valoreMaxLettera);

  }
}
