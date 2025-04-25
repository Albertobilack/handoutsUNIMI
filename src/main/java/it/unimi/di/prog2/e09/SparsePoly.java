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

package it.unimi.di.prog2.e09;

import it.unimi.di.prog2.h08.impl.NegativeExponentException;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

/**
 * {@code SparsePoly}s are immutable polynomials with integer coefficients such that the number of
 * nonzero coefficient is small with respect to the degree.
 *
 * <p>A typical {@code Poly} is \( p = c_0 + c_1 x + c_2 x^2 + \cdots + c_n x^n \).
 */
public class SparsePoly {

  /**
   * A record holding a non zero term of the polynomial.
   *
   * @param coeff the coefficient.
   * @param degree the degree.
   */
  public record Term(int coeff, int degree) {
    /**
     * Builds a term.
     *
     * @throws NegativeExponentException if if {@code degree} &lt; 0.
     * @throws IllegalArgumentException if {@code coeff} is == 0
     */
    public Term { // using the compact constructor
      if (degree < 0)
        throw new NegativeExponentException("A term cannot have a negative exponent.");
      if (coeff == 0) 
        throw new IllegalArgumentException("A term cannot have a zero coefficient.");
    }
  }

  /** The array of terms (in increasing non-zero degree). */
  private final List<Term> terms;

  /** Initializes this to be the zero polynomial, that is \( p = 0 \). */
  public SparsePoly() {
    terms = new ArrayList<Term>();
  }

  /**
   * Initializes this to be the polynomial \(p = cx^n\).
   *
   * @param c the coefficient.
   * @param n the degree.
   * @throws NegativeExponentException if {@code n} &lt; 0.
   */
  public SparsePoly(int c, int n) throws NegativeExponentException {
    if (n<0) throw new NegativeExponentException();
    terms = new ArrayList<Term>(1);
    terms.add(new Term(c, n));
  }

  /**
   * Returns the coefficient of the term of given exponent.
   *
   * @param d the exponent of the term to consider.
   * @return the coefficient of the considered term.
   */
  //ricordiamoci che poly è in ordine crescente qundi si potrebbe fare ricerca più efficente
  public int coeff(int d) { 
    for (Term monomial : terms) {
      if (monomial.degree() == d) return monomial.coeff();  
    }
    return 0; //sbagliato metterci un eccezione ? non abbiamo metodi per controllare se coppia coeff - exp esiste all'interno quindi direi di si
  }

  /**
   * Returns the degree of this polynomial.
   *
   * @return the largest exponent with a non-zero coefficient; returns 0 if this is the zero {@code
   *     Poly}.
   */
  //ricordiamoci che poly è in ordine crescente
  public int degree() {
    if (terms.isEmpty()) return 0;
    return terms.get(terms.size()-1).degree();
  }

  /**
   * Performs polynomial addition.
   *
   * <p>If \( p \) is this polynomial, returns \( p + q \).
   *
   * @param q the polynomial to add to this one.
   * @return the sum among this and the given polynomial.
   * @throws NullPointerException if {@code q} is {@code null}.
   */
  //poly deve essere in ordine crescente
  //ricordiamo che immutabile al di fuori dei suoi metodi ma posso mutarlo qua dentro
  //i campi di un record sono final
  public SparsePoly add(SparsePoly q) throws NullPointerException {
    if (q == null) throw new NullPointerException("cant perform addition on a null object");
    SparsePoly r = new SparsePoly(); //ricordiamo che contiene 0 in degree 0
    for(Term t : terms) {
      boolean flag = false;
      for(Term u : q.terms) {
        if (t.degree() == u.degree()) {
          int value = t.coeff() + u.coeff();
          if (value != 0) {
            r.terms.add(new Term(value, t.degree()));
          }
          flag = true;
        }
      }
      if (!flag) {
        r.terms.add(t); //sono oggetti quindi sto solo copiando il riferimento, ma sono final e immutabili quindi potrebbe anche essere giusto
      }
    }
    for(Term u : q.terms) {
      boolean flag = false;
      for (Term t : terms) {
        if (t.degree() == u.degree()) {
          flag = true;
        }
      }
      if (!flag)
        r.terms.add(u);
    }
    r.terms.sort(Comparator.comparingInt(t -> t.degree()));
    return r;
  }

  //IMPLEMENTAZIONE DI CHATGPT
    // public SparsePoly add(SparsePoly q) {
    //     Objects.requireNonNull(q, "q must not be null");

    //     // inizializzo il risultato come zero e poi svuoto il termine iniziale
    //     SparsePoly r = new SparsePoly();
    //     r.terms.clear();

    //     int i = 0, j = 0;
    //     List<Term> tThis = this.terms;
    //     List<Term> tQ    = q.terms;

    //     // merge lineare
    //     while (i < tThis.size() && j < tQ.size()) {
    //         Term t1 = tThis.get(i);
    //         Term t2 = tQ.get(j);

    //         if (t1.degree() < t2.degree()) {
    //             r.terms.add(t1);
    //             i++;
    //         } else if (t1.degree() > t2.degree()) {
    //             r.terms.add(t2);
    //             j++;
    //         } else {
    //             int sum = t1.coeff() + t2.coeff();
    //             if (sum != 0) {
    //                 r.terms.add(new Term(sum, t1.degree()));
    //             }
    //             i++; j++;
    //         }
    //     }
    //     // resto di this
    //     while (i < tThis.size()) {
    //         r.terms.add(tThis.get(i++));
    //     }
    //     // resto di q
    //     while (j < tQ.size()) {
    //         r.terms.add(tQ.get(j++));
    //     }

    //     // se risultasse vuoto (tutti i termini si sono annullati), reinserisco lo zero
    //     if (r.terms.isEmpty()) {
    //         r.terms.add(new Term(0, 0));
    //     }

    //     return r;
    // }


  /**
   * Performs polynomial multiplication.
   *
   * <p>If \( p \) is this polynomial, returns \( p q \).
   *
   * @param q the polynomial to multiply by this one.
   * @return the product among this and the given polynomial.
   * @throws NullPointerException if {@code q} is {@code null}.
   */
  public SparsePoly mul(SparsePoly q) throws NullPointerException {
    if (q == null) throw new NullPointerException("cannot perform multiplicaiton on a null SparsePoly");
    List<Term> parzialMultiplicationList = new ArrayList<Term>();
    SparsePoly r = new SparsePoly(); //ricordiamo che contiene 0 in degree 0
    for (Term t : terms) {
      for (Term u : q.terms) {
        int degree = t.degree() + u.degree(); 
        int coeff = t.coeff() * u.coeff();
        if (coeff != 0) {
          parzialMultiplicationList.add(new Term(coeff, degree));
        }
      }
    }
    for (Term t : parzialMultiplicationList) {
      int temp = t.coeff();
      for (Term u : parzialMultiplicationList) {
        if (u.degree() == t.degree() && u != t) {
          temp += u.coeff(); 
        }
      }
      boolean exists = false; //si può implementare meglio con un array seen o mettendolo nel ciclo precedente prima che calcoli il coeff
      for (Term term : r.terms) {
        if (term.degree() == t.degree()) {
          exists = true;
          break;
        }
      }
      if (!exists && temp != 0)
        r.terms.add(new Term(temp, t.degree()));
    }
    r.terms.sort(Comparator.comparingInt(t -> t.degree()));
    return r;
  }

  /**
   * Performs polynomial subtraction.
   *
   * <p>If \( p \) is this polynomial, returns \( p - q \).
   *
   * @param q the polynomial to subtract from this one.
   * @return the subtraction among this and the given polynomial.
   * @throws NullPointerException if {@code q} is {@code null}.
   */
  //poly deve essere in ordine crescente
  public SparsePoly sub(SparsePoly q) throws NullPointerException {
    if (q==null) throw new NullPointerException("cannot perform subtraction with a null poly");
    SparsePoly s = q.minus();
    return this.add(s);
  }

  /**
   * Returns the negate polynomial.
   *
   * <p>If \( p \) is this polynomial, returns \( -p \).
   *
   * @return this polynomial multiplied by \( -1 \).
   */
  //poly deve essere in ordine crescentes
  public SparsePoly minus() {
    SparsePoly r = new SparsePoly(); //contiene il monoimo 0,0
    for (Term s : terms) {
      r.terms.add(new Term(-(s.coeff()), s.degree()));
    }
    r.terms.sort(Comparator.comparingInt(t -> t.degree())); //per sicurezza
    return r;
  }


  // @Override
  // public boolean equals(Object x) {
  //   if (x == this) return true;
  //   if (!(x instanceof SparsePoly)) return false;
  //   SparsePoly y = (SparsePoly) x;
  //   if (y.degree() != degree()) return false; //controllo degree
  //   for (Term t : terms) if (y.coeff(t.degree) != t.coeff) return false;
  //   for (Term t : y.terms) if (this.coeff(t.degree) != t.coeff) return false;
  //   return true;
  // }

  // @Override
  // public int hashCode() {
  //   return terms.hashCode();
  // }

  // @Override
  // public String toString() {
    
  // }
}
