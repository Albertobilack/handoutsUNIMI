package it.unimi.di.prog2.e05;
import java.util.List;
import java.util.ArrayList;

/** Specify and implement a method with the header "public static int sum (int[] a) that returns the sum of the elements of a"
 * Esercizio 3.2 Liskov
 */
public class SumClient {

  /** costruttore vuoto perché classe utility */
  private SumClient() {}

  /**
   * restituisce la somma di più addendi
   * 
   * <p> riceve da standard linea di comando una sequenza di {@code int} e ne 
   * restitusice la somma   
   * 
   * @param args contiene gli elementi da sommare
   * @throws IllegalArgumentException se 
   */
  public static void main(String[] args) throws IllegalArgumentException {
    
    List<Integer> numbers = new ArrayList<>();
    for (String s : args) {
      try { numbers.add(Integer.parseInt(s)); }
      catch (NumberFormatException e) {throw new IllegalArgumentException(e); }
    }

    System.out.println(Sum.SumNumbers(numbers));
    

  }

}





/** Esercizio 3.2 di PDJ. */
//public class SumClient {
//
//  /** . */
//  private SumClient() {}
//
//
//  /**
//   * Main method of the class used to test SumClient method
//   * 
//   * REQUIRE: elements of {@code args} to be numbers
//   * 
//   * @param args contains the addends used to compute the sum, the addends must be numbers
//   */
//  public static void main(String[] args) {
//    
//    int length = args.length;
//    int[] addends = new int[length];
//    for (int i=0; i<length; i++) {
//      addends[i] = Integer.parseInt(args[i]);
//    }
//
//    System.out.println(sum(addends));
//
//  }
//
//
//  /**
//   * Compute the sum of the elements of a given array of integer.
//   * 
//   * @param a an {@code int[]} containing the {@code int} values to be summed.
//   * @return the integer value representing the sum of {@code a}.
//   */
//  public static int sum (int[] a) {
//    int sum = 0;
//    for (int value : a) {
//      sum +=value;
//    }
//    return sum;
//  }
//
//}
//