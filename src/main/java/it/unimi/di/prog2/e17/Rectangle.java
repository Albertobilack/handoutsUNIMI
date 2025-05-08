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

package it.unimi.di.prog2.e17;

import java.util.Objects;

/** A mutable class representing a rectangle with integer valued base and height. */
public class Rectangle {

  /** the base of the rectangle */
  private int base;
  /** the height of the rectangle */
  private int height;

  //AF: AF(base, height) = a rectangle with base of lenght this.base and height of lenght this.height
  //
  //IR: base > 0 && height > 0
  /*-
    Decide what fields to use to represent the rectangle and
    provide the AF and IR.

    Check the specification, possibly adding missing exceptions.

    Finish the implementation of the class.
  */

  /**
   * Creates a rectangle of given base and height.
   *
   * @param base the base of the rectangle.
   * @param height height of the rectangle.
   * @throws IllegalArgumentException if {@code base} &lt;= or {@code height} &lt;=0 
   */
  public Rectangle(int base, int height) throws IllegalArgumentException {
    if (base <= 0) throw new IllegalArgumentException("Rectangle.Rectangle, param base value: " + Integer.toString(base));
    if (height <= 0) throw new IllegalArgumentException("Rectangle.Rectangle, param height value: "+ Integer.toString(height));
    this.base = base;
    this.height = height;
    assert repOk();
  }

  /**
   * Returns the base of the rectangle.
   *
   * @return the base of the rectangle.
   */
  public int base() {
    return base;
  }

  /**
   * Sets the base of the rectangle.
   *
   * @param base the new base of the rectangle.
   * @throws IllegalArgumentException if {@code base} &lt;= 0 
   */
  public void base(int base) {
    if (base <= 0) throw new IllegalArgumentException("Rectangle.base, param base value: " + Integer.toString(base));
    this.base = base;
    assert repOk();
  }

  /**
   * Returns the height of the rectangle.
   *
   * @return the height of the rectangle.
   */
  public int height() {
    return height;
  }

  /**
   * Sets the height of the rectangle.
   *
   * @param height the new height of the rectangle.
   * @throws IllegalArgumentException if {@code height} &lt;= 0 
   */
  public void height(int height) throws IllegalArgumentException{
    if (height <= 0) throw new IllegalArgumentException("Rectangle.height, param height value: "+ Integer.toString(height));
    this.height = height;
    assert repOk(); 
  }

  @Override
  public String toString() {
    return "Rectangle with base: " + Integer.toString(base) + " height: " + Integer.toString(height);
  }

  @Override
  public boolean equals(Object other) {
    Objects.requireNonNull(other);
    if (other == this) return true;
    if (!(other instanceof Rectangle x)) return false;
    if (this.height != x.height || this.base != x.base) return false;
    return true;
  }

  @Override
  public int hashCode() {
    throw new UnsupportedOperationException();
  }

  /**
   * An implementation of the RI.
   *
   * @return whether the RI is satisfied.
   */
  private boolean repOk() {
    if (base <= 0 || height <=0) return false;
    return true;
  }

}
