package it.unimi.di.prog2.e04;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * Vedi <a
 * href="https://github.com/mapio/labprog/blob/master/esercizi/somma_strana/Testo.md">testo</a>, ma
 * leggendo gli addendi dal flusso di ingresso.
 */
public class SommaStrana {

  /** . */
  private SommaStrana() {}

  public static void main(String[] args) {
    List<List<Integer>> numbersList = new ArrayList<>();
    
    try (Scanner s = new Scanner(System.in)) {
      int i = 0;
      while (s.hasNextLine()) {
        numbersList.add(new ArrayList<>());
        final char[] number = s.nextLine().toCharArray();
        for (char digit : number) {
          numbersList.get(i).add(digit - '0');
        }
        i++;
      }
    }

    //trovo lenght massima
    int lenghtMax = 0;
    for (List<Integer> numero : numbersList) {
      if (numero.size() > lenghtMax) {
        lenghtMax = numero.size();
      }
    }

    //a ogni numero aggiungo tanti 0 quanto la differenza tra numeor.size e lenghtMax
    for (List<Integer> numero : numbersList) {
      int difference = numero.size() - lenghtMax;
      while (difference < 0) {
        numero.addFirst(0);
        difference++;
      }
    }

    int riporto = 0;
    numbersList.add(new ArrayList<>()); //risultato
    for (int i=lenghtMax-1; i>=0; i--) {
      int result = numbersList.get(0).get(i) + numbersList.get(1).get(i) + riporto;
      if (result > 9) {
        result = 9 - (result - 10);
        riporto = 1;
      } else {
        riporto = 0;
      }
      numbersList.get(2).addFirst(result);
    }
    if (riporto == 1) {
      numbersList.get(2).addFirst(1);
    }
    
    //orribile ma ci accontentiamo
    System.out.println(numbersList.get(2).toString().replace("[", "").replace("]", "").replace(",", "").replace(" ", ""));
  }
}

      //ALTRA IMPLEMENTAZIONE

// import java.lang.String;
// import java.util.Scanner;

// public class SommaStrana {

//   /** . */ private SommaStrana() {}

//     /**
//      * append {@code filler}, {@code numerOfFiller} times, at the start of {@code string}
//      * @param string descrizion
//      * @param numerOfFiller > 0
//      * @param filler descrizione
//      * 
//      */
//     public static void leftFill(StringBuilder string, int numerOfFiller, String filler) {
//         StringBuilder repeatedChar = new StringBuilder().repeat(filler, numerOfFiller);
//         string.insert(0, repeatedChar);
//     }

    
//     /**
//      * modifies the shortest StringBuilder argument between (stringOne) and (stringTwo) filling it with character "0" to match the exact lenght
//      * of the longest StringBuilder
//      * if lenght of the arguments is not different, then no StringBuilder get modified
//      * 
//      * @param stringOne
//      * @param stringTwo
//      */
//     public static void rightIndent(StringBuilder stringOne, StringBuilder stringTwo) {
//         final int diffLength = Math.abs(stringOne.length() - stringTwo.length());
//         if (stringOne.length() > stringTwo.length()) {
//             leftFill(stringTwo, diffLength, "0");
//         } else if (stringOne.length() < stringTwo.length()) {
//             leftFill(stringOne, diffLength, "0");
//         }
//     }

//     /**
//      * require two integers > 0 from command line, compute and print on screen the outcome their "sommaStrana" 
//      * undeterministc output on inputs different from integers
//      * any input from "flusso di ingresso" is ignored
//      * 
//      * @param args 
//      */
//     public static void main(String[] args) {

//         StringBuilder numOne = null;
//         StringBuilder numTwo = null;
//         StringBuilder result = new StringBuilder();
//         try (Scanner s = new Scanner(System.in)) {
//             numOne = new StringBuilder(s.next());
//             numTwo = new StringBuilder(s.next());
//         }

//         rightIndent(numOne, numTwo);

//         boolean change = false; 
//         final int max = 9;
//         for (int i=numOne.length()-1 ; i>=0; i--) {
//             int sum = (numOne.charAt(i) - '0') + (numTwo.charAt(i) - '0');
//             if (change) {
//                 sum +=1;
//                 change = false;
//             }
//             if (sum > max) {
//                 sum = max - (sum - 10);
//                 change = true;                
//             }
//             result.append(sum);
//             if (i==0 && change) {
//                 result.append(1);
//             }
//         }

//         System.out.println(result.reverse());

//     }