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

//specify and implement a procedure isPrime that determines whether an integer is prime

package it.unimi.di.prog2.e05;

/** Esercizio 3.3 di PDJ. */
public class IsPrimeClient {

  /**
   * Private constructor to prevent instantiation
   */
  private IsPrimeClient() {}


  /**
   * Main method to test the {@code isPrime} method
   * 
   * @param args an array of {@code String} containing the numbers that must be checked
   */
  public static void main(String[] args) {
    
    int length = args.length;
    for (int i=0; i<length; i++) {
      if (isPrime(Integer.parseInt(args[i]))) {
        System.out.println("true");
      }
    }
  }

  /**
   * The method return true if the argument is a prime number
   *  
   * @param input number that must be checked
   * @return {@code true} if the input is a prime number, {@code false} otherwise 
  */
  private static boolean isPrime(int input) {
    
    if (input <= 1) return false;
    if (input == 3 || input ==2) {
      return true;
    } else if (input % 2 == 0) {
      return false;
    }

    double square = Math.sqrt((double) input);

    for (int i=3; i<=square; i+=2) {
      if (input % i == 0) {
        return false;
      } 
    }

    return true;
  }


}
