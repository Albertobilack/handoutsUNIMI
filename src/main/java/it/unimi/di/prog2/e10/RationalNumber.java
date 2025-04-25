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

package it.unimi.di.prog2.e10;

import java.util.Objects;

/**
 * A rational number is an immutable number that can be expressed as the quotient or fraction \( p/q
 * \) of two {@code int}s, a numerator \( p \) and a non-zero denominator \( q \).
 */
public class RationalNumber {
  // EXERCISE: complete following the specification (with particular attention
  // to the eventual exceptions) and provide an implementation (including the
  // equals, hashCode, and toString methods); add methods that are adequate to
  // the specification.

  private final int numerator;
  private final int denominator;


  //COSTRUTTORI

  /**
   * Creates a new rational number.
   *
   * @param numerator the numerator.
   * @param denominator the denominator.
   * @throws IllegalArgumentException if {@code denominator = 0}
   */
  public RationalNumber(int numerator, int denominator) throws IllegalArgumentException{
    if (denominator == 0) throw new IllegalArgumentException("RationalNumber.RationalNumber, a rationalNumber cannot have denominator = 0.");
    this.numerator = numerator;
    this.denominator = denominator;
  }

  //METODI INTERNI CLASSE UTILITY

  /**
   * return the greatest common denominator of two integers
   * 
   * @param x the first integer
   * @param y the second integer
   * @return the GCD of {@code x} and {@code y}
   */
  private static int GCD(int x, int y) {
    while (y != 0) {
      int temp = y;
      y = x % y;
      x = temp;
    }
    return x;
  }

  //METODI INTERNI OGGETTI

  /**
   * return the lowest common multiple of this rational number and another one
   *  
   * @param other the other rational number
   * @return the LCM of this rational number and {@code other}
   * @throws NullPointerException if {@code other} = null
   */
  private int LCM(RationalNumber other) throws NullPointerException{
    Objects.requireNonNull(other, "RationalNumber.LCM, the rationalNumber to calculate the LCM cannot be null.");
    int greater = denominator > other.denominator ? denominator : other.denominator;
    while(true) {
      if ((greater % denominator == 0) && (greater % other.denominator ==0 )) return greater;
      greater++;
    }
  }


  /**
   * Return the simpler form of the given RationalNumber.
   * 
   * @return a new RationalNumber where the fratcion is in lowest terms.
   */
  //poteva essere un costruttore alternativamente ? 
  private RationalNumber simpleForm() {
    int gcd = GCD(numerator, denominator);
    return new RationalNumber(numerator / gcd, denominator / gcd);
  }

  /**
   * Returns the sum of this rational number and another one.
   *
   * @param other the other rational number.
   * @return the sum of this rational number and {@code other}.
   * @throws NullPointerException if {@code other} is = null
   */
  public RationalNumber add(RationalNumber other) throws NullPointerException{
    Objects.requireNonNull(other, "RationalNumber.add, the rationalnumber to add cannot be null.");
    int lcm = LCM(other);
    int multiOne = lcm / denominator;
    int multTwo = lcm / other.denominator;
    int numOne = (this.numerator * multiOne) + (other.numerator * multTwo);
    int numTwo = lcm;
    return (new RationalNumber(numOne, numTwo)).simpleForm();
  }

  /**
   * Returns the product of this rational number and another one.
   *
   * @param other the other rational number.
   * @return the product of this rational number and {@code other}.
   * @throws NullPointerException if {@code other} is = null
   */
  public RationalNumber mul(RationalNumber other) throws NullPointerException{
    Objects.requireNonNull(other, "RationalNumber.mul, the rationalnumber to mul cannot be null.");
    int newNum = numerator * other.numerator;
    int newDen = denominator * other.denominator;
    //non ha molto senso come implementazione ma ok
    return (new RationalNumber(newNum, newDen)).simpleForm();
  }

  @Override
  public int hashCode() {
    return Objects.hash(numerator, denominator);
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof RationalNumber z)) return false;
    RationalNumber x = z.simpleForm();
    RationalNumber y = this.simpleForm(); 
    if ((y.denominator != x.denominator) || (y.numerator != x.numerator)) return false;
    return true;
  }

  @Override
  public String toString() {
    return "RationalNumber: " + numerator + " / " + denominator;
  }

}
