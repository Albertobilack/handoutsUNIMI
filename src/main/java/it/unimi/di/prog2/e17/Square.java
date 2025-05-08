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

/** A mutable class representing a square with integer valued base. */
public class Square extends Rectangle {

  /*-
    Decide, if needed, what fields to use to represent a
    square and provide the AF and IR.

    Check the specification, possibly adding missing exceptions.

    Finish the implementation of the class.
  */

  // AF() = AF(Rectangle)
  // IR of the superclass && this.base == this.height

  /**
   * Creates a rectangle of given base and height.
   *
   * @param base the base of the rectangle.
   */
  public Square(final int base) {
    super(base, base);
  }


  @Override
  public void base(int base) {
    if (base <= 0) throw new IllegalArgumentException("Rectangle.base, param base value: " + Integer.toString(base));
    super.base(base);
    super.height(base);
    //posso accedere alla rep o devo usare i metodi? è priv quindi devo usare i metodi
    assert repOk();
  }


  @Override
  public void height(int height) {
    //base(height);
    if (height <= 0) throw new IllegalArgumentException("Rectangle.height, param height value: "+ Integer.toString(height));
    super.height(height);
    super.base(height);
    assert repOk();
  }

  /**
   * An implementation of the RI.
   *
   * @return whether the RI is satisfied.
   */
  private boolean repOk() {
    if (super.base() <= 0 || super.height() <=0) return false;
    if (super.base() != super.height()) return false;
    return true;
  }

  

}
