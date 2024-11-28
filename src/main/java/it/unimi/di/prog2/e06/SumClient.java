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


/** Esercizio 4.3 di PDJ. 
 * Class used to test {@code sum} method of class {@code Sum}
*/
public class SumClient {

  /** Private constructor to prevent instantiation */
  private SumClient() {}

  /**
   * The method read from {@code system.in} a sequence of numbers and print the sum of them on {@code system.out}
   * The length of sequence must be > 0, otherwise {@code IllegalArgumentException} will be raised
   * if reading from input fails the method will raise an {@code IllegalStateException}, if input from {@code system.in} is
   * not an integer, the method will rise {@code NumberFormatException}, if reading from {@code system.in} fails
   * 
   * nb: no require, no modifies
   * 
   * @param args not used
   */
  public static void main(String[] args) throws InvalidInputFormat, ReadingFromInputError, IllegalArgumentException {

    List<Integer> sequence = new ArrayList<>();
    
    try (Scanner s = new Scanner(System.in)) {
      while (s.hasNext()) {
        try {sequence.add(Integer.parseInt(s.next())); }
        catch (NumberFormatException e) { throw (new InvalidInputFormat("input must be an integer, error at method main class SumClient")); } 
      }
    } catch (IllegalStateException e) { throw (new ReadingFromInputError("error reading from system.in method main class SumClient"));}
  
    int[] sequenceArray = sequence.stream().mapToInt(Integer::intValue).toArray();
    int sum = 0; 

    try {
      sum = Sum.sumOfArray(sequenceArray);
    } catch (IllegalArgumentException e) {throw (new IllegalArgumentException("must be provided at least one input from system.in, method main class SumClient"));}

    System.out.println(sum);

  }
  // Il main di questa classe legge dal flusso di ingresso una sequenza di al
  // più 100 interi e ne emette la somma nel flusso d'uscita.

}
