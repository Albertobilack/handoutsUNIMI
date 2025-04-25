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

package it.unimi.di.prog2.e12;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.List;

/**
 * A map from {@link String} to {@link Integer}.
 *
 * <p>
 * A <em>map</em> is a collection that associates keys to values. In this case,
 * the keys are
 * strings and the values are integers. The map cannot contain duplicate keys,
 * which means that each
 * key can be associated to at most one value.
 */
public class StringToIntMap {

  private List<Term> map;

  public record Term(String key, int value) {

    // AF(key, value) = key -> value
    //
    // IR = key must not be null, key and value must be pairs (se ho chiave ho
    // valore)

    /**
     * build a term
     * 
     * @param key   the key
     * @param value the value
     * @throws NullPointerException if {@code key} is null
     */
    public Term {
      Objects.requireNonNull(key);
    }
  }

  // EXERCISE: provide a representation, together with its AF and RI
  // Note: do not use the Map in Java Collections, the point is to implement it
  // from scratch!

  //
  // AF: AF(map) = {Term(key, value), Term(key, value), Term(key, value)}
  //
  // IR: Term cannot have duplicates values in map.key && map != null && map must
  // not contain null values
  //

  /** Creates a new empty map. */
  public StringToIntMap() {
    map = new ArrayList<Term>();
  }

  /**
   * Returns the size of this map.
   *
   * @return the number of key-value mappings in this map.
   */
  public int size() {
    return map.size();
  }

  /**
   * Returns if this map is empty.
   *
   * @return {@code true} iff this map contains no key-value mappings.
   */
  public boolean isEmpty() {
    return map.isEmpty();
  }

  /**
   * Returns if this map contains the specified key.
   *
   * @param key the key to search for.
   * @return {@code true} iff this map contains a key-value mappings with the
   *         given {@code key}.
   */
  public boolean containsKey(String key) {
    for (Term t : map) {
      if (t.key().equals(key))
        return true;
    }
    return false;
  }

  /**
   * Returns if this map contains the specified value.
   *
   * @param value the value to search for.
   * @return {@code true} iff this map contains a key-value mappings with the
   *         given {@code value}.
   */
  public boolean containsValue(int value) {
    for (Term t : map) {
      if (t.value() == value)
        return true;
    }
    return false;
  }

  /**
   * Returns the value to which the specified key is mapped.
   *
   * @param key the key whose associated value is to be returned.
   * @return the value to which the specified key is mapped.
   * @throws NoSuchElementException if this map contains no mapping for the key.
   */
  public int get(String key) throws NoSuchElementException {
    for (Term t : map) {
      if (t.key().equals(key))
        return t.value(); // final & integer
    }
    throw new NoSuchElementException("StringToIntMap.get, key not found");
  }

  /**
   * Associates the specified value with the specified key in this map.
   *
   * @param key   the key with which the specified value is to be associated.
   * @param value the value to be associated with the specified key.
   * @return {@code true} iff this map did not already contain a mapping for the
   *         key, and hence is
   *         modified by this operation.
   */
  public boolean put(String key, int value) {
    for (Term t : map) {
      if (t.key().equals(key)) {
        map.remove(t);
        map.add(new Term(key, value));
        return false;
      }
    }
    map.add(new Term(key, value));
    return true;
  }

  /**
   * Removes the mapping for a key from this map if it is present.
   *
   * @param key the key whose mapping is to be removed from the map.
   * @return {@code true} iff this map contained a mapping for the specified key,
   *         and hence is
   *         modified by this operation.
   */
  public boolean remove(String key) {
    for (Term t : map) {
      if (t.key().equals(key)) {
        map.remove(t); // temo crei errore
        return true;
      }
    }
    return false;
  }

  /** Removes all of the mappings from this map. */
  public void clear() {
    map.clear();
  }

  @Override
  public boolean equals(Object other) {
    Objects.requireNonNull(other);
    if (this == other)
      return true;
    if (!(other instanceof StringToIntMap x))
      return false;
    if (this.size() != x.size()) // più corretto checckare size con mio metodo o metodo di List?
      return false;
    for (int i = 0; i < map.size(); i++) {
      Term t = map.get(i);
      int checkValue;
      try {
        checkValue = x.get(t.key());
      } catch (NoSuchElementException e) {
        return false;
      }
      if (checkValue != t.value())
        return false;
    }
    return true;
  }

  @Override
  public String toString() {
    // {key: value, key: value, key:value}
    StringBuilder x = new StringBuilder("StringToIntMap: {");
    for (int i = 0; i < size(); i++) {
      Term temp = map.get(i);
      x.append(temp.key + ": " + Integer.toString(temp.value) + ", ");
    }
    if (size() > 0)
      x.delete(x.length() - 3, x.length() - 1);
    x.append("}");
    return x.toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(map);
  }
}
