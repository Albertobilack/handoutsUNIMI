package it.unimi.di.prog2.e04;
import java.util.Scanner;

/**
 * Vedi <a
 * href="https://github.com/mapio/labprog/blob/master/esercizi/somma_strana/Testo.md">testo</a>, ma
 * leggendo gli addendi dal flusso di ingresso.
 */
public class SommaStrana {

  /** . */
  private SommaStrana() {

    try (Scanner s = new Scanner(System.in))

  }

  // Per memorizzare un elenco di interi si può usare list<Integer>, grazie
  // all'boxing automatico https://dev.java/learn/numbers-strings/autoboxing/
  // se la lista è stata dichiarata come
  //
  // List<Integer> interi = new ArrayList<>();
  //
  // sono legittime espressioni del tipo
  //
  // interi.add(3);
  // int y = interi.get(0);
  //
  // dove vengono messi e prelevati dalla lista degli int, non degli Integer.

}
