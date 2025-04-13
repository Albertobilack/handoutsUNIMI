package it.unimi.di.prog2.e06;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

/**
 * esercizio 4.3 PDJ
 * classe per testare Sum.java
 * a specification for a precedure that computes the sum of the elements in an array of
 * integers might require a nonempty array, return 0 if the array is empty, or throw an exception
 * if the array is empty. Discuss which alternative is best and provide the specification for the procedure 
 * 
 * ragionamento: 0 può essere un risultato valido di una somma, quindi non può essere caso di array vuoto
 * le altre due soluzioni sono entrambi valide, ma chiedere nonempty array crea un metodo parziale inutilmente
 * perché ci costa poco controllare la size all'interno del metodo per verificare la dimensione. 
 */
public class SumClient {

  /** placeholder */
  private SumClient() {}

  /**
   * compute the sum of a sequence of integers
   * 
   * <p> read from input stream (flusso di ingresso) a sequence of {@code integer}
   * and return the sum of the sequence
   * 
   * @param args not used
   * @throws IllegalArgumentException if input stream contains an argument != {@code int} or no input is provided from input stream 
   * @throws FailedReading if reading from stream fails or if given input does not match the Integer regular expression 
   */
  public static void main(String[] args) throws FailedReading, IllegalArgumentException {

    List<Integer> sequenceString = new ArrayList<>();
    try(Scanner s = new Scanner(System.in)) {
      while(s.hasNext()) {
        sequenceString.add(s.nextInt());
      }
    } catch(Exception e) { //exception e è sbagliato. troppo generale
      throw new FailedReading("errore lettura input SumClient.main");
    } 

    try { 
      System.out.println(Sum.ListInteger(sequenceString));
    } catch (Exception e) { //exception e è sbagliato. troppo generale
      throw new IllegalArgumentException("SumClient.main");
    }

  }

}


//RIFATTO

//package it.unimi.di.prog2.e06;
//import java.util.Scanner;
//import java.util.List;
//import java.util.ArrayList;
//
//
///** Esercizio 4.3 di PDJ. 
// * Class used to test {@code sum} method of class {@code Sum}
//*/
//public class SumClient {
//
//  /** Private constructor to prevent instantiation */
//  private SumClient() {}
//
//  /**
//   * The method read from {@code system.in} a sequence of numbers and print the sum of them on {@code system.out}
//   * The length of sequence must be > 0, otherwise {@code IllegalArgumentException} will be raised
//   * if reading from input fails the method will raise an {@code IllegalStateException}, if input from {@code system.in} is
//   * not an integer, the method will rise {@code NumberFormatException}, if reading from {@code system.in} fails
//   * 
//   * nb: no require, no modifies
//   * 
//   * @param args not used
//   */
//  public static void main(String[] args) throws InvalidInputFormat, ReadingFromInputError, IllegalArgumentException {
//
//    List<Integer> sequence = new ArrayList<>();
//    
//    try (Scanner s = new Scanner(System.in)) {
//      while (s.hasNext()) {
//        try {sequence.add(Integer.parseInt(s.next())); }
//        catch (NumberFormatException e) { throw (new InvalidInputFormat("input must be an integer, error at method main class SumClient")); } 
//      }
//    } catch (IllegalStateException e) { throw (new ReadingFromInputError("error reading from system.in method main class SumClient"));}
//  
//    int[] sequenceArray = sequence.stream().mapToInt(Integer::intValue).toArray();
//    int sum = 0; 
//
//    try {
//      sum = Sum.sumOfArray(sequenceArray);
//    } catch (IllegalArgumentException e) {throw (new IllegalArgumentException("must be provided at least one input from system.in, method main class SumClient"));}
//
//    System.out.println(sum);
//
//  }
//  // Il main di questa classe legge dal flusso di ingresso una sequenza di al
//  // più 100 interi e ne emette la somma nel flusso d'uscita.
//
//}
//