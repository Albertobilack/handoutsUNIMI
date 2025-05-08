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

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

/**
 * A class to handle a list of rectangles and organize them as in histogram.
 *
 * <p>The rectangles are organized in decreasing height order, more specifically the iterator
 * returns the rectangles in this order.
 * 
 * HISTOGRAM IS MUTABLE
 */
public class Histogram implements Iterable<Rectangle> {

  /*-
    Decide what fields to use to represent a rectangle and
    provide the AF and IR.

    Check the specification, possibly adding missing exceptions.

    Finish the implementation of the class.
  */

  /** the list containing the Rectangle of this Histogram in decreasing height order */
  private List<Rectangle> container;

  //AF: AF(container) = l'istogramma è dato dai rettangoli presenti nel container, ordinati
  // in ordine decrescente 
  //
  // IR: container not null && ogni elemento di container not null &&
  // if i>J then container[i].height >= container[j].height


  /** Creates an empty histogram. */
  public Histogram() {
    container = new ArrayList<>();
    assert repOk();
  }

  /**
   * Adds a {@link Rectangle} to this histogram.
   *
   * @param rectangle the rectangle to add.
   * @throws NullPointerException is {@code rectangle} is null
   */
  public void add(Rectangle rectangle) throws NullPointerException {
    Objects.requireNonNull(rectangle);
    int index = 0;
    for (Rectangle s : container) {
      if (rectangle.height() <= s.height()) index++;
      else break;
    }
    container.add(index, rectangle);
    assert repOk();
  }

  /**
   * Changes the base of the given rectangle
   *
   * @param rectangle the rectangle.
   * @param newBase the new base.
   * @throws NoSuchElementException if the rectangle is not in the histogram.
   * @throws NullPointerException is {@code rectangle} is null
   * @throws IllegalArgumentException if {@code newBase} &lt;= 0 //probabilmente non necessario
   */
  public void changeBase(Rectangle rectangle, int newBase) throws IllegalArgumentException, NullPointerException, IllegalArgumentException {
    if (newBase <= 0) throw new IllegalArgumentException("Histogram.changeBase, illegal value of newbase: " + newBase);
    Objects.requireNonNull(rectangle);
    int index = container.indexOf(rectangle);
    if (index < 0) throw new NoSuchElementException("Histogram.changeBase, illegal value for rectangle parameter: " + rectangle.toString());
    container.get(index).base(newBase);
    assert repOk();
  }

  /**
   * Returns an iterator that produces the rectangles in this histogram in decreasing height order.
   *
   * @return the iterator over the rectangles in this histogram.
   */
  @Override
  public Iterator<Rectangle> iterator() {
    return new rectGenDescening();
  } 

  /** . */
  private class rectGenDescening implements Iterator<Rectangle> {

    /** . */
    private rectGenDescening() {};

    /** . */
    private int position = 0;

    @Override
    public boolean hasNext() {
      return position < container.size();
    }

    @Override
    public Rectangle next() {
      int temp = position;
      position++;
      return new Rectangle(container.get(temp).base(), container.get(temp).height()); //defensive copy
    }

  } 

  /**
   * An implementation of the RI.
   *
   * @return whether the RI is satisfied.
   */
  private boolean repOk() {
    if (container == null) return false;
    if (container.isEmpty()) return true;
    Rectangle prev = container.get(0);
    for (Rectangle rec : container.subList(1, container.size())) {
      if (rec == null) return false;
      if (prev.height() < rec.height()) return false;
      prev = rec;
    }
    return true;
  }
}
