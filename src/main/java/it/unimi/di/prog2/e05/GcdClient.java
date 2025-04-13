package it.unimi.di.prog2.e05;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.util.List;

/** Esercizio 3.1 di PDJ.
 * computing the greatest commond divisor by repeated subtraction is not very efficient.
 * reimplement gcd to use division instead
 */
public class GcdClient{

  /** costruttore privato perché classe utility*/
  private GcdClient() {}

  /**
   * calcola il massimo comune divisore (gcd = greatest common divisor).
   * 
   * <p> legge una sequenza di coppie di {@code int} dal flusso in ingresso {@code System.in} e per ogni coppia emette il gcd in flusso d'uscita {@code System.out}
   *
   * @param args non usato.
   * @throws IOException se lettura flusso ingresso fallisce o input contiene numero dispari di argomenti
   */
  public static void main(String[] args) throws IOException {
    
    List<Integer> a = new ArrayList<>();
    List<Integer> b = new ArrayList<>();
    try(Scanner s = new Scanner(System.in)) {
      while (s.hasNextInt()) {
        a.add(s.nextInt());
        b.add(s.nextInt());
      }
    } catch (Exception e) {
      throw new IOException(e);
    }

    for(int i=0; i<a.size(); i++) {
      System.out.println(Gcd.generateGdc(a.get(i), b.get(i)));
    }

  }



}




//public class GcdClient {
//
//  /** . */
//  private GcdClient() {}
//
//  /**
//   * Metodo principale
//   * 
//   * @param args non utilizzato
//   */
//  public static void main(String[] args) {
//    
//    try (Scanner s = new Scanner(System.in)) {
//      while (s.hasNextLine()) {
//        String[] input = s.nextLine().split(" ");
//        System.out.println(gdc(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
//      }
//    }
//
//  }
//
//  /**
//   * Method that calculate the greatest common divisor of two factors 
//   * 
//   * REQUIRE: None I think, should work with negative numbers and a=b, maybe could restrain a>b but idk
//   * se impongo a>b creo una procedura parziale, ma così è più specifica la procedura e meno generale, e rischio di fare (minuscola) computazione inutile
//   * EFFECTS: returns the GCD of two integers
//   * 
//   * @param factorOne self-explanatory
//   * @param factorTwo self-explanatory
//   * @return the GCD of the given factors
//   */
//  private static int gdc(int factorOne, int factorTwo) {
//    
//    if (factorOne < factorTwo) { 
//      int temp = factorOne;
//      factorOne = factorTwo;
//      factorTwo = temp;
//    }
//
//    if (factorOne < 0) factorOne = Math.abs(factorOne);
//    if (factorTwo < 0) factorTwo = Math.abs(factorTwo);
//
//    if (factorTwo == 0) {
//      return factorOne;
//    }
//    
//    return gdc(factorOne % factorTwo, factorTwo);
//
//  }
//
//}
