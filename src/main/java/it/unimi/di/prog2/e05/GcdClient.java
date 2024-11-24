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

package it.unimi.di.prog2.e05;
import java.util.Scanner;

/** Esercizio 3.1 di PDJ. */
public class GcdClient {

  /** . */
  private GcdClient() {}

  /**
   * Metodo principale
   * 
   * @param args non utilizzato
   */
  public static void main(String[] args) {
    
    try (Scanner s = new Scanner(System.in)) {
      while (s.hasNextLine()) {
        String[] input = s.nextLine().split(" ");
        System.out.println(gdc(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
      }
    }

  }

  /**
   * Method that calculate the greatest common divisor of two factors 
   * 
   * REQUIRE: None I think, should work with negative numbers and a=b, maybe could restrain a>b but idk
   * se impongo a>b creo una procedura parziale, ma così è più specifica la procedura e meno generale, e rischio di fare (minuscola) computazione inutile
   * EFFECTS: returns the GCD of two integers
   * 
   * @param factorOne self-explanatory
   * @param factorTwo self-explanatory
   * @return the GCD of the given factors
   */
  private static int gdc(int factorOne, int factorTwo) {
    
    if (factorOne < factorTwo) { 
      int temp = factorOne;
      factorOne = factorTwo;
      factorTwo = temp;
    }

    if (factorOne < 0) factorOne = Math.abs(factorOne);
    if (factorTwo < 0) factorTwo = Math.abs(factorTwo);

    if (factorTwo == 0) {
      return factorOne;
    }
    
    return gdc(factorOne % factorTwo, factorTwo);

  }

}
