package it.unimi.di.prog2.e05;
/**
 * classe di utilità per calcolare il Gdc
 */
public class Gcd {
   
    /**  PLACEHOLDER */
    private Gcd() {}

    /** 
     * calcola il Gdc di due numeri.
     * 
     * @param firstNum .
     * @param secondNum .
     * @return il massimo comune divisore di {@code firstNum} e {@code secondNum}
     * 
     */
    public static int generateGdc(int firstNum, int secondNum) {

        //if (firstNum <= 0 || secondNum <= 0) throw new IllegalArgumentException();

        if (firstNum < secondNum) { 
          int temp = firstNum;
          firstNum = secondNum;
          secondNum = temp;
        }

        if (firstNum < 0) firstNum = Math.abs(firstNum);
        if (secondNum < 0) secondNum = Math.abs(secondNum);

        if (secondNum == 0) {
          return firstNum;
        }

        return generateGdc(secondNum, firstNum % secondNum);

    }

}
