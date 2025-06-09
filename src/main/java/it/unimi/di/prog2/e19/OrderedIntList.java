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

package it.unimi.di.prog2.e19;

import java.util.Iterator;
import java.util.NoSuchElementException;

import it.unimi.di.prog2.h08.impl.EmptyException;

/**
 * Ordered list of integers without duplicates. See PDF 6.6 public class OrderedIntList {
 *
 * <p>// Specify and implement (writing the AF and RI) the // ordered list of integers without
 * duplicates described // in paragraph 6 of chapter 6 of the PDJ textbook.
 *
 * <p>}
 * 
 * overview: An ordered list is a mutable ordered list of integers.
 * A typical list is a sequence [x1, ..., xn] where xi < xj if i < j.
 * mutable object
 */
public class OrderedIntList implements Iterable<Integer> {

    /** . */
    private OrderedIntList left;
        /** . */
    private OrderedIntList right;

    /**
     * add the element to the list
     * 
     * <p> modifies this
     * @param x the integer to add
     * @throws IllegalArgumentException if {@code toAdd} is already in the list
     */
    public void addEl (int toAdd) throws IllegalArgumentException {}

    /**
     * remove the element from the list
     * 
     * <p> modifies this
     * @param x the integer to remove
     * @throws IllegalArgumentException if {@code toRemove} is not in the list
     */
    public void remEl (int toRemove) throws IllegalArgumentException {}

    /**
     * check if the integer is in the list
     * 
     * @param find the element
     * @return true if {@code find} is in the list, false otherwise
     */
    public boolean isIn (int find) {return true;}

    /**
     * check if the list is empty
     * 
     * <p> that is if the list has more than 0 elements
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty () {return true;}

    /**
     * return the smallest element in the list
     * 
     * @return the smaller element
     * @throws EmptyException if the list is empty
     */
    public int least() throws EmptyException {return 0;}

    /**
     * return a generator that produces the elements of this from the smallest
     * to the bigger
     * 
     * @return the generator
     */
    public Iterator<Integer> smallToBig() {return null;}

    /**
     * return a geenrator that produces the elements of this from the bigger
     * to the smallest
     * 
     * @return the generator
     */
    public Iterator<Integer> bigToSmall() {return null;}

    public Iterator<Integer> iterator() {
        return null;
    }

    public boolean repOk() {return true;}

    @Override
    public String toString() {return "";}

    @Override
    public boolean equals(Object other) {return true;} 

    @Override
    public int hashCode() {
        return 1;
    }
}