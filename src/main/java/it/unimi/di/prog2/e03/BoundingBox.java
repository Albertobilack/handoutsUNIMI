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
import java.util.Scanner;

/**
 * Vedi <a
 * href="https://github.com/mapio/labprog/blob/master/esercizi/bounding_box/Testo.md">testo</a>,
 */
public class BoundingBox {

  /** . */
  private BoundingBox() {}

  /**
   * testing
   * 
   * @param args porcatroia
  */
  public static void main(String[] args) {

    int inizio = -1;
    int fine = -1;
    int sinistra = -1;
    int destra = -1;
    int contatore = 0;


    try (Scanner s = new Scanner(System.in)) {
      while (s.hasNext()) {
        final String linea = s.nextLine();
        if (linea.contains("*")) {
          if (inizio == -1) { inizio = contatore; fine = contatore; }
          else fine = contatore;
          
          int posizione = 0;
          for (char carattere : linea.toCharArray()) {
            if (carattere == '*') { 
              if (sinistra == -1) { sinistra = posizione; destra = posizione;}
              if (posizione < sinistra) sinistra = posizione;
              if (posizione > destra) destra = posizione;
            }
            posizione++;
          }
        }
        contatore++;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println(((fine - inizio)+1) + " " + ((destra - sinistra)+1));

  }
}
