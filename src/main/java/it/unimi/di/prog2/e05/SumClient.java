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

//Specify and implement a method with the header "public static int sum (int[] a) that returns the sum of the elements of a"

package it.unimi.di.prog2.e05;

/** Esercizio 3.2 di PDJ. */
public class SumClient {

  /** . */
  private SumClient() {}


  /**
   * Main method of the class used to test SumClient method
   * 
   * REQUIRE: elements of {@code args} to be numbers
   * 
   * @param args contains the addends used to compute the sum, the addends must be numbers
   */
  public static void main(String[] args) {
    
    int length = args.length;
    int[] addends = new int[length];
    for (int i=0; i<length; i++) {
      addends[i] = Integer.parseInt(args[i]);
    }

    System.out.println(sum(addends));

  }


  /**
   * Compute the sum of the elements of a given array of integer.
   * 
   * @param a an {@code int[]} containing the {@code int} values to be summed.
   * @return the integer value representing the sum of {@code a}.
   */
  public static int sum (int[] a) {
    int sum = 0;
    for (int value : a) {
      sum +=value;
    }
    return sum;
  }

}
