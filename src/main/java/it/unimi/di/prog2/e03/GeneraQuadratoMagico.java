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

package it.unimi.di.prog2.e03;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeneraQuadratoMagico {

    public static void inBasso(int[][] quadrato, List<Integer> coordinate, int numero) {
        if (coordinate.get(1) == coordinate.get(0)-1) { //siamo nell'ultima riga
            coordinate.set(1, 0);
            quadrato[coordinate.get(1)][coordinate.get(2)] = numero;
        } else {
            coordinate.set(1, coordinate.get(1)+1);
            quadrato[coordinate.get(1)][coordinate.get(2)] = numero;
        }
    }

    public static boolean altoADestra(int[][] quadrato, List<Integer> coordinate, int numero) {

        //se siamo nella prima riga, devo scrivere nell'utlima spostandomi a dx di 1
        if (coordinate.get(1) == 0) {
            //siamo nell'angolo in alto a dx
            if (coordinate.get(2) == coordinate.get(0)-1) {
                if (quadrato[coordinate.get(0)-1][coordinate.get(0)-1] == 0) {
                    coordinate.set(1, coordinate.get(0)-1);
                    coordinate.set(2, 0);
                    quadrato[coordinate.get(1)][coordinate.get(2)] = numero;
                    return true;
                } else return false;
            } else if (quadrato[coordinate.get(0)-1][coordinate.get(2)+1] == 0) {
                coordinate.set(1, coordinate.get(0)-1);
                coordinate.set(2, coordinate.get(2)+1);
                quadrato[coordinate.get(1)][coordinate.get(2)] = numero;
                return true;
            } else return false;

        } else if (coordinate.get(2) == coordinate.get(0)-1) { //siamo nell'ultima colonna
            if (quadrato[coordinate.get(1)-1][0] == 0) {
                coordinate.set(1, coordinate.get(1)-1);
                coordinate.set(2, 0);
                quadrato[coordinate.get(1)][coordinate.get(2)] = numero;
                return true;
            } else return false;
        } else if (quadrato[coordinate.get(1)-1][coordinate.get(2)+1] == 0) {
            coordinate.set(1, coordinate.get(1)-1);
            coordinate.set(2, coordinate.get(2)+1);
            quadrato[coordinate.get(1)][coordinate.get(2)] = numero;
            return true;
        }

        return false;
    }

  public static void main(String[] args) {
    final int N = Integer.parseInt(args[0]);
    int[][] quadrato = new int[N][N];
    int riga = 0;
    int colonna = N/2;
    quadrato[riga][colonna] = 1;
    List<Integer> coordinate = new ArrayList<>(Arrays.asList(N, riga, colonna)); //accesso con list.get(), modifica con list.set
    
    for (int i = 2; i<=N*N; i++) {
        boolean libero = altoADestra(quadrato, coordinate, i);
        if (!libero) {
            inBasso(quadrato, coordinate, i);
        }
    }

    for (int[] rigaContenitore : quadrato) {
        for (int numero : rigaContenitore) {
            System.out.print(numero + " ");
        }
        System.out.println();
    }

  }

}