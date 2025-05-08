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

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

/**
 * A <em>queue</em> is a mutable data structure that provides access to its elements in
 * first-in/first-out order.
 *
 * <p>A <em>bounded</em> queue has an upper bound, established when a queue is created, on the
 * number of elements that can be stored in the queue.
 */
public class BoundedIntQueue{

  // EXERCISE: complete following the specification (with particular attention
  // to the eventual exceptions) and provide an implementation (including the
  // equals, hashCode, and toString methods); add methods that are adequate to
  // the specification.

  // Given the boundedness constraint, it is not allowed to use any Java
  // Collection Framework class. An array can be used to store the elements in a
  // circular buffer (see https://www.wikiwand.com/en/articles/Circular_buffer).

  /**index of the first element of the queue in the array */
  private int read;
  /**index of the last element of the queue in the array */
  private int write;
  /**the elements in the queue */
  private int[] queue;
  /** {@code (maxLength-1)} is the max number of elements the queue can have*/
  private int maxLength;

  /**
   * Creates a new bounded queue with the given capacity.
   * 
   * <p> new elements of the Queue cannot override older elements, when there is no avaible capacity
   * in the queue, in order to add a new element some space must be liberated deleting old elements from the queue
   * 
   * @param capacity the capacity of the queue.
   * @throws IllegalArgumentException if {@code capacity} is negative.
   */
  public BoundedIntQueue(int capacity) {
    if (capacity <0) throw new IllegalArgumentException("BoundedIntQueue.BoundedIntQueue, BoundedIntQueue cannot have negative capacity");
    read = 0;
    write = 0;
    queue = new int[capacity + 1]; //one empty space at all time to determine full easily
    maxLength = capacity + 1;
  }

  /**
   * Clone a queue. 
   * 
   * @param other the {@code BoundedIntQueue} to be cloned
   * @return a copy of {@code other}
   * @throws NullPointerException is {@code other} is null
   */
  public static BoundedIntQueue clone(BoundedIntQueue other) throws NullPointerException {
    BoundedIntQueue x = new BoundedIntQueue(other.maxLength-1);
    x.queue = Arrays.copyOf(other.queue, other.maxLength); //bad practice
    x.write = other.write;
    x.read = other.read;
    return x;
  }

  /**
   * Adds an element to the queue.
   *
   * @param x the element to add.
   * @throws IllegalStateException if the queue is full.BoundedIntQueue
   */
  public void enqueue(int x) throws IllegalStateException {
    if (fullQueue()) throw new IllegalStateException("BoundedIntQueue.enqueue, cannot add new elements to a full queue");
    queue[write] = x;
    write = (write + 1) % maxLength;
  }

  /**
   * Removes the element at the head of the queue.
   *
   * @return the element at the head of the queue.
   * @throws IllegalStateException if the queue is empty.
   */
  public int dequeue() throws IllegalStateException {
    if (emptyQueue()) throw new IllegalStateException("BoundedIntQueue.dequeue, cannot remove elements from a empty queue");
    int temp = queue[read];
    read = (read + 1) % maxLength;
    return temp;
  }

  /**
   * specify if the queue is full
   * 
   * @return {@code true} if the queue is full, {@code false} if there is at least one avaible space in the queue
   */
  public boolean fullQueue() {
    return (write + 1) % maxLength == read;
  }

  /**
   * specify if the queue is empty
   * 
   * @return {@code true} if the queue is empty, {@code false} if there is at least one element in the queue 
   */
  public boolean emptyQueue() {
    return write == read;
  }

  /**
   * returnt the max size of the queue
   * 
   * @return the max number of elements the queue can store
   */
  public int totalSizeQueue() {
    return maxLength-1;
  }

  /**
   * the number of elements in the queue.
   * 
   * @return the number of elements.
   */
  public int sizeQueue() {
    return  (write - read + maxLength) % maxLength;
  }



  //avrei potuto copiare contenuto coda in un array 
  @Override
  public int hashCode() {
    int result = Integer.hashCode(maxLength);
    int size = sizeQueue();
    for (int i=0; i<size; i++) { 
      int index = (read + i) % maxLength;
      result = 31 * result + Integer.hashCode(queue[index]);
    }
    return result;
  }

  //distruttivo ops, non ho voglia di fixare
  @Override //io non avrei rappresentato queue in questo modo, ma restituendo gli elementi in queue + posti ancora liberi
  public String toString() {
    StringBuilder x = new StringBuilder("BoundedIntQueue: [");
    while (!emptyQueue()) {
      x.append(Integer.toString(dequeue()) + ", ");
    }
    if (x.length() > 18) {
        x.deleteCharAt(x.length()-1);
        x.deleteCharAt(x.length()-1);
    }
    x.append("]");
    return x.toString();
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (!(other instanceof BoundedIntQueue x)) return false;
    if (x.maxLength != maxLength) return false;
    int size = sizeQueue();
    if (size != x.sizeQueue()) return false;
    for (int i=0; i<size; i++) {
      if (queue[(read+i) % maxLength] != x.queue[(x.read+i) % maxLength]) return false;
    }
    return true;
  }



}
